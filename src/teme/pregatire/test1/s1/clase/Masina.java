package teme.pregatire.test1.s1.clase;

public class Masina implements IMasina, Cloneable {

    private String modelMasina;
    private int anFabricatie;
    private String dimensiuni;

    public Masina(String modelMasina, int anFabricatie, String dimensiuni) {
        this.modelMasina = modelMasina;
        this.anFabricatie = anFabricatie;
        this.dimensiuni = dimensiuni;
    }

    @Override
    public String getModelMasina() {
        return modelMasina;
    }

    @Override
    public int getAnFabricatie() {
        return anFabricatie;
    }

    public String getDimensiuni() {
        return dimensiuni;
    }
}
