package seminar.week9.proxy.main;

import seminar.week9.proxy.classes.IPestera;
import seminar.week9.proxy.classes.Pestera;
import seminar.week9.proxy.classes.ProxyPestera;

public class Main {
    public static void main(String[] args) {
        IPestera pestera = new Pestera();


        pestera.vizitare("Gigel");
        pestera.vizitare("Ion");
        pestera.vizitare("Ana");

        System.out.println(pestera.getNrVizitatori() + " au vizitat pestera");

        System.out.println("Dupa un timp folosim proxy");
        IPestera pesteraProxy = new ProxyPestera((Pestera) pestera);
        pesteraProxy.vizitare("Gigel");
        pesteraProxy.vizitare("Ion");
        pesteraProxy.vizitare("Ana");
        pesteraProxy.vizitare("Maria");
        pesteraProxy.vizitare("Mihai");

        pesteraProxy.vizitare("Andrei");
        pesteraProxy.vizitare("Cristi");
        System.out.println(pesteraProxy.getNrVizitatori() + " au vizitat pestera");


    }
}
