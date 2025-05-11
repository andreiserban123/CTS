package teme.tema5.s7.clase;

import java.util.HashSet;
import java.util.Set;

public class ProxyComanda implements IComanda {

    private Comanda comanda;

    private Set<String> clienti = new HashSet<>();

    private boolean acordareReducere = false;

    public ProxyComanda(Comanda comanda, String client) {
        this.comanda = comanda;
        if (this.clienti.add(client)) {
            acordareReducere = true;
        }
    }

    @Override
    public double calculTotal() {
        double total = comanda.calculTotal();
        if (acordareReducere) {
            total = total - (total * 0.1);
        }
        return total;
    }

    public void addComanda(Comanda comanda, String client) {
        this.comanda = comanda;
        if (this.clienti.add(client)) {
            acordareReducere = true;
        } else {
            acordareReducere = false;
        }
    }
}
