package seminar.week11.chain.clase;

import java.util.List;

public class FiltruEseu extends HandlerA {
    @Override
    public List<Candidat> handleRequest(List<Candidat> candidates) {
        System.out.println("Filtru eseu");
        List<Candidat> lista = null;
        // se filtreaza candidatii cu eseu de lungime para
        if (candidates != null) {
            lista = candidates.stream()
                    .filter(c -> c.getEseu().length() % 2 == 0)
                    .toList();

            if (lista.isEmpty()) {
                System.out.println("Nu sunt candidati cu eseu de lungime para");
            } else {
                System.out.println("Candidatii cu eseu de lungime para sunt:");
                for (Candidat c : lista) {
                    System.out.println(c.getNume());
                }
            }
        }
        if (super.nextHandler != null) {
            return nextHandler.handleRequest(lista);
        } else {
            System.out.println("S-a terminat procesul de filtrare");
            return lista;
        }
    }
}
