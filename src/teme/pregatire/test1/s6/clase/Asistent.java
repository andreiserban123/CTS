package teme.pregatire.test1.s6.clase;

public class Asistent extends PersonalSpital {
    Asistent() {
    }

    Asistent(TipPersonal tip) {
        super(tip);
    }

    @Override
    public void afisareTip() {
        System.out.println("Asistent");
    }
}
