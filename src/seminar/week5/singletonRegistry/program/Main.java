package seminar.week5.singletonRegistry.program;

import seminar.week5.singletonRegistry.models.Dish;
import seminar.week5.singletonRegistry.models.Oven;

public class Main {
    public static void main(String[] args) {
        Oven singleton = Oven.getInstance();
        singleton.addDish(new Dish("pizza", 60, 150));
        System.out.println(singleton);
    }
}
