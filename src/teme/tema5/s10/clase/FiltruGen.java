package teme.tema5.s10.clase;

import java.util.List;

public class FiltruGen extends FiltruAbstract {
    private String gen;

    public FiltruGen(String gen) {
        this.gen = gen;
    }

    @Override
    public List<Produs> filtreaza(List<Produs> produse) {
        if (gen == null || gen.isEmpty()) {
            return filtreazaUrmator(produse);
        }
        List<Produs> produseFiltrate = produse.stream()
                .filter(p -> p.getGen().equalsIgnoreCase(gen))
                .toList();
        return filtreazaUrmator(produseFiltrate);
    }
}
