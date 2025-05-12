package seminar.week11.chain.clase.strategy;

import seminar.week11.chain.clase.Candidat;

import java.util.List;

public class StrategieNoGDPR implements IStrategy {
    @Override
    public void afisareCandidati(List<Candidat> candidati) {
        System.out.println("Afisare candidati GDPR");
        for (Candidat c : candidati) {
            int nrStelute = c.getNume().length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nrStelute; i++) {
                sb.append("*");
            }
            sb.append(" ");
            sb.append(c.getNotaAdmitere());

            System.out.println(sb);
        }
    }
}
