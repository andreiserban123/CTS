package teme.pregatire.test1.s4.clase;

import java.util.ArrayList;
import java.util.List;

public class FabricaVrajitor implements IFactory {


    @Override
    public Personaj createPersonaj() {
        return new Vrajitor(new ArrayList<>(List.of("Vrajeala", "e magic")), new Pozitie(1, 2));

    }
}