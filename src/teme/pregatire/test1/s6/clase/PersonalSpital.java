package teme.pregatire.test1.s6.clase;

public abstract class PersonalSpital {
    private String nume;
    private TipPersonal tip;

    PersonalSpital() {
    }

    PersonalSpital(TipPersonal tip) {
        this.tip = tip;
        this.nume = "default";
    }

    public abstract void afisareTip();

    @Override
    public String toString() {
        return "PersonalSpital{" +
                "nume='" + nume + '\'' +
                ", tip=" + tip +
                '}';
    }
}
