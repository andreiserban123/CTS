package seminar.week9.composite.models;

public class Colet implements INod {

    private double greutate;
    private boolean isFragil;


    public Colet(double greutate, boolean isFragil) {
        this.greutate = greutate;
        this.isFragil = isFragil;
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
    public void adaugaNod(INod nod) {
        throw new UnsupportedOperationException("Not supported for leaf nodes");
    }

    @Override
    public void stergeNod(INod nod) {
        throw new UnsupportedOperationException("Not supported for leaf nodes");

    }

    @Override
    public INod getNod(int index) {
        throw new UnsupportedOperationException("Not supported for leaf nodes");
    }


}
