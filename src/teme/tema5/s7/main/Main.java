package teme.tema5.s7.main;

import teme.tema5.s7.clase.CategorieProduse;
import teme.tema5.s7.clase.Comanda;
import teme.tema5.s7.clase.Produs;
import teme.tema5.s7.clase.ProxyComanda;

public class Main {
    public static void main(String[] args) {
        // Test Proxy
        Comanda comanda = new Comanda();
        comanda.addProdus(new Produs("Pizza", 20, 3));
        comanda.addProdus(new Produs("Pasta", 15, 5));

        ProxyComanda proxyComanda = new ProxyComanda(comanda, "Client1");
        System.out.println("Total comanda Client1: " + proxyComanda.calculTotal());
        proxyComanda.addComanda(comanda, "Client1");
        System.out.println("Total comanda Client1: " + proxyComanda.calculTotal());
        // Test composite
        CategorieProduse categorieElectronice = new CategorieProduse("Electronice");
        CategorieProduse categorieTelefoane = new CategorieProduse("Telefoane");
        CategorieProduse categorieLaptopuri = new CategorieProduse("Laptopuri");
        CategorieProduse categorieAudio = new CategorieProduse("Audio");

        categorieElectronice.adaugaProdus(categorieTelefoane);

        categorieTelefoane.adaugaProdus(new Produs("iPhone 14", 1000, 15));
        categorieTelefoane.adaugaProdus(new Produs("Samsung Galaxy S23", 1200, 20));
        categorieTelefoane.adaugaProdus(new Produs("Google Pixel 7", 700, 10));
        System.out.println("Structura completă a produselor din magazin:");
        categorieElectronice.afiseazaDetalii();
    }
}
