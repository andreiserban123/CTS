package creationale.simple_factory.program;

import creationale.factory_method.IFactory;

public class PizzaRomaFactory implements IFactory {
    @Override
    public IPizza creeaza() {
        return new PizzaRoma();
    }
}
