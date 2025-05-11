package seminar.week7.builder.clase;

public class Sensor implements AbstractAirQualitySensor {

    private int pm10;
    private int temp;
    private int humidity;
    private int pm2_5;

    Sensor(int pm10, int temp, int humidity, int pm2_5) {
        this.pm10 = pm10;
        this.temp = temp;
        this.humidity = humidity;
        this.pm2_5 = pm2_5;
    }

    @Override
    public int getPm10() {
        return this.pm10;
    }

    void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    @Override
    public int getTemperature() {
        return this.temp;
    }

    @Override
    public int getHumidity() {
        return this.humidity;
    }

    void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public int getPm2_5() {
        return this.pm2_5;
    }

    void setPm2_5(int pm2_5) {
        this.pm2_5 = pm2_5;
    }

    void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "pm10=" + pm10 +
                ", temp=" + temp +
                ", humidity=" + humidity +
                ", pm2_5=" + pm2_5 +
                '}';
    }
}
