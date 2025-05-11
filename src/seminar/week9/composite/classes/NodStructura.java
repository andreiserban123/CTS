package seminar.week9.composite.classes;

import java.util.ArrayList;
import java.util.List;

public class NodStructura implements INod {

    private double greutateProprie;

    private List<INod> listaFii;

    public NodStructura(double greutateProprie) {
        this.greutateProprie = greutateProprie;
        this.listaFii = new ArrayList<>();
    }


    @Override
    public double getGreutate() {
        double greutate = this.greutateProprie;
        greutate += this.listaFii.stream().mapToDouble(INod::getGreutate).sum();
        return greutate;
    }

    @Override
    public boolean isFragil() {
        for (int i = 0; i < listaFii.size(); i++) {
            if (listaFii.get(i).isFragil()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addNod(INod nod) {
        this.listaFii.add(nod);
    }

    @Override
    public void stergeNod(INod nod) {
        this.listaFii.remove(nod);
    }

    @Override
    public INod getNod(int index) {
        return this.listaFii.get(index);
    }
}
