package teme.pregatire.test1.s4.clase;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private static Canvas instance = new Canvas();
    private List<Personaj> personajList;

    private Canvas() {
        personajList = new ArrayList<>();
    }

    public static Canvas getInstance() {
        return instance;
    }

    public List<Personaj> getPersonajList() {
        return personajList;
    }

    public double calculareDistanta(Pozitie p1, Pozitie p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public <T extends Personaj> T createAndAddPersonaj(IFactory factory) {
        Personaj personaj = factory.createPersonaj();
        personajList.add(personaj);
        return (T) personaj;
    }

    @Override
    public String toString() {
        return "Canvas{" +
                "personajList=" + personajList +
                '}';
    }
}
