package teme.pregatire.test1.s4.clase;

import java.util.ArrayList;
import java.util.List;

public class Erou extends Personaj {

    Erou(List<String> mesaje, Pozitie pozitie) {
        super(mesaje, pozitie);
    }


    @Override
    protected Personaj clone() throws CloneNotSupportedException {
        var clone = super.clone();
        clone.setMesaje(new ArrayList<>(clone.getMesaje()));
        return clone;
    }

    @Override
    public String toString() {
        return "Erou " + super.getMesaje() + " " + super.getPozitie();
    }
}
