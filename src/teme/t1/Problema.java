package teme.t1;


public class Problema {
    private int[] punctaje;

    public Problema(int[] punctaje) {
        if (punctaje == null) {
            throw new RuntimeException("The vector cannot be null");
        }
        this.punctaje = punctaje;
    }

    public int getPozitie(int pct) {
        if (punctaje.length == 0) {
            throw new RuntimeException("The array is empty");
        }
        boolean exists = false;
        for (int p : punctaje) {
            if (p == pct) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            throw new RuntimeException("The point doesn't exists");
        }


        int countLarger = 0;
        java.util.Set<Integer> valoriUnice = new java.util.HashSet<>();

        for (int p : punctaje) {

            // Add to set returns true if the value wasn't already in the set
            if (p > pct && valoriUnice.add(p)) {
                countLarger++;
            }
        }

        return countLarger + 1;
    }
}