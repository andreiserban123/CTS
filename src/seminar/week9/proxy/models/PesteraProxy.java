package seminar.week9.proxy.models;

import java.util.ArrayList;
import java.util.List;

public class PesteraProxy implements IPestera {

    private Pestera pestera;
    private List<String> numeVzitatori;

    public PesteraProxy(Pestera pestera) {
        this.pestera = pestera;
        this.numeVzitatori = new ArrayList<>();
    }

    @Override
    public void vizitare(String nume) {
        this.numeVzitatori.add(nume);
        System.out.println("\t" + nume + " e in lista de asteptare.");
        if (this.numeVzitatori.size() == 5) {
            System.out.println("\t incepem vizita");
            for (String numeVizitator : this.numeVzitatori) {
                this.pestera.vizitare(numeVizitator);
            }
            this.numeVzitatori.clear();
        }
    }

    @Override
    public int getNrVizitatori() {
        return this.pestera.getNrVizitatori();
    }
}
