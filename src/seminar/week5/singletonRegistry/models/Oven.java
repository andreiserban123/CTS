package seminar.week5.singletonRegistry.models;

import java.util.ArrayList;
import java.util.List;

public class Oven {
    private static int idNext = 1;
    public final int MAX_TEMPERATURE;
    private int id;
    private List<Dish> dishes;

    public Oven(int maxTemp) {
        MAX_TEMPERATURE = maxTemp;
        dishes = new ArrayList<>();
        this.id = idNext++;
    }

    public int getId() {
        return id;
    }

    public void addDish(Dish dish) {
        if (dish.getTemperature() <= MAX_TEMPERATURE) {
            dishes.add(dish);
        } else {
            throw new IllegalArgumentException("Dish exceeds maximum temperature");
        }
    }

    public int getTotalCookingMinutes() {
        int totalMinutes = 0;
        for (Dish dish : dishes) {
            totalMinutes += dish.getMinutes();
        }
        return totalMinutes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return "Oven{" +
                "id=" + id +
                ", MAX_TEMPERATURE=" + MAX_TEMPERATURE +
                ", dishes=" + dishes +
                ", totalCookingMinutes=" + getTotalCookingMinutes() +
                '}';
    }
}