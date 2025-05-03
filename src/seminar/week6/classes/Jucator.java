package seminar.week6.classes;

import java.util.ArrayList;
import java.util.List;

public class Jucator implements IClone {
    private String name;
    private TipJucator tip;
    private List<String> medicamente;
    private List<String> antrenamente;

    Jucator(String name, TipJucator tip) throws InterruptedException {
        System.out.println("Preluare din surse exterioare despre: " + tip);
        Thread.sleep(1000);
        this.name = name;
        switch (tip) {
            case ATACANT -> {
                medicamente = new ArrayList<>();
                medicamente.add("med1");
                medicamente.add("med2");

                antrenamente = new ArrayList<>();
                antrenamente.add("antrenament_atacant_1");
                antrenamente.add("antrenament_atacant_2");

            }
            case FUNDAS -> {
                medicamente = new ArrayList<>();
                medicamente.add("med3");
                medicamente.add("med4");
                antrenamente = new ArrayList<>();
                antrenamente.add("antrenament_fundas_1");
                antrenamente.add("antrenament_fundas_2");
            }
            case PORTAR -> {
                medicamente = new ArrayList<>();
                medicamente.add("med5");
                medicamente.add("med6");
                antrenamente = new ArrayList<>();
                antrenamente.add("antrenament_portar_1");
                antrenamente.add("antrenament_portar_2");
            }
            default -> throw new InterruptedException();
        }
        this.tip = tip;
    }

    public void addMedicament(String medicament) {
        this.medicamente.add(medicament);
    }

    public void updateAntrenamente(String antrenamentVeche, String antrenamentNou) {
        int index = this.antrenamente.indexOf(antrenamentVeche);
        if (index != -1) {
            this.antrenamente.set(index, antrenamentNou);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addAntrenamente(String antrenamente) {
        this.antrenamente.add(antrenamente);
    }

    public void setNume(String nume) {
        this.name = nume;
    }

    @Override
    protected Jucator clone() throws CloneNotSupportedException {
        Jucator clone = (Jucator) super.clone();
        clone.tip = this.tip;
        clone.name = this.name;
        clone.medicamente = this.medicamente; // pentru ca partajeaza lista de medicamente
        clone.antrenamente = new ArrayList<>(this.antrenamente); // pentru ca fiecare are antrenamentele lui
        return clone;
    }

    @Override
    public String toString() {
        return "Jucator{" +
                "name='" + name + '\'' +
                ", tip=" + tip +
                ", medicamente=" + medicamente +
                ", antrenamente=" + antrenamente +
                '}';
    }
}
