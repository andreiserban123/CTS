package teme.tema4.builder;

import java.util.ArrayList;
import java.util.List;

public class Magazin implements Cloneable {
    private String denumire;
    private int suprafata;
    private int nrIntrari;
    private boolean isPodeauaStandard;
    private double duritate;
    private List<String> materialeDecoratiuni = new ArrayList<>();

    Magazin() {
        this.nrIntrari = 1;
        this.isPodeauaStandard = true;
    }

    @Override
    public Magazin clone() throws CloneNotSupportedException {
        return (Magazin) super.clone();
    }

    void addMaterialDecoratiuni(String materialeDecoratiuni) {
        this.materialeDecoratiuni.add(materialeDecoratiuni);
    }

    public String getDenumire() {
        return denumire;
    }

    void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getSuprafata() {
        return suprafata;
    }

    void setSuprafata(int suprafata) {
        this.suprafata = suprafata;
    }

    public int getNrIntrari() {
        return nrIntrari;
    }

    void setNrIntrari(int nrIntrari) {
        this.nrIntrari = nrIntrari;
    }

    public boolean isPodeauaStandard() {
        return isPodeauaStandard;
    }

    void setPodeauaStandard(boolean podeauaStandard) {
        isPodeauaStandard = podeauaStandard;
    }

    public double getDuritate() {
        return duritate;
    }

    void setDuritate(double duritate) {
        this.duritate = duritate;
    }

    public List<String> getMaterialeDecoratiuni() {
        return materialeDecoratiuni;
    }

    @Override
    public String toString() {
        return "Magazin{" +
                "denumire='" + denumire + '\'' +
                ", suprafata=" + suprafata +
                ", nrIntrari=" + nrIntrari +
                ", isPodeauaStandard=" + isPodeauaStandard +
                ", duritate=" + duritate +
                ", materialeDecoratiuni=" + materialeDecoratiuni +
                '}';
    }
}
