package creationale.factory_method;

import creationale.simple_factory.program.IPizza;
import creationale.simple_factory.program.PizzaVegetariana;

public class PizzaVegetarianaFactory implements IFactory {
    @Override
    public IPizza creeaza() {
        return new PizzaVegetariana();
    }
}
