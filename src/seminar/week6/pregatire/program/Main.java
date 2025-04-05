package seminar.week6.pregatire.program;

import seminar.week6.pregatire.clase.Client;
import seminar.week6.pregatire.clase.Conexiune;

public class Main {
    public static void main(String[] args) {
        Client c = new Client("Michael");

        var con1 = Conexiune.getConexiune(c);
        var con2 = Conexiune.getConexiune(c);

        Client c2 = new Client("Armin");
        var con3 = Conexiune.getConexiune(c2);


        System.out.println(con1);
        System.out.println(con2);
        System.out.println(con3);
    }
}
