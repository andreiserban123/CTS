package tema2;

public class LinieComanda {
    private final Preparat preparat;
    private final int cantitate;

    public LinieComanda(Preparat preparat, int cantitate) {
        this.preparat = preparat;
        this.cantitate = cantitate;
    }

    public Preparat getPreparat() {
        return preparat;
    }

    public int getCantitate() {
        return cantitate;
    }

    @Override
    public String toString() {
        return preparat.getNume() + " x " + cantitate;
    }
}
