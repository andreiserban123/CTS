package seminar.week11.chain.clase;

import java.util.List;

public class FiltruMediaTotala extends HandlerA {

    public FiltruMediaTotala() {
        super("totala");
    }

    @Override
    public List<Candidat> handleRequest(List<Candidat> candidates) {

        System.out.println("Filtru medie totala");
        List<Candidat> lista = null;

        if (candidates != null) {
            lista = candidates.stream()
                    .filter(c -> (c.getNotaBac() + c.getNotaAdmitere()) / 2 >= 7.5)
                    .toList();

            if (lista.isEmpty()) {
                System.out.println("Nu sunt candidati cu medie totala >= 7.5");
            } else {
                System.out.println("Candidatii cu medie totala >= 7.5 sunt:");
                for (Candidat c : lista) {
                    System.out.println(c.getNume());
                }
            }
        }
        if (nextHandler != null) {
            return nextHandler.handleRequest(lista);
        } else {
            System.out.println("S-a terminat procesul de filtrare dupa medie totala");
            return lista;
        }
    }
}
