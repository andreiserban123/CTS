package seminar.week6.pregatire.clase;

import java.util.HashMap;
import java.util.Map;

public abstract class Conexiune implements ServiceConnection {
    private static Map<String, Conexiune> conexiuni = new HashMap<>();

    static {
        conexiuni.put("gps", new GpsConexiune());
        conexiuni.put("vreme", new VremeConexiune());
        conexiuni.put("baza", new BazaConexiune());
    }

}