package teme.pregatire.test1.s6.clase;

public class Brancardier extends PersonalSpital {
    Brancardier() {
    }

    Brancardier(TipPersonal tip) {
        super(tip);
    }

    @Override
    public void afisareTip() {
        System.out.println("Brancardier");
    }
}
