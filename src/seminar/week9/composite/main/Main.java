package seminar.week9.composite.main;

import seminar.week9.composite.models.Colet;
import seminar.week9.composite.models.INod;
import seminar.week9.composite.models.NodStructura;

public class Main {
    public static void main(String[] args) {
        INod container = new NodStructura(10);
        INod cutie1 = new NodStructura(10);
        INod cutie2 = new NodStructura(15);
        INod colet1 = new Colet(20, false);
        INod colet2 = new Colet(8, true);


        container.adaugaNod(cutie1);
        container.adaugaNod(cutie2);
        cutie1.adaugaNod(colet1);
        cutie2.adaugaNod(colet2);
        System.out.println("Containerul este fragil? " + container.isFragil());

        System.out.println("Greutatea totala a containerului: " + container.getGreutate());
        System.out.println("Cutia 1 este fragila? " + cutie1.isFragil());
    }
}
