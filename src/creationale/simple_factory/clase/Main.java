package creationale.simple_factory.clase;

import creationale.factory_method.IFactory;
import creationale.simple_factory.program.IPizza;
import creationale.simple_factory.program.PizzaRomaFactory;

public class Main {
    public static void main(String[] args) {
        IFactory factory = new PizzaRomaFactory();
        IPizza pizza = factory.creeaza();
        pizza.afisareDescriere();
    }
}
