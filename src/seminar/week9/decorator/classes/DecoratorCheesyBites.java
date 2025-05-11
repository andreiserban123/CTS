package seminar.week9.decorator.classes;

public class DecoratorCheesyBites extends ADecorator {
    public DecoratorCheesyBites(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String getListaIngrediente() {
        return super.getListaIngrediente() + ", margini branzoase";
    }

    @Override
    public double getPret() {
        return super.getPret() + 10.0;
    }
}
