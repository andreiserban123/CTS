package seminar.week6.pregatire.clase;

public class VremeConexiune extends Conexiune {
    VremeConexiune() {
    }

    @Override
    public void connect() {
        System.out.println("S-a conectat vreme");
    }
}
