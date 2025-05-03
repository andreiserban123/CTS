package seminar.week9.decorator.main;

import seminar.week9.decorator.models.DecoratorCheesyBites;
import seminar.week9.decorator.models.DecoratorIuteala;
import seminar.week9.decorator.models.IPizza;
import seminar.week9.decorator.models.PizzaItaliana;

public class Main {
    public static void main(String[] args) {
        IPizza pizza = new PizzaItaliana();
        IPizza pizzaDecorata = new DecoratorCheesyBites(pizza);
        System.out.println(pizza.getListaIngrediente());
        System.out.println(pizzaDecorata.getListaIngrediente());
        pizzaDecorata = new DecoratorIuteala(pizzaDecorata, 1);
        System.out.println(pizzaDecorata.getListaIngrediente());
        System.out.println(pizzaDecorata.getPret());
    }
}
