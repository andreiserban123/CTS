package teme.tema4.builder;

import java.util.ArrayList;
import java.util.List;

public class MagazinBuilder {

    private String denumire;
    private int suprafata;
    private int nrIntrari;
    private boolean isPodeauaStandard;
    private double duritate;
    private List<String> materialeDecoratiuni = new ArrayList<>();

    public MagazinBuilder setDuritate(double duritate) {
        this.duritate = duritate;
        return this;
    }

    public MagazinBuilder setDenumire(String denumire) {
        this.denumire = denumire;
        return this;
    }

    public MagazinBuilder setSuprafata(int suprafata) {
        this.suprafata = suprafata;
        return this;
    }

    public MagazinBuilder setNrIntrari(int nrIntrari) {
        this.nrIntrari = nrIntrari;
        return this;
    }

    public MagazinBuilder setPodeauaStandard(boolean podeauaStandard) {
        isPodeauaStandard = podeauaStandard;
        return this;
    }

    public MagazinBuilder addMaterialDecoratiuni(String decoratiune) {
        this.materialeDecoratiuni.add(decoratiune);
        return this;
    }

    public Magazin build() throws Exception {
        var magazinNou = new Magazin(denumire, suprafata, nrIntrari, isPodeauaStandard, duritate, materialeDecoratiuni);
        this.materialeDecoratiuni = new ArrayList<>();
        return magazinNou;
    }

}
