package seminar.week5.singletonRegistry.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kitchen {
    private static Kitchen instance;

    static {
        instance = new Kitchen();
    }

    private Map<Integer, Oven> ovens;

    private Kitchen() {
        this.ovens = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            registerOven(new Oven(300));
        }
    }

    public static Kitchen getInstance() {
        return instance;
    }

    public void registerOven(Oven oven) {
        ovens.put(oven.getId(), oven);
    }

    public Oven getOven(int id) {
        return ovens.get(id);
    }

    public List<Oven> getAllOvens() {
        return new ArrayList<>(ovens.values());
    }

    public Oven getMostFreeOven() {
        if (ovens.isEmpty()) {
            return null;
        }

        Oven mostFreeOven = null;
        int minTotalMinutes = Integer.MAX_VALUE;

        for (Oven oven : ovens.values()) {
            int totalMinutes = oven.getTotalCookingMinutes();
            if (totalMinutes < minTotalMinutes) {
                minTotalMinutes = totalMinutes;
                mostFreeOven = oven;
            }
        }

        return mostFreeOven;
    }
}