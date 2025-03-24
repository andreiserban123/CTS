package seminar.week5.singletonRegistry.program;

import seminar.week5.singletonRegistry.models.Dish;
import seminar.week5.singletonRegistry.models.Kitchen;
import seminar.week5.singletonRegistry.models.Oven;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = Kitchen.getInstance();

        System.out.println("Initial ovens in the kitchen:");
        List<Oven> allOvens = kitchen.getAllOvens();
        for (Oven oven : allOvens) {
            System.out.println(oven);
        }

        Dish pizza = new Dish("Pizza", 20, 250);
        Dish cake = new Dish("Cake", 45, 180);
        Dish bread = new Dish("Bread", 35, 220);
        Dish roast = new Dish("Roast", 90, 190);
        Dish cookies = new Dish("Cookies", 15, 170);
        Dish lasagna = new Dish("Lasagna", 40, 200);

        System.out.println("\nAdding dishes to ovens...");

        Oven mostFreeOven = kitchen.getMostFreeOven();
        mostFreeOven.addDish(pizza);
        System.out.println("Added " + pizza.getName() + " to Oven " + mostFreeOven.getId());

        mostFreeOven = kitchen.getMostFreeOven();
        mostFreeOven.addDish(cake);
        System.out.println("Added " + cake.getName() + " to Oven " + mostFreeOven.getId());

        mostFreeOven = kitchen.getMostFreeOven();
        mostFreeOven.addDish(bread);
        System.out.println("Added " + bread.getName() + " to Oven " + mostFreeOven.getId());

        mostFreeOven = kitchen.getMostFreeOven();
        mostFreeOven.addDish(roast);
        System.out.println("Added " + roast.getName() + " to Oven " + mostFreeOven.getId());

        mostFreeOven = kitchen.getMostFreeOven();
        mostFreeOven.addDish(cookies);
        System.out.println("Added " + cookies.getName() + " to Oven " + mostFreeOven.getId());

        mostFreeOven = kitchen.getMostFreeOven();
        mostFreeOven.addDish(lasagna);
        System.out.println("Added " + lasagna.getName() + " to Oven " + mostFreeOven.getId());

        System.out.println("\nFinal state of ovens:");
        allOvens = kitchen.getAllOvens();
        for (Oven oven : allOvens) {
            System.out.println(oven);
        }

        try {
            System.out.println("\nTrying to add a dish that exceeds max temperature (350°C)...");
            Dish highTempDish = new Dish("Extreme Pizza", 15, 350);
            kitchen.getMostFreeOven().addDish(highTempDish);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nRegistering a new high-temperature oven...");
        Oven highTempOven = new Oven(400);
        kitchen.registerOven(highTempOven);

        Dish highTempDish = new Dish("Extreme Pizza", 15, 350);
        highTempOven.addDish(highTempDish);
        System.out.println("Added " + highTempDish.getName() + " to Oven " + highTempOven.getId());

        System.out.println("\nFinal state with new high-temperature oven:");
        allOvens = kitchen.getAllOvens();
        for (Oven oven : allOvens) {
            System.out.println(oven);
        }
    }
}