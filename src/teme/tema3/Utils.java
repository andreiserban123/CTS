package teme.tema3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<? extends Aplicant> readAplicanti(String file, TipAplicant tip) throws IOException {
        List<Aplicant> aplicanti = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = line.split(",");
                if (values.length < 5) {
                    System.out.println("Warning: Invalid data format in line: " + line);
                    continue;
                }

                String nume = values[0].trim();
                String prenume = values[1].trim();
                int varsta = Integer.parseInt(values[2].trim());
                int punctaj = Integer.parseInt(values[3].trim());
                int nr_proiecte = Integer.parseInt(values[4].trim());

                if (values.length < 5 + nr_proiecte) {
                    System.out.println("Warning: Not enough project names in line: " + line);
                    continue;
                }

                String[] denumireProiecte = new String[nr_proiecte];
                for (int i = 0; i < nr_proiecte; i++) {
                    denumireProiecte[i] = values[5 + i].trim();
                }

                Aplicant aplicant = null;

                switch (tip) {
                    case STUDENT:
                        if (values.length < 5 + nr_proiecte + 2) {
                            System.out.println("Warning: Not enough data for student in line: " + line);
                            continue;
                        }
                        int an_studii = Integer.parseInt(values[5 + nr_proiecte].trim());
                        String facultate = values[6 + nr_proiecte].trim();
                        aplicant = new Student(nume, prenume, varsta, punctaj, nr_proiecte,
                                denumireProiecte, facultate, an_studii);
                        break;

                    case ANGAJAT:
                        if (values.length < 5 + nr_proiecte + 2) {
                            System.out.println("Warning: Not enough data for employee in line: " + line);
                            continue;
                        }
                        int salariu = Integer.parseInt(values[5 + nr_proiecte].trim());
                        String ocupatie = values[6 + nr_proiecte].trim();
                        aplicant = new Angajat(nume, prenume, varsta, punctaj, nr_proiecte,
                                denumireProiecte, salariu, ocupatie);
                        break;

                    case ELEV:
                        if (values.length < 5 + nr_proiecte + 2) {
                            System.out.println("Warning: Not enough data for pupil in line: " + line);
                            continue;
                        }
                        int clasa = Integer.parseInt(values[5 + nr_proiecte].trim());
                        String tutore = values[6 + nr_proiecte].trim();
                        aplicant = new Elev(nume, prenume, varsta, punctaj, nr_proiecte,
                                denumireProiecte, clasa, tutore);
                        break;
                }

                if (aplicant != null) {
                    aplicanti.add(aplicant);
                }
            }
        }

        return aplicanti;
    }

    public static List<Student> readStudents(String file) throws IOException {
        List<?> aplicanti = readAplicanti(file, TipAplicant.STUDENT);
        List<Student> students = new ArrayList<>();
        for (Object obj : aplicanti) {
            if (obj instanceof Student) {
                students.add((Student) obj);
            }
        }
        return students;
    }

    public static List<Angajat> readAngajati(String file) throws IOException {
        List<?> aplicanti = readAplicanti(file, TipAplicant.ANGAJAT);
        List<Angajat> angajati = new ArrayList<>();
        for (Object obj : aplicanti) {
            if (obj instanceof Angajat) {
                angajati.add((Angajat) obj);
            }
        }
        return angajati;
    }

    public static List<Elev> readPupil(String file) throws IOException {
        List<?> aplicanti = readAplicanti(file, TipAplicant.ELEV);
        List<Elev> elevi = new ArrayList<>();
        for (Object obj : aplicanti) {
            if (obj instanceof Elev) {
                elevi.add((Elev) obj);
            }
        }
        return elevi;
    }

    public enum TipAplicant {
        STUDENT, ANGAJAT, ELEV
    }
}