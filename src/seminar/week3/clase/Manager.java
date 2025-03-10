package seminar.week3.clase;

public class Manager extends Angajat{

    public Manager(String nume) {
        super(nume);
    }

    @Override
    public float calculateSalary() {
        return 100;
    }
}
