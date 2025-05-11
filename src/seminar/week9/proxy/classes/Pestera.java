package seminar.week9.proxy.classes;

public class Pestera implements IPestera {

    private int nrVizitatori = 0;

    @Override
    public void vizitare(String nume) {
        System.out.println(nume + " a vizitat pestera");
        nrVizitatori++;
    }

    @Override
    public int getNrVizitatori() {
        return nrVizitatori;
    }
}
