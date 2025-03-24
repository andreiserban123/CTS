package seminar.week5.singleton.models;

public class Table {
    public static int idNext = 1;
    private int id;
    private int nrChairs;
    private boolean isOutside;
    private boolean isOccupied;

    public Table(int nrChairs, boolean isOutside) {
        this.id = idNext++;
        this.nrChairs = nrChairs;
        this.isOutside = isOutside;
        this.isOccupied = false;
    }

    public int getId() {
        return id;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getNrChairs() {
        return nrChairs;
    }

    public boolean isOutside() {
        return isOutside;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", nrChairs=" + nrChairs +
                ", isOutside=" + isOutside +
                ", isOccupied=" + isOccupied +
                '}';
    }
}


