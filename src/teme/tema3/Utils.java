package teme.tema3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static List<? extends Aplicant> readAplicanti(String file, TipAplicant tip) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("[,\n" +
                "]");

        List<Aplicant> aplicanti = new ArrayList<>();

        while (scanner.hasNext()) {
            String nume = scanner.next();
            String prenume = scanner.next();
            int varsta = scanner.nextInt();
            int punctaj = scanner.nextInt();
            int nr_proiecte = scanner.nextInt();

            String[] denumireProiecte = new String[nr_proiecte];
            for (int i = 0; i < nr_proiecte; i++) {
                denumireProiecte[i] = scanner.next();
            }

            Aplicant aplicant = null;

            switch (tip) {
                case STUDENT:
                    int an_studii = scanner.nextInt();
                    String facultate = scanner.next();
                    aplicant = new Student(nume, prenume, varsta, punctaj, nr_proiecte,
                            denumireProiecte, facultate, an_studii);
                    break;

                case ANGAJAT:
                    int salariu = scanner.nextInt();
                    String ocupatie = scanner.next();
                    aplicant = new Angajat(nume, prenume, varsta, punctaj, nr_proiecte,
                            denumireProiecte, salariu, ocupatie);
                    break;

                case ELEV:
                    int clasa = scanner.nextInt();
                    String tutore = scanner.next();
                    aplicant = new Elev(nume, prenume, varsta, punctaj, nr_proiecte,
                            denumireProiecte, clasa, tutore);
                    break;
            }

            if (aplicant != null) {
                aplicanti.add(aplicant);
            }
        }

        scanner.close();
        return aplicanti;
    }

    public static List<Student> readStudents(String file) throws FileNotFoundException {
        return (List<Student>) readAplicanti(file, TipAplicant.STUDENT);
    }

    public static List<Angajat> readAngajati(String file) throws FileNotFoundException {
        return (List<Angajat>) readAplicanti(file, TipAplicant.ANGAJAT);
    }

    public static List<Elev> readPupil(String file) throws FileNotFoundException {
        return (List<Elev>) readAplicanti(file, TipAplicant.ELEV);
    }

    public static void readAll() {
        try {
            List<Elev> listaelevi = readPupil("elevi.txt");
            for (Elev elev : listaelevi) {
                System.out.println(elev.toString());
            }

            List<Student> listastudenti = readStudents("studenti.txt");
            for (Student student : listastudenti) {
                System.out.println(student.toString());
            }

            List<Angajat> listaangajati = readAngajati("angajati.txt");
            for (Angajat angajat : listaangajati) {
                System.out.println(angajat.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum TipAplicant {
        STUDENT, ANGAJAT, ELEV
    }
}