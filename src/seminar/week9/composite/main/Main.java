package seminar.week9.composite.main;

import seminar.week9.composite.classes.Colet;
import seminar.week9.composite.classes.INod;
import seminar.week9.composite.classes.NodStructura;

public class Main {
    public static void main(String[] args) {
        INod container = new NodStructura(10);
        INod cutie1 = new NodStructura(10);
        INod cutie2 = new NodStructura(20);
        INod colet1 = new Colet(true, 20);
        INod colet2 = new Colet(true, 30);
        container.addNod(cutie1);
        container.addNod(cutie2);
        cutie1.addNod(colet1);
        cutie1.addNod(colet2);

        System.out.println(container.getGreutate());
        System.out.println(container.isFragil());
    }
}
