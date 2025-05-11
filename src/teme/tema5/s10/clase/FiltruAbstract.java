package teme.tema5.s10.clase;

import java.util.List;

public abstract class FiltruAbstract implements ICautare {
    protected ICautare succesor;
    protected boolean estePametrizat;

    public FiltruAbstract() {
        this.estePametrizat = false;
    }

    @Override
    public void setSuccesor(ICautare succesor) {
        this.succesor = succesor;
    }

    protected List<Pantof> transmiteLaSuccesor(List<Pantof> produse) {
        if (succesor != null) {
            return succesor.filtreazaProduse(produse);
        }
        return produse;
    }

    @Override
    public List<Pantof> filtreazaProduse(List<Pantof> produse) {
        if (!estePametrizat) {
            System.out.println("Filtrul " + this.getClass().getSimpleName() + " nu este parametrizat. Se ignoră.");
            return transmiteLaSuccesor(produse);
        }

        List<Pantof> produseFiltrateLocal = aplicaFiltru(produse);
        return transmiteLaSuccesor(produseFiltrateLocal);
    }

    protected abstract List<Pantof> aplicaFiltru(List<Pantof> produse);
}