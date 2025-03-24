package seminar.week5.singleton.program;

import seminar.week5.singleton.models.Restaurant;
import seminar.week5.singleton.models.Table;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant1 = Restaurant.getInstance();
        Restaurant restaurant2 = Restaurant.getInstance();
        restaurant1.getTable(true, 3);
        if(restaurant1 == restaurant2){
            System.out.println("Restaurant 1 and Restaurant 2 are the same");
        }else{
            System.out.println("Restaurant 1 and Restaurant 2 are not the same");
        }

        restaurant1.addTable(new Table(4,true));
        restaurant1.addTable(new Table(3,true));
        restaurant1.addTable(new Table(5,false));
        restaurant1.addTable(new Table(4,true));
        restaurant1.addTable(new Table(4,false));

        System.out.println(restaurant1);
//        use case of the singleton by waiter
        System.out.println(restaurant1.getTable(false, 5));


    }
}
