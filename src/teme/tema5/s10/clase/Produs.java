package teme.tema5.s10.clase;

class Produs {
    private String nume;
    private String brand;
    private double pret;
    private int marime;
    private String culoare;
    private String gen;
    private boolean disponibil;

    public Produs(String nume, String brand, double pret, int marime, String culoare, String gen, boolean disponibil) {
        this.nume = nume;
        this.brand = brand;
        this.pret = pret;
        this.marime = marime;
        this.culoare = culoare;
        this.gen = gen;
        this.disponibil = disponibil;
    }

    // Getteri
    public String getNume() {
        return nume;
    }

    public String getBrand() {
        return brand;
    }

    public double getPret() {
        return pret;
    }

    public int getMarime() {
        return marime;
    }

    public String getCuloare() {
        return culoare;
    }

    public String getGen() {
        return gen;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    @Override
    public String toString() {
        return "Produs: " + nume + ", Brand: " + brand + ", Pret: " + pret +
                ", Marime: " + marime + ", Culoare: " + culoare +
                ", Gen: " + gen + ", Disponibil: " + disponibil;
    }
}
