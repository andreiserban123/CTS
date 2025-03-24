package seminar.week5.singletonRegistry.models;

import java.util.ArrayList;
import java.util.List;

public class Oven {
    //   singleton instance
    private static Oven instance;

    // singleton data
    private static int idNext = 1;
    private int id;
    public final int MAX_TEMPERATURE;
    private List<Dish> dishes;

    static {
//        simulation
        instance = new Oven(300);
    }

    private Oven(int maxTemp) {
        MAX_TEMPERATURE = maxTemp;
        dishes = new ArrayList<>();
        this.id = idNext++;
    }

    public static Oven getInstance() {
        return instance;
    }

    public void addDish(Dish dish) {
        if (dish.getTemperature() <= MAX_TEMPERATURE) {
            dishes.add(dish);
        } else {
            throw new IllegalArgumentException("Dish exceeds maximum temperature");
        }
    }

    @Override
    public String toString() {
        return "Oven{" +
                "id=" + id +
                ", MAX_TEMPERATURE=" + MAX_TEMPERATURE +
                ", dishes=" + dishes +
                '}';
    }
}
