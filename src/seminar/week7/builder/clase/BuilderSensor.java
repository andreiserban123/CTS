package seminar.week7.builder.clase;

public class BuilderSensor implements IBuilder {
    // private Sensor sensor; // Obiectul construit

    private int pm10;
    private int temp;
    private int humidity;
    private int pm2_5;

    //    Primim ca param. zona obligatorie a obiectului
    public BuilderSensor(int temp) {
        this.temp = temp;
    }

//    se adauga setter pentru fiecare camp optional


    public BuilderSensor setPm10(int pm10) {
        this.pm10 = pm10;
        return this;
    }

    public BuilderSensor setTemp(int temp) {
        this.temp = temp;
        return this;
    }

    public BuilderSensor setHumidity(int humidity) {
        this.humidity = humidity;
        return this;
    }

    public BuilderSensor setPm2_5(int pm2_5) {
        this.pm2_5 = pm2_5;
        return this;
    }

    @Override
    public AbstractAirQualitySensor build() {
        Sensor sensor = new Sensor(pm10, temp, humidity, pm2_5);
        this.humidity = 0;
        this.pm10 = 0;
        this.pm2_5 = 0;
        return sensor;
    }

}
