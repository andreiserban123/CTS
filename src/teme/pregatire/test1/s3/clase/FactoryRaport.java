package teme.pregatire.test1.s3.clase;

public class FactoryRaport {
    public AbstractAirQualityReport creeazaRaport(int pm25) {

        Tip tip = switch (pm25) {
            case Integer i when i >= 0 && i <= 30 -> Tip.AER_CURAT;
            case Integer i when i >= 31 && i <= 70 -> Tip.AVERTIZARE;
            case Integer i when i >= 71 -> Tip.RISC;
            default -> throw new IllegalStateException("Unexpected value: " + pm25);
        };

        return new Raport("test data", tip);
    }
}