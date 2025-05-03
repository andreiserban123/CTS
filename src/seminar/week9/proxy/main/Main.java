package seminar.week9.proxy.main;

import seminar.week9.proxy.models.IPestera;
import seminar.week9.proxy.models.Pestera;
import seminar.week9.proxy.models.PesteraProxy;

public class Main {
    public static void main(String[] args) {
        IPestera pestera = new Pestera();
        IPestera pesteraProxy = new PesteraProxy((Pestera) pestera);

        pesteraProxy.vizitare("Ion");
        pesteraProxy.vizitare("Maria");
        pesteraProxy.vizitare("Andrei");
        pesteraProxy.vizitare("Ana");
        pesteraProxy.vizitare("Mihai");
        pesteraProxy.vizitare("Elena");
        pesteraProxy.vizitare("George");
        pesteraProxy.vizitare("Ioana");
        
    }
}
