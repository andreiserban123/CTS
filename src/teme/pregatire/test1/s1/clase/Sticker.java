package teme.pregatire.test1.s1.clase;

public class Sticker implements Cloneable {
    private String dimensiuni;

    Sticker(String dimensiuni) {
        this.dimensiuni = dimensiuni;
    }

    @Override
    public Sticker clone() throws CloneNotSupportedException {
        return (Sticker) super.clone();
    }
}
