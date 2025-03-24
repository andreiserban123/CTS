package seminar.week5.singleton.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    // private static Restaurant instance = new Restaurant(); for thread safety, is eager
    private static Restaurant instance;

    //singleton data(non-static)
    private final List<Table> tables;

    private Restaurant() {
        this.name = name;
        this.tables = new ArrayList<>();
    }

    public static synchronized Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    // singleton methods + operations

    public Table getTable(boolean isOutside, int nrPersons) {
        for (var m : tables) {
            if (m.getNrChairs() >= nrPersons && m.isOutside() == isOutside && !m.isOccupied()) {
                m.setOccupied(true);
                return m;
            }
        }
        return null;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "tables=" + tables +
                '}';
    }
}
