package teme.tema5.s10.clase;

import java.util.List;

public class FiltruMarime extends FiltruAbstract {
    private int marime;

    public FiltruMarime(int marime) {
        this.marime = marime;
    }

    
    @Override
    public List<Produs> filtreaza(List<Produs> produse) {
        if (marime <= 0) {
            return produse;
        }
        List<Produs> produseFiltrate = produse.stream()
                .filter(p -> p.getMarime() == marime)
                .toList();
        return produseFiltrate;
    }
}
