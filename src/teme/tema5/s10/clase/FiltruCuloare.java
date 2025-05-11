package teme.tema5.s10.clase;

import java.util.List;

public class FiltruCuloare extends FiltruAbstract {
    private String culoare;

    public FiltruCuloare(String culoare) {
        this.culoare = culoare;
    }

    @Override
    public List<Produs> filtreaza(List<Produs> produse) {
        if (culoare == null || culoare.isEmpty()) {
            return filtreazaUrmator(produse);
        }
        List<Produs> produseFiltrate = produse.stream()
                .filter(p -> p.getCuloare().equalsIgnoreCase(culoare))
                .toList();
        return filtreazaUrmator(produseFiltrate);
    }
}
