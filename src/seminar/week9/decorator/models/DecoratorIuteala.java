package seminar.week9.decorator.models;

public class DecoratorIuteala extends ADecorator {
    private int nivelIuteala;

    public DecoratorIuteala(IPizza pizza, int nivelIuteala) {
        super(pizza);
        this.nivelIuteala = nivelIuteala;
    }

    @Override
    public String getListaIngrediente() {
        if (nivelIuteala == 1) {
            return super.getListaIngrediente() + ", Iuteala usoara";
        } else if (nivelIuteala == 2) {
            return super.getListaIngrediente() + ", Iuteala medie";
        } else if (nivelIuteala == 3) {
            return super.getListaIngrediente() + ", Iuteala mare";
        } else {
            return super.getListaIngrediente() + ", Iuteala extrema";
        }
    }

    @Override
    public double getPret() {
        return super.getPret() + (nivelIuteala * 2);
    }
}
