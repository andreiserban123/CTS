package seminar.week9.decorator.classes;

public class DecoratorIuteala extends ADecorator {

    private int nivelIuteala;

    public DecoratorIuteala(IPizza pizza, int nivelIuteala) {
        super(pizza);
        this.nivelIuteala = nivelIuteala;
    }

    @Override
    public String getListaIngrediente() {
        if (nivelIuteala == 1) {
            return super.getListaIngrediente() + ", ardei iute";
        } else if (nivelIuteala == 2) {
            return super.getListaIngrediente() + ", ardei iute, jalapeno";
        } else if (nivelIuteala == 3) {
            return super.getListaIngrediente() + ", ardei iute, jalapeno, habanero";
        } else {
            throw new IllegalArgumentException("Nivelul de iuteala nu este valid");
        }
    }

    @Override
    public double getPret() {
        return super.getPret() + 2.0;
    }
}
