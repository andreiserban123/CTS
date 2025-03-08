package tema2;

class Ingredient {
    private final MateriePrima materiePrima;
    private final double cantitate;

    public Ingredient(MateriePrima materiePrima, double cantitate) {
        this.materiePrima = materiePrima;
        this.cantitate = cantitate;
    }

    public MateriePrima getMateriePrima() {
        return materiePrima;
    }

    public double getCantitate() {
        return cantitate;
    }

    @Override
    public String toString() {
        return materiePrima.getNume() + " - " + cantitate + " " + materiePrima.getUnitateMasura();
    }
}