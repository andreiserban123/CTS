package tema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Meniu {
    private final List<Preparat> preparate;

    public Meniu() {
        this.preparate = new ArrayList<>();
    }

    public void adaugaPreparat(Preparat preparat) {
        preparate.add(preparat);
    }

    public List<Preparat> getPreparate() {
        return Collections.unmodifiableList(preparate);
    }

    public Preparat getPreparatByNume(String nume) {
        return preparate.stream()
                .filter(p -> p.getNume().equalsIgnoreCase(nume))
                .findFirst()
                .orElse(null);
    }

    public void afiseazaMeniu() {
        System.out.println("=== MENIU ===");
        for (int i = 0; i < preparate.size(); i++) {
            Preparat p = preparate.get(i);
            System.out.println((i + 1) + ". " + p.getNume() + " - " + p.getPret() + " RON");
        }
        System.out.println("=============");
    }
}