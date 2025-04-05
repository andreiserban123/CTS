package teme.pregatire.test1.s2.clase;

public class Senzor implements AbstractAirQualitySensor {
    private int pm25;
    private int pm10;
    private int voc;
    private int co2;
    private int co;
    private int temperatura;

    Senzor(int pm25, int pm10, int voc, int co2, int co, int temperatura) {
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.voc = voc;
        this.co2 = co2;
        this.co = co;
        this.temperatura = temperatura;
    }

    @Override
    public void afisareTemperatura() {
        System.out.println("Temperatura: " + temperatura);
    }
}
