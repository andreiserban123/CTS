package teme.pregatire.test1.s4.clase;

import java.util.ArrayList;
import java.util.List;

public class FabricaAnimal implements IFactory {
    @Override
    public Personaj createPersonaj() {  // Redenumit
        return new Animal(new ArrayList<>(List.of("Howl", "Mrrrr")), new Pozitie(3, 2));
    }
}

