package seminar.week11.chain.clase;

import java.util.List;

public class FiltruMedieExamen extends HandlerA {
    @Override
    public List<Candidat> handleRequest(List<Candidat> candidates) {
        System.out.println("Filtru medie examen");
        List<Candidat> lista = null;

        if (candidates != null) {
            lista = candidates.stream()
                    .filter(c -> c.getNotaAdmitere() >= 8)
                    .toList();

            if (lista.isEmpty()) {
                System.out.println("Nu sunt candidati cu medie examen >= 8");
            } else {
                System.out.println("Candidatii cu medie examen >= 8 sunt:");
                for (Candidat c : lista) {
                    System.out.println(c.getNume());
                }
            }
        }
        if (nextHandler != null) {
            return nextHandler.handleRequest(lista);
        } else {
            System.out.println("S-a terminat procesul de filtrare dupa medie examen");
            return lista;
        }
    }
}
