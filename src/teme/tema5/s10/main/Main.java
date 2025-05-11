package teme.tema5.s10.main;

import teme.tema5.s10.clase.FiltruMarca;
import teme.tema5.s10.clase.FiltruPretMaxim;
import teme.tema5.s10.clase.ICautare;
import teme.tema5.s10.clase.Pantof;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pantof> produse = new ArrayList<>();
        produse.add(new Pantof(1, "Nike", "Air Force 1", 499.99, 42, "alb", "unisex", "piele", true));
        produse.add(new Pantof(2, "Adidas", "Superstar", 399.99, 41, "negru", "unisex", "piele", true));
        produse.add(new Pantof(3, "Puma", "Suede", 349.99, 44, "rosu", "barbati", "piele intoarsa", false));
        produse.add(new Pantof(4, "Nike", "Air Jordan", 699.99, 43, "negru", "barbati", "piele", true));
        produse.add(new Pantof(5, "Converse", "Chuck Taylor", 299.99, 39, "negru", "unisex", "textil", true));
        produse.add(new Pantof(6, "Reebok", "Classic", 349.99, 40, "alb", "femei", "piele", false));
        produse.add(new Pantof(7, "New Balance", "574", 449.99, 42, "gri", "unisex", "textil", true));
        produse.add(new Pantof(8, "Vans", "Old Skool", 379.99, 43, "negru", "unisex", "textil", true));
        produse.add(new Pantof(9, "Timberland", "Premium", 799.99, 44, "maro", "barbati", "piele", true));

        ICautare filtruMarca = new FiltruMarca("Nike");
        ICautare filtruPretMaxim = new FiltruPretMaxim(800);
        filtruMarca.setSuccesor(filtruPretMaxim);

        List<Pantof> produseFiltrate = filtruMarca.filtreazaProduse(produse);

        System.out.println("Produse filtrate:");
        for (Pantof pantof : produseFiltrate) {
            System.out.println(pantof);
        }
    }
}
