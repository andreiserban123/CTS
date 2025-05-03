package teme.pregatire.test1.s6.clase;

public class Pacient {
    private String nume;

    private boolean patRabatabil;
    private boolean micDejun;
    private boolean papuci;
    private boolean halat;

    Pacient(String nume, boolean patRabatabil, boolean micDejun, boolean papuci, boolean halat) {
        this.nume = nume;
        this.patRabatabil = patRabatabil;
        this.micDejun = micDejun;
        this.papuci = papuci;
        this.halat = halat;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "nume='" + nume + '\'' +
                ", patRabatabil=" + patRabatabil +
                ", micDejun=" + micDejun +
                ", papuci=" + papuci +
                ", halat=" + halat +
                '}';
    }
}
