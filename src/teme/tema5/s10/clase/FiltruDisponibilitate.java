package teme.tema5.s10.clase;

import java.util.ArrayList;
import java.util.List;

public class FiltruDisponibilitate extends FiltruAbstract {

    private boolean disponibil;
    private boolean aplicaFiltru;

    public FiltruDisponibilitate(boolean disponibil, boolean aplicaFiltru) {
        this.disponibil = disponibil;
        this.aplicaFiltru = aplicaFiltru;
    }

    @Override
    public List<Produs> filtreaza(List<Produs> produse) {
        // Dacă nu se dorește aplicarea filtrului, trecem mai departe fără filtrare
        if (!aplicaFiltru) {
            return filtreazaUrmator(produse);
        }

        List<Produs> rezultat = new ArrayList<>();
        for (Produs produs : produse) {
            if (produs.isDisponibil() == disponibil) {
                rezultat.add(produs);
            }
        }

        return filtreazaUrmator(rezultat);
    }
}
