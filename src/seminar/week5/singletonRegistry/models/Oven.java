package seminar.week5.singletonRegistry.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Oven {
    public static final int MAX_NR_OF_INSTANCES = 4;
    private static List<Oven> ovens = new ArrayList<>();
    private static int idNext = 1;
    private int id;
    private List<Dish> dishes;
    private int maxTemperature;

    private Oven(int maxTemp) {
        if (ovens.size() >= MAX_NR_OF_INSTANCES) {
            throw new IllegalStateException("Maximum number of ovens reached");
        }
        this.maxTemperature = maxTemp;
        dishes = new ArrayList<>();
        this.id = idNext++;
    }

    public static List<Oven> getOvensRegistry() {
        return Collections.unmodifiableList(ovens);
    }

    public static void createOven(int maxTemp) {
        Oven oven = new Oven(maxTemp);
        ovens.add(oven);
    }

    public static void addDish(Dish dish) {
        if (ovens.isEmpty()) {
            throw new IllegalStateException("No ovens available");
        }
        var lowestTimeOven = ovens.stream()
                .filter(o -> o.maxTemperature >= dish.getTemperature())
                .min(Comparator.comparingInt(Oven::getTotalCookingMinutes))
                .orElseThrow(() -> new IllegalStateException("No suitable oven found"));
        lowestTimeOven.dishes.add(dish);
    }

    public int getId() {
        return id;
    }

    public int getTotalCookingMinutes() {
        int totalMinutes = 0;
        for (Dish dish : dishes) {
            totalMinutes += dish.getMinutes();
        }
        return totalMinutes;
    }

    @Override
    public String toString() {
        return "Oven{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}