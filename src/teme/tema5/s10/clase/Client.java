package teme.tema5.s10.clase;

public class Client implements IClient {
    private StrategieParametrizare strategieParametrizare;

    public Client() {
        this.strategieParametrizare = new StrategieImplicita();
    }

    public void setStrategieParametrizare(StrategieParametrizare strategieParametrizare) {
        this.strategieParametrizare = strategieParametrizare;
    }

    @Override
    public ICautare alegeParametrizareCautare() {
        return strategieParametrizare.creeazaParametrizare();
    }
}
