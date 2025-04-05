package teme.pregatire.test1.s2.main;

import teme.pregatire.test1.s2.clase.Senzor;
import teme.pregatire.test1.s2.clase.SenzorBuilder;

public class Main {
    public static void main(String[] args) {
        Senzor s = new SenzorBuilder(200)
                .setCo2(2)
                .setPm10(2)
                .setPm10(2)
                .build();
        s.afisareTemperatura();
    }
}
