package seminar.week5.singletonRegistry.models;

public class Dish {
    private String name;
    private int minutes;
    private int temperature;
    public Dish(String name, int minutes, int temperature) {
        this.name = name;
        this.minutes = minutes;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", minutes=" + minutes +
                ", temperature=" + temperature +
                '}';
    }
}
