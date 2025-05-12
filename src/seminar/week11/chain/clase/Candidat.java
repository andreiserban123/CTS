package seminar.week11.chain.clase;

public class Candidat {
    private String nume;
    private String eseu;
    private double notaBac;
    private double notaAdmitere;

    public Candidat(String nume, String eseu, double notaBac, double notaAdmitere) {
        this.nume = nume;
        this.eseu = eseu;
        this.notaBac = notaBac;
        this.notaAdmitere = notaAdmitere;
    }

    public String getNume() {
        return nume;
    }

    public String getEseu() {
        return eseu;
    }

    public double getNotaBac() {
        return notaBac;
    }

    public double getNotaAdmitere() {
        return notaAdmitere;
    }
}
