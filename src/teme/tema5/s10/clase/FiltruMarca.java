package teme.tema5.s10.clase;

import java.util.List;
import java.util.stream.Collectors;

public class FiltruMarca extends FiltruAbstract {
    private String marca;

    public FiltruMarca(String marca) {
        super();
        if (marca != null && !marca.isEmpty()) {
            this.marca = marca;
            this.estePametrizat = true;
        }
    }

    @Override
    protected List<Pantof> aplicaFiltru(List<Pantof> produse) {
        System.out.println("Aplicare filtru după marcă: " + marca);
        return produse.stream()
                .filter(p -> p.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    @Override
    public String getDescriereFiltru() {
        return estePametrizat ? "Filtru marcă: " + marca : "Filtru marcă: nepametrizat";
    }
}
