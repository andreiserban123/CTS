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

        // true = anulează întreaga comandă, false = anulează doar preparatele fără stoc
        boolean anuleazaIntreagaComanda = false;
        GestionarComenzi gestionarComenzi = new GestionarComenzi(magazie, anuleazaIntreagaComanda);

        // Creăm câteva materii prime
        MateriePrima faina = new MateriePrima("Făină", "kg");
        MateriePrima oua = new MateriePrima("Ouă", "buc");
        MateriePrima zahar = new MateriePrima("Zahăr", "kg");
        MateriePrima carne = new MateriePrima("Carne de vită", "kg");
        MateriePrima cartofi = new MateriePrima("Cartofi", "kg");
        MateriePrima rosii = new MateriePrima("Roșii", "kg");
        MateriePrima branza = new MateriePrima("Brânză", "kg");

        magazie.adaugaStoc(faina, 10.0);
        magazie.adaugaStoc(oua, 50.0);
        magazie.adaugaStoc(zahar, 5.0);
        magazie.adaugaStoc(carne, 1.5);
        magazie.adaugaStoc(cartofi, 20.0);
        magazie.adaugaStoc(rosii, 8.0);
        magazie.adaugaStoc(branza, 7.0);

        magazie.adaugaStoc(carne, 0.5);

        magazie.afiseazaStoc();

        // Creăm preparate pentru meniu
        Preparat pizza = new Preparat("Pizza Margherita", Arrays.asList(
                new Ingredient(faina, 0.3),
                new Ingredient(rosii, 0.2),
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

        // Adăugăm preparatele în meniu
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

        // Afișăm stocul după prima comandă
        System.out.println("\nStoc după prima comandă:");
        magazie.afiseazaStoc();

        // Simulăm o comandă care depășește stocul
        System.out.println("\n=== SIMULARE COMANDĂ 2 (stoc insuficient) ===");
        // Comanda va cere mai multă carne decât este disponibilă
        Comanda comanda2 = gestionarComenzi.creeazaComanda(Arrays.asList(
                new LinieComanda(fripta, 10), // Va necesita 3kg de carne, mai mult decât avem
                new LinieComanda(paste, 5)
        ), TipComanda.TELEFONICA);

        System.out.println(comanda2);
        gestionarComenzi.valideazaComanda(comanda2);

        // Afișăm stocul final
        System.out.println("\nStoc final:");
        magazie.afiseazaStoc();

        // Afișăm toate comenzile validate
        System.out.println("\n=== COMENZI VALIDATE ===");
        for (Comanda c : gestionarComenzi.getComenzi()) {
            if (c.isValidata()) {
                System.out.println(c);
                System.out.println();
            }
        }

        // Demonstrăm funcționalitatea FIFO în condiții de concurență
        System.out.println("\n=== TEST CONCURENȚĂ FIFO ===");

        // Resetăm stocul pentru demonstrație
        magazie = new Magazie();

        // Adăugăm câteva loturi de făină (pentru a demonstra FIFO)
        magazie.adaugaStoc(faina, 3.0); // Primul lot
        magazie.adaugaStoc(faina, 5.0); // Al doilea lot
        magazie.adaugaStoc(faina, 2.0); // Al treilea lot

        // Afișăm stocul inițial
        magazie.afiseazaStoc();

        // Creăm un thread pool
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Creăm 5 thread-uri care vor extrage făină simultan
        for (int i = 0; i < 5; i++) {
            final int threadId = i + 1;
            Magazie finalMagazie = magazie;
            executor.submit(() -> {
                try {
                    // Punem un delay aleatoriu pentru a simula concurența
                    Thread.sleep(new Random().nextInt(500));

                    System.out.println("Thread " + threadId + " încearcă să extragă făină...");

                    // Creăm un preparat fictiv care necesită făină
                    Preparat prajituraConcurenta = new Preparat("Prăjitură " + threadId,
                            Collections.singletonList(new Ingredient(faina, 1.5)), 15.0);

                    // Extragem făina (sau încercăm)
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
