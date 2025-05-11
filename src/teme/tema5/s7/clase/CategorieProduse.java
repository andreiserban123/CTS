package teme.tema5.s7.clase;

import java.util.ArrayList;
import java.util.List;

public class CategorieProduse implements IProdus {

    private String denumire;
    private List<IProdus> produse = new ArrayList<>();

    public CategorieProduse(String denumire) {
        this.denumire = denumire;
    }

    public void adaugaProdus(IProdus produs) {
        this.produse.add(produs);
    }

    public void stergeProdus(IProdus produs) {
        this.produse.remove(produs);
    }

    @Override
    public void afiseazaDetalii() {

        System.out.println("Categorie: " + denumire);
        for (IProdus produs : produse) {
            produs.afiseazaDetalii();
        }
    }

    @Override
    public int getNumarProduse() {
        int nrProduse = 0;
        for (IProdus produs : produse) {
            nrProduse += produs.getNumarProduse();
        }
        return nrProduse;
    }
}
