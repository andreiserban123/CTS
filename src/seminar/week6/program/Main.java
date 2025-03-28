package seminar.week6.program;

import seminar.week6.classes.Jucator;
import seminar.week6.classes.JucatorPrototypeFactory;
import seminar.week6.classes.TipJucator;

public class Main {
    public static void main(String[] args) {
        Jucator jucator1 = JucatorPrototypeFactory.getPrototipJucator(TipJucator.ATACANT);
        Jucator jucator2 = JucatorPrototypeFactory.getPrototipJucator(TipJucator.ATACANT);
        jucator2.setNume("Messi");
        jucator1.addMedicament("Paracetamol");
        Jucator jucator3 = JucatorPrototypeFactory.getPrototipJucator(TipJucator.FUNDAS);
        Jucator jucator4 = JucatorPrototypeFactory.getPrototipJucator(TipJucator.PORTAR);

        jucator1.addAntrenamente("Antrenament Nou");
        jucator1.updateAntrenamente("antrenament_atacant_1", " oricare");

        System.out.println(jucator1);
        System.out.println(jucator2);
        System.out.println(jucator3);
    }
}
