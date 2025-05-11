package seminar.week9.decorator.classes;

public class PizzaRoma implements IPizza {
    @Override
    public String getListaIngrediente() {
        return "Blat crocant, sos rosii, cascaval";
    }

    @Override
    public double getPret() {
        return 25.0;
    }
}
