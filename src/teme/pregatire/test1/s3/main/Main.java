package teme.pregatire.test1.s3.main;

import teme.pregatire.test1.s3.clase.AbstractAirQualityReport;
import teme.pregatire.test1.s3.clase.FactoryRaport;

public class Main {
    public static void main(String[] args) {
        FactoryRaport factory = new FactoryRaport();
        AbstractAirQualityReport report = factory.creeazaRaport(30);
        report.printTip();
    }
}