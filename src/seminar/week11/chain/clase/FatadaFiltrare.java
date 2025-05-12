package seminar.week11.chain.clase;

import java.util.*;

public class FatadaFiltrare {
    static Map<String, HandlerA> mapFiltrare = new HashMap<>();

    static {
        mapFiltrare.put("bac", new FiltruMedieBac());
        mapFiltrare.put("examen", new FiltruMedieExamen());
        mapFiltrare.put("eseu", new FiltruEseu());
    }

    public FatadaFiltrare(List<String> names, List<Candidat> candidates, boolean shuffle) {
        HandlerA firstHandler = null;
        HandlerA lastHandler = null;

        List<HandlerA> lista = new ArrayList<>();

        if (shuffle) {
            Collections.shuffle(names);
        }

        for (String name : names) {
            if (mapFiltrare.containsKey(name)) {

                HandlerA handler = mapFiltrare.get(name);
                lista.add(handler);

                if (firstHandler == null) {
                    firstHandler = handler;
                    lastHandler = handler;
                } else {
                    lastHandler.setNextHandler(handler);
                    lastHandler = handler;
                }
            }
        }

        if (firstHandler != null) {
            List<Candidat> filteredCandidates = firstHandler.handleRequest(candidates);
            System.out.println("Candidatii ramasi in lista sunt:");
            for (Candidat c : filteredCandidates) {
                System.out.println(c.getNume());
            }
        } else {
            System.out.println("Nu s-a gasit niciun filtru valid.");
        }
    }

}
