package teme.pregatire.test1.s4.main;

import teme.pregatire.test1.s4.clase.*;

public class Main {
    public static void main(String[] args) {
        Canvas mainCanvas = Canvas.getInstance();

        Vrajitor vrajitor1 = mainCanvas.createAndAddPersonaj(new FabricaVrajitor());
        Animal animal = mainCanvas.createAndAddPersonaj(new FabricaAnimal());
        Erou erou = mainCanvas.createAndAddPersonaj(new FabricaErou());
        Vrajitor vrajitor2 = mainCanvas.createAndAddPersonaj(new FabricaVrajitor());

        System.out.println(mainCanvas);

        boolean proximitate = vrajitor1.verificaProximitate(mainCanvas);
        System.out.println("Personaj în proximitate: " + proximitate);
        System.out.println("Mesaje actualizate vrăjitor: " + vrajitor1.getMesaje());
    }
}