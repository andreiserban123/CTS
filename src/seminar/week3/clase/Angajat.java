package seminar.week3.clase;

public abstract class Angajat {
    String nume;
    public abstract float calculateSalary();

    public Angajat(String nume) {
        this.nume = nume;
    }
}
