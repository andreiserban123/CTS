package teme.pregatire.test1.s4.clase;

import java.util.ArrayList;
import java.util.List;

public class FabricaErou implements IFactory {


    @Override
    public Personaj createPersonaj() {
        return new Erou(new ArrayList<>(List.of("Salvez lumea", "Hey te ajut!")), new Pozitie(4, 12));

    }
}
