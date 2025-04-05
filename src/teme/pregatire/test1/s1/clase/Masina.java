package teme.pregatire.test1.s1.clase;

public class Masina implements IMasina, Cloneable {

    private String modelMasina;
    private int anFabricatie;
    private String dimensiune = "200x200";

    public Masina(String modelMasina, int anFabricatie) {
        this.modelMasina = modelMasina;
        this.anFabricatie = anFabricatie;
    }

    @Override
    public String getModelMasina() {
        return modelMasina;
    }

    @Override
    public int getAnFabricatie() {
        return anFabricatie;
    }

    public Masina setDimensiune(String dimensiune) {
        this.dimensiune = dimensiune;
        return this;
    }
}
