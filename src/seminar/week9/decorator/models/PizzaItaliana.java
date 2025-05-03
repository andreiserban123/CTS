package seminar.week9.decorator.models;

public class PizzaItaliana implements IPizza {
    @Override
    public String getListaIngrediente() {
        return "rosiii, busuioc, mozzarella";
    }

    @Override
    public double getPret() {
        return 20;
    }
}
