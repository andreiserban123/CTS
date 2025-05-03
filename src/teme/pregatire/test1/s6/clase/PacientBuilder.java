package teme.pregatire.test1.s6.clase;

public class PacientBuilder implements IBuilder {
    private String nume;

    private boolean patRabatabil;
    private boolean micDejun;
    private boolean papuci;
    private boolean halat;

    public PacientBuilder(String nume) {
        this.nume = nume;
    }

    public PacientBuilder setPatRabatabil(boolean patRabatabil) {
        this.patRabatabil = patRabatabil;
        return this;
    }

    public PacientBuilder setMicDejun(boolean micDejun) {
        this.micDejun = micDejun;
        return this;
    }

    public PacientBuilder setPapuci(boolean papuci) {
        this.papuci = papuci;
        return this;
    }

    public PacientBuilder setHalat(boolean halat) {
        this.halat = halat;
        return this;
    }


    private void reset() {
        this.patRabatabil = false;
        this.micDejun = false;
        this.papuci = false;
        this.halat = false;
    }

    @Override
    public Pacient build() {
        var pac = new Pacient(nume, patRabatabil, micDejun, papuci, halat);
        reset();
        return pac;
    }
}
