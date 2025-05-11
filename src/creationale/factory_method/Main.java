package creationale.factory_method;

import creationale.simple_factory.program.ETipPizza;

public class Main {
    public static void main(String[] args) {
        PizzaRomaFactory factory = new PizzaRomaFactory();
        IPizza pizza = factory.creeaza(ETipPizza.ROMA);
        pizza.afisareDescriere();
    }
}
