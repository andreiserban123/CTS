package teme.tema5.s10.clase;

import java.util.List;

public abstract class FiltruAbstract implements ICautare {
    protected ICautare urmatorulFiltru;

    @Override
    public void setUrmatorulFiltru(ICautare urmatorulFiltru) {
        this.urmatorulFiltru = urmatorulFiltru;
    }

    protected List<Produs> filtreazaUrmator(List<Produs> produse) {
        if (urmatorulFiltru != null) {
            return urmatorulFiltru.filtreaza(produse);
        }
        return produse;
    }
}
