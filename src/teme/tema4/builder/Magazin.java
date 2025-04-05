package teme.tema4.builder;

import java.util.List;

public class Magazin implements Cloneable {
    private String denumire;
    private int suprafata;
    private int nrIntrari;
    private boolean isPodeauaStandard;
    private double duritate;
    private List<String> materialeDecoratiuni;


    public Magazin(String denumire, int suprafata, int nrIntrari, boolean isPodeauaStandard, double duritate, List<String> materialeDecoratiuni) {
        this.denumire = denumire;
        this.suprafata = suprafata;
        this.nrIntrari = nrIntrari;
        this.isPodeauaStandard = isPodeauaStandard;
        this.duritate = duritate;
        this.materialeDecoratiuni = materialeDecoratiuni;
    }

    @Override
    public Magazin clone() throws CloneNotSupportedException {
        return (Magazin) super.clone();
    }


    public List<String> getMaterialeDecoratiuni() {
        return materialeDecoratiuni;
    }

    public int calculGradIncendiu() {
        int grad = 0;
        if (duritate < 2) {
            grad++;
        }
        if (getMaterialeDecoratiuni().contains("Sticla")) {
            grad++;
        }
        if (getMaterialeDecoratiuni().contains("Lemn")) {
            grad++;
        }
        return grad;
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
