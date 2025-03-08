package tema2;

import java.util.Collections;
import java.util.List;

public class Preparat {
    private final String nume;
    private final List<Ingredient> ingrediente;
    private final double pret;

    public Preparat(String nume, List<Ingredient> ingrediente, double pret) {
        this.nume = nume;
        this.ingrediente = ingrediente;
        this.pret = pret;
    }
    public String getNume() {
        return nume;
    }

    public List<Ingredient> getIngrediente() {
        return Collections.unmodifiableList(ingrediente);
    }

    public double getPret() {
        return pret;
    }
    @Override
    public String toString() {
        return nume + " (" + pret + " RON)";
    }
}
