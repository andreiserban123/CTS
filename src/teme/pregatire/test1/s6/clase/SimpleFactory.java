package teme.pregatire.test1.s6.clase;


public class SimpleFactory {

    private static volatile SimpleFactory instance;

    private SimpleFactory() {
    }

    public static synchronized SimpleFactory getInstance() {
        if (instance == null) {
            instance = new SimpleFactory();
        }
        return instance;
    }

    public PersonalSpital creeaza(TipPersonal tip) {
        return switch (tip) {
            case Brancardier -> new Brancardier(tip);
            case Asistent -> new Asistent(tip);
            case Medic -> new Medic(tip);
            case null -> null;
        };
    }
}