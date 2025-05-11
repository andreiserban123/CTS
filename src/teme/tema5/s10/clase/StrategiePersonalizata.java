package teme.tema5.s10.clase;

import java.util.Scanner;

public class StrategiePersonalizata implements StrategieParametrizare {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public ICautare creeazaParametrizare() {
        System.out.println("Se configureaza parametrizarea personalizata de cautare.");

        ICautare primulFiltru = null;
        ICautare filtruCurent = null;
        System.out.print("Introduceți brand-ul (lăsați gol pentru a ignora): ");
        String brand = scanner.nextLine().trim();
        if (!brand.isEmpty()) {
            FiltruBrand filtruBrand = new FiltruBrand(brand);
            primulFiltru = filtruBrand;
            filtruCurent = filtruBrand;
            System.out.println("Filtru brand adăugat: " + brand);
        }

        // Preț maxim
        System.out.print("Introduceți prețul maxim (0 pentru a ignora): ");
        double pretMaxim = Double.parseDouble(scanner.nextLine());
        if (pretMaxim > 0) {
            FiltruPretMaxim filtruPretMaxim = new FiltruPretMaxim(pretMaxim);
            if (primulFiltru == null) {
                primulFiltru = filtruPretMaxim;
                filtruCurent = filtruPretMaxim;
            } else {
                filtruCurent.setUrmatorulFiltru(filtruPretMaxim);
                filtruCurent = filtruPretMaxim;
            }
            System.out.println("Filtru preț maxim adăugat: " + pretMaxim);
        }

        // Mărime
        System.out.print("Introduceți mărimea (0 pentru a ignora): ");
        int marime = Integer.parseInt(scanner.nextLine());
        if (marime > 0) {
            FiltruMarime filtruMarime = new FiltruMarime(marime);
            if (primulFiltru == null) {
                primulFiltru = filtruMarime;
                filtruCurent = filtruMarime;
            } else {
                filtruCurent.setUrmatorulFiltru(filtruMarime);
                filtruCurent = filtruMarime;
            }
            System.out.println("Filtru mărime adăugat: " + marime);
        }

        // Culoare
        System.out.print("Introduceți culoarea (lăsați gol pentru a ignora): ");
        String culoare = scanner.nextLine().trim();
        if (!culoare.isEmpty()) {
            FiltruCuloare filtruCuloare = new FiltruCuloare(culoare);
            if (primulFiltru == null) {
                primulFiltru = filtruCuloare;
                filtruCurent = filtruCuloare;
            } else {
                filtruCurent.setUrmatorulFiltru(filtruCuloare);
                filtruCurent = filtruCuloare;
            }
            System.out.println("Filtru culoare adăugat: " + culoare);
        }

        // Gen
        System.out.print("Introduceți genul (barbati/femei, lăsați gol pentru a ignora): ");
        String gen = scanner.nextLine().trim();
        if (!gen.isEmpty()) {
            FiltruGen filtruGen = new FiltruGen(gen);
            if (primulFiltru == null) {
                primulFiltru = filtruGen;
                filtruCurent = filtruGen;
            } else {
                filtruCurent.setUrmatorulFiltru(filtruGen);
                filtruCurent = filtruGen;
            }
            System.out.println("Filtru gen adăugat: " + gen);
        }

        // Disponibilitate
        System.out.print("Doriți să afișați doar produsele disponibile? (da/nu): ");
        String disponibilRaspuns = scanner.nextLine().trim().toLowerCase();
        boolean aplicaFiltruDisponibilitate = disponibilRaspuns.equals("da");
        boolean disponibil = true; // Implicit dorim produse disponibile

        FiltruDisponibilitate filtruDisponibilitate = new FiltruDisponibilitate(disponibil, aplicaFiltruDisponibilitate);
        if (primulFiltru == null) {
            primulFiltru = filtruDisponibilitate;
        } else {
            filtruCurent.setUrmatorulFiltru(filtruDisponibilitate);
        }

        if (aplicaFiltruDisponibilitate) {
            System.out.println("Filtru disponibilitate adăugat: doar produse disponibile");
        }

        return primulFiltru;
    }
}
