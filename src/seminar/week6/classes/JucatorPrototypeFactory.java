package seminar.week6.classes;

import java.util.Map;

public class JucatorPrototypeFactory {
    private static Map<TipJucator, Jucator> jucatori;

    static {
        System.out.println("Incarcare mapa de jucatori");
        jucatori = new java.util.HashMap<>();
        try {
            jucatori.put(TipJucator.ATACANT, new Jucator("Cristiano Ronaldo", TipJucator.ATACANT));
            jucatori.put(TipJucator.FUNDAS, new Jucator("Ramos", TipJucator.FUNDAS));
            jucatori.put(TipJucator.PORTAR, new Jucator("Iker Casillas", TipJucator.PORTAR));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Jucator getPrototipJucator(TipJucator tipJucator) {
        Jucator jucator = jucatori.get(tipJucator);
        try {
            return jucator.clone();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
