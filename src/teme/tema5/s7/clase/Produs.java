package teme.tema5.s7.clase;

public class Produs implements IProdus {
    private String denumire;
    private double price;
    private int stoc;

    public Produs(String denumire, double price, int stoc) {
        this.denumire = denumire;
        this.price = price;
        this.stoc = stoc;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Produs: " + denumire + ", Stoc: " + stoc);
    }

    @Override
    public int getNumarProduse() {
        return this.stoc;
    }

}
