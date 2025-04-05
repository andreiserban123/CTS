package teme.pregatire.test1.s3.clase;

public class Raport extends AbstractAirQualityReport {
    private String data;
    private Tip tip;

    Raport(String data, Tip tip) {
        this.data = data;
        this.tip = tip;
    }

    @Override
    public void printTip() {
        System.out.println("Tip " + tip);
    }
}