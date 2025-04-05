package teme.pregatire.test1.s4.clase;

import java.util.ArrayList;
import java.util.List;

public class Animal extends Personaj {

    public Animal(List<String> mesaje, Pozitie pozitie) {
        super(mesaje, pozitie);
    }


    @Override
    public String toString() {
        return "Animal" + super.getMesaje() + " " + super.getPozitie();
    }

    @Override
    protected Personaj clone() throws CloneNotSupportedException {
        var clone = super.clone();
        clone.setMesaje(new ArrayList<>(clone.getMesaje()));
        return clone;
    }
}
