package seminar.week5.singletonRegistry.program;

import seminar.week5.singletonRegistry.models.Dish;
import seminar.week5.singletonRegistry.models.Oven;

public class Main {
    public static void main(String[] args) {
        Oven.createOven(200);
        Oven.createOven(250);
        Oven.createOven(300);
        Oven.createOven(350);

        var list = Oven.getOvensRegistry();

        Oven.addDish(new Dish("Pizza", 30, 300));
        Oven.addDish(new Dish("Pizza", 30, 300));
        Oven.addDish(new Dish("Pizza", 180, 300));
        Oven.addDish(new Dish("Pizza", 20, 300));
        Oven.addDish(new Dish("Pizza", 20, 300));

        list.forEach(System.out::println);

    }
}