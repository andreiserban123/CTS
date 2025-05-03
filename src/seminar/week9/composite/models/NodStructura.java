package seminar.week9.composite.models;

import java.util.ArrayList;
import java.util.List;

public class NodStructura implements INod {

    private double greutate;
    private List<INod> listaCopii;

    public NodStructura(double greutate) {
        this.greutate = greutate;
        this.listaCopii = new ArrayList<>();
    }

    @Override
    public double getGreutate() {
        return greutate + listaCopii.stream().mapToDouble(INod::getGreutate).sum();
    }

    @Override
    public boolean isFragil() {
        return listaCopii.stream().filter(INod::isFragil).count() > 0;
    }

    @Override
    public void adaugaNod(INod nod) {
        this.listaCopii.add(nod);
    }

    @Override
    public void stergeNod(INod nod) {
        this.listaCopii.remove(nod);
    }

    @Override
    public INod getNod(int index) {
        if (index < 0 || index >= listaCopii.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return listaCopii.get(index);
    }
}
