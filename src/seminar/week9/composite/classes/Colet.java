package seminar.week9.composite.classes;

public class Colet implements INod {

    private boolean isFragil;
    private double greutate;

    public Colet(boolean isFragil, double greutate) {
        this.isFragil = isFragil;
        this.greutate = greutate;
    }

    @Override
    public double getGreutate() {
        return greutate;
    }

    @Override
    public boolean isFragil() {
        return isFragil;
    }

    @Override
    public void addNod(INod nod) {
        throw new UnsupportedOperationException("Nu se poate adauga noduri in colet");
    }

    @Override
    public void stergeNod(INod nod) {
        throw new UnsupportedOperationException("Nu se poate sterge noduri din colet");
    }

    @Override
    public INod getNod(int index) {
        return null;
    }
}
