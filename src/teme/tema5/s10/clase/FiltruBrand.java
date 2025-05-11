package teme.tema5.s10.clase;

import java.util.List;

public class FiltruBrand extends FiltruAbstract {

    private String brand;

    public FiltruBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public List<Produs> filtreaza(List<Produs> produse) {
        if (brand == null || brand.isEmpty()) {
            return filtreazaUrmator(produse);
        }
        List<Produs> produseFiltrate = produse.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .toList();
        return filtreazaUrmator(produseFiltrate);
    }
}
