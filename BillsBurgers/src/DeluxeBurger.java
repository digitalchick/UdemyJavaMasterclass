import java.util.Scanner;
/*
The deluxe burger bonus.
Create a deluxe burger meal, with a deluxe burger, that has a set price, so that any additional toppings
  do not change the price.
The deluxe burger should have room for an additional two toppings.
 */
public class DeluxeBurger extends Burger {

    public DeluxeBurger(){
        super("Deluxe Burger", 5.99, "Lettuce, Tomato, Onion, Cheese, Ketchup, Mustard, Mayonaise, Ketchup, Pickles");

    }

    public void addToppings(){
        Scanner s = new Scanner(System.in);
        System.out.println("The " + getType() + " burger already has the following toppings: " + toppings);
        System.out.println("Please enter up to 2 extra toppings for the " + getType() + " burger, enter topping or D for Done:");
        String addedTopping;
        for(int i=0; i<2;i++){
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

