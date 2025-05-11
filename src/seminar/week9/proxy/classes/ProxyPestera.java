package seminar.week9.proxy.classes;

import java.util.ArrayList;
import java.util.List;

public class ProxyPestera implements IPestera {
    private Pestera pestera;
    private List<String> vizitatori;

    public ProxyPestera(Pestera pestera) {
        this.pestera = pestera;
        this.vizitatori = new ArrayList<>();
    }

    @Override
    public void vizitare(String nume) {
        vizitatori.add(nume);
        if (vizitatori.size() == 5) {
            System.out.println("Grup vizitare");
            for (var viz : vizitatori) {
                pestera.vizitare(viz);
            }
            vizitatori.clear();
        }
    }

    @Override
    public int getNrVizitatori() {
        return pestera.getNrVizitatori();
    }
}
