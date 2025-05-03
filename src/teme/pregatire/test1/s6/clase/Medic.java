package teme.pregatire.test1.s6.clase;

public class Medic extends PersonalSpital {
    Medic() {
    }

    Medic(TipPersonal tip) {
        super(tip);
    }

    @Override
    public void afisareTip() {
        System.out.println("Medic");
    }
}
