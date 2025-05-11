package seminar.week9.decorator.classes;

public class PizzaItalia implements IPizza {
    @Override
    public String getListaIngrediente() {
        return "Blat, sos rosii, salam";
    }

    @Override
    public double getPret() {
        return 30.0;
    }
}
