import java.util.Scanner;
/*
You need burgers.
Every hamburger should have a burger type, a base price, and up to a maximum of three extra toppings.
The constructor should include only the burger type and price.
Extra Toppings on a burger need to be added somehow, and priced according to their type.
The deluxe burger bonus.
Create a deluxe burger meal, with a deluxe burger, that has a set price, so that any additional toppings
  do not change the price.
The deluxe burger should have room for an additional two toppings.

 */
public class Burger extends Item {
    protected String toppings;

    public Burger(){
        super("Burger", "Regular", 3.99, "Medium");

        toppings = "Pickles, Mustard, Ketchup";
    }
    protected Burger(String type, double price, String toppings){
        super("Burger", type, price, "Medium");
        this.toppings = toppings;
    }


    public String getToppings(){
        return toppings;
    }

    public void addToppings(){
        Scanner s = new Scanner(System.in);
        System.out.println("The " + getType() + " burger already has the following toppings: " + toppings);
        System.out.println("Please enter up to 3 extra toppings for the " + getType() + " burger, enter topping or D for Done:");
        String addedTopping;
        for(int i=0; i<3;i++){
            addedTopping = s.nextLine();
            if ("Dd".contains(addedTopping)){
                break;
            }else{
                toppings += ", " + addedTopping;
            }
        }

        System.out.println("The Toppings are now: " + toppings);

    }

}

class BaconCheeseBurger extends Burger{

    public BaconCheeseBurger(){
        super("Bacon Cheeseburger", 4.99, "Bacon, Cheese, Ketchup, Pickles");

    }

}

class CaliforniaBurger extends Burger{

    public CaliforniaBurger(){
        super(" California Burger", 5.49, "Avocado, GoatCheese, Aioli Mayo");

    }

}
