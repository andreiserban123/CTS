package creationale.clase;

import creationale.factory_method.IFactory;
import creationale.factory_method.PizzaVegetarianaFactory;
import creationale.simple_factory.program.IPizza;

public class Main {
    public static void main(String[] args) {
        IFactory factory = new PizzaVegetarianaFactory();
        IPizza pizza = factory.creeaza();
        pizza.afisareDescriere();
    }
}
