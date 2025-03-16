package seminar.week3.clase;

public class Lucrator extends Angajat {

    public Lucrator(String nume) {
        super(nume);
    }

    @Override
    public float calculateSalary() {
        return 10;
    }
}
