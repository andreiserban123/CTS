package seminar.week9.proxy.models;

public class Pestera implements IPestera {

    private int nrVizitatori;

    @Override
    public void vizitare(String nume) {
        this.nrVizitatori++;
        System.out.println(nume + " a intrat in pestera.");
    }

    @Override
    public int getNrVizitatori() {
        return this.nrVizitatori;
    }
}
