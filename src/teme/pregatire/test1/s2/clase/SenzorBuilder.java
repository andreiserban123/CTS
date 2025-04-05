package teme.pregatire.test1.s2.clase;

public class SenzorBuilder implements IBuilder {
    private int pm25;
    private int pm10;
    private int voc;
    private int co2;
    private int co;
    private int temperatura;

    public SenzorBuilder(int temperatura) {
        this.temperatura = temperatura;
    }

    public SenzorBuilder setPm25(int pm25) {
        this.pm25 = pm25;
        return this;
    }

    public SenzorBuilder setPm10(int pm10) {
        this.pm10 = pm10;
        return this;
    }

    public SenzorBuilder setVoc(int voc) {
        this.voc = voc;
        return this;
    }

    public SenzorBuilder setCo2(int co2) {
        this.co2 = co2;
        return this;
    }

    public SenzorBuilder setCo(int co) {
        this.co = co;
        return this;
    }

    public SenzorBuilder setTemperatura(int temperatura) {
        this.temperatura = temperatura;
        return this;
    }

    @Override
    public Senzor build() {
        return new Senzor(pm25, pm10, voc, co2, co, temperatura);
    }
}
