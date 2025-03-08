package tema2;

import java.util.Date;

public class LotMateriePrima {
    private final MateriePrima materiePrima;
    private final Date dataIntrare;
    private double cantitate;

    public LotMateriePrima(MateriePrima materiePrima, double cantitate, Date dataIntrare) {
        this.materiePrima = materiePrima;
        this.cantitate = cantitate;
        this.dataIntrare = dataIntrare;
    }

    public MateriePrima getMateriePrima() {
        return materiePrima;
    }

    public double getCantitate() {
        return cantitate;
    }

    public void setCantitate(double cantitate) {
        this.cantitate = cantitate;
    }

    public Date getDataIntrare() {
        return dataIntrare;
    }

    @Override
    public String toString() {
        return materiePrima.getNume() + " - " + cantitate + " " + materiePrima.getUnitateMasura() +
                " (intrare: " + dataIntrare + ")";
    }
}