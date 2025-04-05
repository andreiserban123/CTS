package teme.tema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Comanda {
    private static int nextId = 1;

    private final int id;

    private final List<LinieComanda> liniiComanda;

    private final Date dataComanda;
    private final TipComanda tipComanda;
    private boolean validata;

    public Comanda(List<LinieComanda> linii, TipComanda tipComanda) {
        this.id = nextId++;
        this.liniiComanda = new ArrayList<>(linii);
        this.dataComanda = new Date();
        this.validata = false;
        this.tipComanda = tipComanda;
    }

    public int getId() {
        return id;
    }

    public List<LinieComanda> getLiniiComanda() {
        return Collections.unmodifiableList(liniiComanda);
    }

    public Date getDataComanda() {
        return dataComanda;
    }

    public boolean isValidata() {
        return validata;
    }

    public void setValidata(boolean validata) {
        this.validata = validata;
    }

    public TipComanda getTipComanda() {
        return tipComanda;
    }

    public void stergeLinie(LinieComanda linie) {
        liniiComanda.remove(linie);
    }

    public double getTotal() {
        return liniiComanda.stream()
                .mapToDouble(linie -> linie.getPreparat().getPret() * linie.getCantitate())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comanda #").append(id).append(" (").append(tipComanda).append(")\n");
        sb.append("Data: ").append(dataComanda).append("\n");
        sb.append("Status: ").append(validata ? "Validată" : "Nevalidată").append("\n");
        sb.append("Linii comandă:\n");
        for (LinieComanda linie : liniiComanda) {
            sb.append("- ").append(linie).append("\n");
        }
        sb.append("Total: ").append(getTotal()).append(" RON");
        return sb.toString();
    }
}