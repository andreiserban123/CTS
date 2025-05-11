package seminar.week9.decorator.main;

import seminar.week9.decorator.classes.*;

public class Main {
    public static void main(String[] args) {
        IPizza pizza = new PizzaItalia();
        IPizza pizza2 = new PizzaRoma();
        System.out.println(pizza2.getListaIngrediente());
        System.out.println(pizza.getListaIngrediente());

        System.out.println("Folosind decoratori");

        IPizza pizzaDecorata = new DecoratorCheesyBites(pizza);
        IPizza pizzaDecorata2 = new DecoratorCheesyBites(new PizzaItalia());

        System.out.println(pizzaDecorata.getListaIngrediente());
        System.out.println("Pizza italia: " + pizzaDecorata.getListaIngrediente());
        IPizza pizzaDecorataDublu = new DecoratorIuteala(pizzaDecorata, 2);
        System.out.println("Pizza italia cu iuteala: " + pizzaDecorataDublu.getListaIngrediente());
    }
}
