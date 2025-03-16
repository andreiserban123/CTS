package teme.tema3;

import java.io.FileNotFoundException;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Angajat> listaAngajati;
        try {
            listaAngajati = Utils.readAngajati("angajati.txt");
            for (Angajat angajat : listaAngajati)
                System.out.println(angajat.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fisierul nu a fost gasit!");
        }
    }
}
