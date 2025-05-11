package creationale.factory_method;

import creationale.simple_factory.program.ETipPizza;

public class PizzaRomaFactory {
    public IPizza creeaza(ETipPizza tip) {
        switch (tip) {
            case ROMA -> {
                return new PizzaRoma();
            }
            case VEGETARIANA -> {
                return new PizzaVegetariana();
            }
            default -> {
                return null;
            }
        }
    }
}
