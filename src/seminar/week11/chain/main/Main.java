package seminar.week11.chain.main;

import seminar.week11.chain.clase.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Candidat> candidates = new ArrayList<>();

        // Adaugam candidati in lista
        candidates.add(new Candidat("Ion Popescu", "fdsjkllfsdfjsdfds jfldsfjlsdk", 8.0, 7.5));
        candidates.add(new Candidat("Maria Ionescu", "fdsjkllfsdfjsd fds jfldsfjlsdk", 9.0, 8.5));
        candidates.add(new Candidat("Andrei Georgescu", "fdsjkllfsdfjsd fds jfldsfjlsdk", 7.0, 6.5));


        FiltruEseu feseu = new FiltruEseu();
        FiltruMedieBac fmedie = new FiltruMedieBac();
        FiltruMedieExamen fexam = new FiltruMedieExamen();

        feseu.setNextHandler(fmedie);
        fmedie.setNextHandler(fexam);
        List<Candidat> filteredCandidates = feseu.handleRequest(candidates);
        System.out.println("Candidatii ramasi in lista sunt:");
        for (Candidat c : filteredCandidates) {
            System.out.println(c.getNume());
        }

        System.out.println("\n\nFatada:");
        List<String> names = new ArrayList<>();
        names.add("bac");
        names.add("examen");
        names.add("totala");

        FiltruMediaTotala ftot = new FiltruMediaTotala();

        FatadaFiltrare fatadaFiltrare = new FatadaFiltrare(names, candidates, true);
    }
}
