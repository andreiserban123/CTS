package seminar.week9.decorator.classes;

public abstract class ADecorator implements IPizza {
    protected IPizza pizza;

    public ADecorator(IPizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getListaIngrediente() {
        return pizza.getListaIngrediente();
    }

    @Override
    public double getPret() {
        return pizza.getPret();
    }
}
