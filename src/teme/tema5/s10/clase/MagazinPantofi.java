package teme.tema5.s10.clase;

import java.util.ArrayList;
import java.util.List;

public class MagazinPantofi {

    private List<Produs> produse = new ArrayList<>();
    private ICautare primulFiltru;


    public void adaugaProdus(Produs produs) {
        produse.add(produs);
        System.out.println("Produs adaugat: " + produs);
    }


    public void setPrimulFiltru(ICautare filtru) {
        this.primulFiltru = filtru;
    }

    public List<Produs> cautaProduse() {
        if (primulFiltru == null) {
            return produse;
        }
        return primulFiltru.filtreaza(produse);
    }

    public List<Produs> getToateProdusele() {
        return new ArrayList<>(produse);
    }
}
