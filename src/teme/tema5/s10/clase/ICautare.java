package teme.tema5.s10.clase;

import java.util.List;

public interface ICautare {

    List<Produs> filtreaza(List<Produs> produse);

    void setUrmatorulFiltru(ICautare urmatorulFiltru);
}
