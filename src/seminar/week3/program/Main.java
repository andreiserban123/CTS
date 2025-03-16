package seminar.week3.program;

import seminar.week3.clase.Angajat;
import seminar.week3.clase.Lucrator;
import seminar.week3.clase.Manager;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Angajat> angajati = new ArrayList<>();
        angajati.add(new Lucrator("Andrei"));
        angajati.add(new Lucrator("Mihai"));
        angajati.add(new Manager("George"));

        float totalSalarii = 0;
        for (Angajat angajat : angajati) {
            totalSalarii += angajat.calculateSalary();
        }
        System.out.println("Total salarii: " + totalSalarii);
    }
}
