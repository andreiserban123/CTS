package teme.tema5.s10.clase;

import java.util.List;

public interface ICautare {
    void setSuccesor(ICautare succesor);

    List<Pantof> filtreazaProduse(List<Pantof> produse);

    String getDescriereFiltru();
}
