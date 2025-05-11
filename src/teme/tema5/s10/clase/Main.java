package teme.tema5.s10.clase;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inițializarea magazinului și adăugarea produselor
        MagazinPantofi magazin = new MagazinPantofi();
        initializareMagazin(magazin);

        // 1. Demonstrarea primului pattern (Chain of Responsibility)
        System.out.println("\n--- DEMONSTRAREA PATTERN-ULUI CHAIN OF RESPONSIBILITY ---");

        // Prima căutare: pantofi Nike de mărimea 42
        System.out.println("\nCăutare 1: Pantofi Nike, mărimea 42");
        FiltruBrand filtruBrand1 = new FiltruBrand("Nike");
        FiltruMarime filtruMarime1 = new FiltruMarime(42);
        FiltruDisponibilitate filtruDisponibilitate1 = new FiltruDisponibilitate(true, true);

        filtruBrand1.setUrmatorulFiltru(filtruMarime1);
        filtruMarime1.setUrmatorulFiltru(filtruDisponibilitate1);

        magazin.setPrimulFiltru(filtruBrand1);
        List<Produs> rezultatCautare1 = magazin.cautaProduse();

        System.out.println("Rezultate pentru căutarea 1:");
        afiseazaRezultate(rezultatCautare1);

        // A doua căutare: pantofi de culoare neagră cu preț maxim 300
        System.out.println("\nCăutare 2: Pantofi de culoare neagră cu preț maxim 300");
        FiltruCuloare filtruCuloare2 = new FiltruCuloare("negru");
        FiltruPretMaxim filtruPretMaxim2 = new FiltruPretMaxim(300);
        FiltruDisponibilitate filtruDisponibilitate2 = new FiltruDisponibilitate(true, true);

        filtruCuloare2.setUrmatorulFiltru(filtruPretMaxim2);
        filtruPretMaxim2.setUrmatorulFiltru(filtruDisponibilitate2);

        magazin.setPrimulFiltru(filtruCuloare2);
        List<Produs> rezultatCautare2 = magazin.cautaProduse();

        System.out.println("Rezultate pentru căutarea 2:");
        afiseazaRezultate(rezultatCautare2);

        // 2. Demonstrarea celui de-al doilea pattern (Strategy)
        System.out.println("\n--- DEMONSTRAREA PATTERN-ULUI STRATEGY ---");

        Client client = new Client();

        // Opțiunea de a alege tipul de parametrizare a căutării
        System.out.println("\nAlege strategia de parametrizare:");
        System.out.println("1. Parametrizare implicită");
        System.out.println("2. Parametrizare personalizată");
        System.out.print("Opțiunea ta: ");
        int optiune = Integer.parseInt(scanner.nextLine());

        if (optiune == 1) {
            client.setStrategieParametrizare(new StrategieImplicita());
        } else {
            client.setStrategieParametrizare(new StrategiePersonalizata());
        }

        // Aplicarea strategiei alese
        ICautare parametrizare = client.alegeParametrizareCautare();
        magazin.setPrimulFiltru(parametrizare);

        // Afișarea rezultatelor căutării
        List<Produs> rezultateCautareClient = magazin.cautaProduse();
        System.out.println("\nRezultate pentru căutarea clientului:");
        afiseazaRezultate(rezultateCautareClient);

        scanner.close();
    }

    // Metoda pentru inițializarea magazinului cu produse
    private static void initializareMagazin(MagazinPantofi magazin) {
        System.out.println("Se inițializează magazinul cu produse...");

        magazin.adaugaProdus(new Produs("Air Force 1", "Nike", 450, 42, "alb", "unisex", true));
        magazin.adaugaProdus(new Produs("Air Max", "Nike", 550, 43, "negru", "barbati", true));
        magazin.adaugaProdus(new Produs("Jordan", "Nike", 800, 44, "rosu", "barbati", false));
        magazin.adaugaProdus(new Produs("Stan Smith", "Adidas", 350, 39, "verde", "unisex", true));
        magazin.adaugaProdus(new Produs("Superstar", "Adidas", 300, 38, "negru", "femei", true));
        magazin.adaugaProdus(new Produs("Classic", "Reebok", 250, 42, "alb", "unisex", true));
        magazin.adaugaProdus(new Produs("Suede", "Puma", 280, 41, "albastru", "barbati", false));

        System.out.println("Magazinul a fost inițializat cu 7 produse.");
    }

    // Metoda pentru afișarea rezultatelor căutării
    private static void afiseazaRezultate(List<Produs> rezultate) {
        if (rezultate.isEmpty()) {
            System.out.println("Nu s-au găsit produse care să corespundă criteriilor de căutare.");
        } else {
            System.out.println("S-au găsit " + rezultate.size() + " produse:");
            for (Produs produs : rezultate) {
                System.out.println("- " + produs);
            }
        }
    }
}
