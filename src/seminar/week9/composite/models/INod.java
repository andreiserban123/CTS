package seminar.week9.composite.models;

public interface INod {

    double getGreutate();

    boolean isFragil(); // nodul este fragil daca ajunge sa aibe containere fragile


    void adaugaNod(INod nod);

    void stergeNod(INod nod);

    INod getNod(int index);
}
