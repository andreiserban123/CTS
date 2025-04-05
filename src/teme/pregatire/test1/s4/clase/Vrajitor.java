package teme.pregatire.test1.s4.clase;

import java.util.List;

public class Vrajitor extends Personaj {

    Vrajitor(List<String> mesaje, Pozitie pozitie) {
        super(mesaje, pozitie);
    }

    @Override
    public boolean verificaProximitate(Canvas c) {
        var lista = c.getPersonajList();
        boolean ok = false;
        for (var personaj : lista) {
            if (personaj != this) {
                var distanta = c.calculareDistanta(super.getPozitie(), personaj.getPozitie());
                if (distanta < PROXIMITATE) {
                    this.addMesaj(personaj.spuneCeva());
                    ok = true;
                }
            }
        }
        return ok;
    }

    @Override
    public String toString() {
        return "Vrajitor" + super.getMesaje() + " " + super.getPozitie();
    }
}
