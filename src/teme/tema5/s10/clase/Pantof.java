package teme.tema5.s10.clase;

public class Pantof {
    private int id;
    private String marca;
    private String model;
    private double pret;
    private int marime;
    private String culoare;
    private String gen; // barbati/femei/unisex
    private String material;
    private boolean esteInStoc;

    public Pantof(int id, String marca, String model, double pret, int marime,
                  String culoare, String gen, String material, boolean esteInStoc) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.pret = pret;
        this.marime = marime;
        this.culoare = culoare;
        this.gen = gen;
        this.material = material;
        this.esteInStoc = esteInStoc;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
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

    public String getMaterial() {
        return material;
    }

    public boolean isEsteInStoc() {
        return esteInStoc;
    }

    @Override
    public String toString() {
        return "Pantof [id=" + id + ", marca=" + marca + ", model=" + model + ", pret=" + pret + ", marime=" + marime
                + ", culoare=" + culoare + ", gen=" + gen + ", material=" + material + ", esteInStoc=" + esteInStoc + "]";
    }
}