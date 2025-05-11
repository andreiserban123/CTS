package teme.tema5.s7.clase;

import java.util.ArrayList;
import java.util.List;

public class Comanda implements IComanda {
    private static int id = 0;
    private List<Produs> produse;
    private Distanta distanta;

    public Comanda() {
        this.produse = new ArrayList<>();
        id++;
    }

    @Override
    public double calculTotal() {
        double total = 0;
        for (Produs produs : produse) {
            total += produs.getPrice();
        }
        if (distanta == Distanta.MICA) {
            total += 5;
        } else if (distanta == Distanta.MARE) {
            total += 10;
        }
        return total;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void addProdus(Produs produs) {
        this.produse.add(produs);
    }
}
