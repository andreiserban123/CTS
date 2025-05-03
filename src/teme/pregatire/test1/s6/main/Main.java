package teme.pregatire.test1.s6.main;

import teme.pregatire.test1.s6.clase.*;

public class Main {
    public static void main(String[] args) {
        PacientBuilder builder = new PacientBuilder("Toma");

        Pacient pacient =
                builder.setHalat(true)
                        .setMicDejun(true)
                        .setPapuci(true)
                        .build();

        System.out.println(pacient);


        Pacient pacient2 = builder.build();
        System.out.println(pacient2);


        SimpleFactory factorySimple = SimpleFactory.getInstance();

        var personal = factorySimple.creeaza(TipPersonal.Medic);
        System.out.println(personal);

        IFactory factory = new FactoryAsistent();
        PersonalSpital asistent = factory.creeaza();
        asistent.afisareTip();

        factory = new FactoryGardian();
        PersonalSpital gardian = factory.creeaza();
        gardian.afisareTip();
    }
}
