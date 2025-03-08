package tema2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Magazie magazie = new Magazie();
        Meniu meniu = new Meniu();


        // true = anuleaza intreaga comanda, false = anuleaza doar preparatele fara stoc
        boolean anuleazaIntreagaComanda = false;
        GestionarComenzi gestionarComenzi = new GestionarComenzi(magazie, anuleazaIntreagaComanda);


        MateriePrima faina = new MateriePrima("Făină", "kg");
        MateriePrima oua = new MateriePrima("Ouă", "buc");
        MateriePrima zahar = new MateriePrima("Zahăr", "kg");
        MateriePrima carne = new MateriePrima("Carne de vită", "kg");
        MateriePrima cartofi = new MateriePrima("Cartofi", "kg");
        MateriePrima roșii = new MateriePrima("Roșii", "kg");
        MateriePrima branza = new MateriePrima("Brânză", "kg");


        magazie.adaugaStoc(faina, 10.0);
        magazie.adaugaStoc(oua, 50.0);
        magazie.adaugaStoc(zahar, 5.0);
        magazie.adaugaStoc(carne, 15.0);
        magazie.adaugaStoc(cartofi, 20.0);
        magazie.adaugaStoc(roșii, 8.0);
        magazie.adaugaStoc(branza, 7.0);


        magazie.adaugaStoc(carne, 5.0);


        magazie.afiseazaStoc();


        Preparat pizza = new Preparat("Pizza Margherita", Arrays.asList(
                new Ingredient(faina, 0.3),
                new Ingredient(roșii, 0.2),
                new Ingredient(branza, 0.15)
        ), 35.0);

        Preparat paste = new Preparat("Paste Carbonara", Arrays.asList(
                new Ingredient(faina, 0.2),
                new Ingredient(oua, 2.0)
        ), 28.0);

        Preparat fripta = new Preparat("Friptură de vită cu cartofi", Arrays.asList(
                new Ingredient(carne, 0.3),
                new Ingredient(cartofi, 0.25)
        ), 45.0);

        Preparat prajitura = new Preparat("Prăjitură cu ciocolată", Arrays.asList(
                new Ingredient(faina, 0.15),
                new Ingredient(oua, 3.0),
                new Ingredient(zahar, 0.2)
        ), 18.0);


        meniu.adaugaPreparat(pizza);
        meniu.adaugaPreparat(paste);
        meniu.adaugaPreparat(fripta);
        meniu.adaugaPreparat(prajitura);

        // Afișăm meniul
        meniu.afiseazaMeniu();

        // Simulăm o comandă
        System.out.println("\n=== SIMULARE COMANDĂ 1 ===");
        Comanda comanda1 = gestionarComenzi.creeazaComanda(Arrays.asList(
                new LinieComanda(pizza, 2),
                new LinieComanda(fripta, 3),
                new LinieComanda(prajitura, 4)
        ), TipComanda.FIZICA);

        System.out.println(comanda1);
        gestionarComenzi.valideazaComanda(comanda1);


        System.out.println("\nStoc după prima comandă:");
        magazie.afiseazaStoc();

        System.out.println("\n=== SIMULARE COMANDĂ 2 (stoc insuficient) ===");

        Comanda comanda2 = gestionarComenzi.creeazaComanda(Arrays.asList(
                new LinieComanda(fripta, 10),
                new LinieComanda(paste, 5)
        ), TipComanda.TELEFONICA);

        System.out.println(comanda2);
        gestionarComenzi.valideazaComanda(comanda2);


        System.out.println("\nStoc final:");
        magazie.afiseazaStoc();


        System.out.println("\n=== COMENZI VALIDATE ===");
        for (Comanda c : gestionarComenzi.getComenzi()) {
            if (c.isValidata()) {
                System.out.println(c);
                System.out.println();
            }
        }

        System.out.println("\n=== TEST CONCURENȚĂ FIFO ===");

        magazie = new Magazie();

        magazie.adaugaStoc(faina, 3.0);
        magazie.adaugaStoc(faina, 5.0);
        magazie.adaugaStoc(faina, 2.0);

        // Afișăm stocul inițial
        magazie.afiseazaStoc();


        ExecutorService executor = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 5; i++) {
            final int threadId = i + 1;
            Magazie finalMagazie = magazie;
            executor.submit(() -> {
                try {

                    Thread.sleep(new Random().nextInt(500));

                    System.out.println("Thread " + threadId + " încearcă să extragă făină...");


                    Preparat prajituraConcurenta = new Preparat("Prăjitură " + threadId,
                            Collections.singletonList(new Ingredient(faina, 1.5)), 15.0);


                    boolean succes = finalMagazie.extrageMateriiPrime(prajituraConcurenta, 1);

                    if (succes) {
                        System.out.println("Thread " + threadId + " a extras făină cu succes.");
                    } else {
                        System.out.println("Thread " + threadId + " nu a putut extrage făină (stoc insuficient).");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }


        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        System.out.println("\nStoc final după extragerile concurente:");
        magazie.afiseazaStoc();
    }
}
