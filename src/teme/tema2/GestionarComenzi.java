package teme.tema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionarComenzi {

    private final Magazie magazie;
    private final List<Comanda> comenzi;

    private final boolean anuleazaIntreagaComandaLaStocInsuficient;

    public GestionarComenzi(Magazie magazie, boolean anuleazaIntreagaComandaLaStocInsuficient) {
        this.magazie = magazie;
        this.comenzi = new ArrayList<>();
        this.anuleazaIntreagaComandaLaStocInsuficient = anuleazaIntreagaComandaLaStocInsuficient;
    }

    public Comanda creeazaComanda(List<LinieComanda> linii, TipComanda tipComanda) {
        Comanda comanda = new Comanda(linii, tipComanda);
        comenzi.add(comanda);
        return comanda;
    }

    public boolean valideazaComanda(Comanda comanda) {
        System.out.println("Validare comanda #" + comanda.getId() + "...");

        List<LinieComanda> liniiCuStocInsuficient = new ArrayList<>();

        for (LinieComanda linie : comanda.getLiniiComanda()) {
            if (!magazie.verificaStoc(linie.getPreparat(), linie.getCantitate())) {
                System.out.println("Stoc insuficient pentru: " + linie);
                liniiCuStocInsuficient.add(linie);
            }
        }

        if (!liniiCuStocInsuficient.isEmpty()) {
            if (anuleazaIntreagaComandaLaStocInsuficient) {
                System.out.println("Comanda anulata din cauza stoc insuficient");
                comenzi.remove(comanda);
            } else {
                for (LinieComanda linie : liniiCuStocInsuficient) {
                    System.out.println("Se elimină din comandă: " + linie);
                    comanda.stergeLinie(linie);
                }
                if (comanda.getLiniiComanda().isEmpty()) {
                    System.out.println("Comandă anulată - toate preparatele necesită stoc insuficient!");
                    comenzi.remove(comanda);
                    return false;
                }
            }
        }


        for (LinieComanda linie : comanda.getLiniiComanda()) {
            magazie.extrageMateriiPrime(linie.getPreparat(), linie.getCantitate());
        }

        comanda.setValidata(true);
        System.out.println("Comandă validată cu succes!");

        return true;
    }

    public List<Comanda> getComenzi() {
        return Collections.unmodifiableList(comenzi);
    }

}
