package teme.tema5.s10.clase;

import java.util.List;

public class FiltruPretMaxim extends FiltruAbstract {
    private double pretMaxim;

    public FiltruPretMaxim(double pretMaxim) {
        this.pretMaxim = pretMaxim;
    }

    @Override
    public List<Produs> filtreaza(List<Produs> produse) {
        if (pretMaxim <= 0) {
            return filtreazaUrmator(produse);
        }
        List<Produs> produseFiltrate = produse.stream()
                .filter(p -> p.getPret() <= pretMaxim)
                .toList();
        return filtreazaUrmator(produseFiltrate);
    }
}
