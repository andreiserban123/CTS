package seminar.week6.pregatire.clase;

import java.util.HashMap;

public class Conexiune {

    private static HashMap<Client, Conexiune> map = new HashMap<>();
    private boolean isConnected;

    private Conexiune() {
        System.out.println("O noua conexiune");
        isConnected = true;
    }


    public static Conexiune getConexiune(Client c) {
        if (map.containsKey(c)) {
            return map.get(c);
        }
        var conexiune = new Conexiune();
        map.put(c, conexiune);
        return conexiune;
    }
}
