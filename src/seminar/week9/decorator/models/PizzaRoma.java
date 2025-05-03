package seminar.week9.decorator.models;

public class PizzaRoma implements IPizza {
    @Override
    public String getListaIngrediente() {
        return "sos rosii, salam, ceapa";
    }

    @Override
    public double getPret() {
        return 12;
    }
}
