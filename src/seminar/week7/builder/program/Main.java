package seminar.week7.builder.program;

import seminar.week7.builder.clase.BuilderSensor;
import seminar.week7.builder.clase.Sensor;

public class Main {
    public static void main(String[] args) {
        BuilderSensor builder = new BuilderSensor(20);
        Sensor sensor = (Sensor) builder
                .setHumidity(10)
                .setPm2_5(5)
                .build();

        System.out.println(sensor);
        Sensor sensor1 = (Sensor) builder.setHumidity(5).build();
        System.out.println(sensor1);
        Sensor sensor2 = (Sensor) new BuilderSensor(30)
                .setHumidity(3)
                .build();
        System.out.println(sensor2);
    }
}
