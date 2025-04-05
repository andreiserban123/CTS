package teme.pregatire.test1.s4.clase;

import java.util.Collections;
import java.util.List;

public abstract class Personaj implements Cloneable {
    protected static final int PROXIMITATE = 20;
    private List<String> mesaje;
    private Pozitie pozitie;

    public Personaj(List<String> mesaje, Pozitie pozitie) {
        this.mesaje = mesaje;
        this.pozitie = pozitie;
    }

    public List<String> getMesaje() {
        return mesaje;
    }

    public Personaj setMesaje(List<String> mesaje) {
        this.mesaje = mesaje;
        return this;
    }

    protected void addMesaj(String mesaje) {
        this.mesaje.add(mesaje);
    }

    protected Pozitie getPozitie() {
        return pozitie;
    }

    public boolean verificaProximitate(Canvas c) {
        var lista = c.getPersonajList();
        for (var personaj : lista) {
            if (personaj != this) {
                var distanta = c.calculareDistanta(pozitie, personaj.getPozitie());
                if (distanta < PROXIMITATE) {
                    return true;
                }
            }
        }
        return false;
    }

    public String spuneCeva() {
        Collections.shuffle(mesaje);
        return mesaje.getFirst();
    }

    @Override
    protected Personaj clone() throws CloneNotSupportedException {
        return (Personaj) super.clone();
    }
}
