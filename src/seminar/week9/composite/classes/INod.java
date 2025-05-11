package seminar.week9.composite.classes;

public interface INod {
    double getGreutate();

    boolean isFragil();

    void addNod(INod nod);

    void stergeNod(INod nod);

    INod getNod(int index);
}
