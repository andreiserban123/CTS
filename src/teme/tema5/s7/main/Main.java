package teme.tema5.s7.main;

import teme.tema5.s7.clase.Comanda;
import teme.tema5.s7.clase.Produs;
import teme.tema5.s7.clase.ProxyComanda;

public class Main {
    public static void main(String[] args) {
        // Test Proxy
        Comanda comanda = new Comanda();
        comanda.addProdus(new Produs("Pizza", 20));
        comanda.addProdus(new Produs("Pasta", 15));

        ProxyComanda proxyComanda = new ProxyComanda(comanda, "Client1");
        System.out.println("Total comanda Client1: " + proxyComanda.calculTotal());
        proxyComanda.addComanda(comanda, "Client1");
        System.out.println("Total comanda Client1: " + proxyComanda.calculTotal());
    }
}
