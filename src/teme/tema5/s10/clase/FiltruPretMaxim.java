package teme.tema5.s10.clase;

import java.util.List;
import java.util.stream.Collectors;

public class FiltruPretMaxim extends FiltruAbstract {
    private double pretMaxim;

    public FiltruPretMaxim(double pretMaxim) {
        super();
        if (pretMaxim > 0) {
            this.pretMaxim = pretMaxim;
            this.estePametrizat = true;
        }
    }

    @Override
    protected List<Pantof> aplicaFiltru(List<Pantof> produse) {
        System.out.println("Aplicare filtru preț maxim: " + pretMaxim);
        return produse.stream()
                .filter(p -> p.getPret() <= pretMaxim)
                .collect(Collectors.toList());
    }

    @Override
    public String getDescriereFiltru() {
        return estePametrizat ? "Filtru preț maxim: " + pretMaxim : "Filtru preț maxim: nepametrizat";
    }
}
