package seminar.week11.chain.clase.strategy;

import seminar.week11.chain.clase.Candidat;

import java.util.List;

public class StrategieAcord implements IStrategy {
    @Override
    public void afisareCandidati(List<Candidat> candidati) {
        System.out.println("Afisare candidati cu acord GDPR");
        for (Candidat c : candidati) {
            System.out.println(c);
        }
    }
}
