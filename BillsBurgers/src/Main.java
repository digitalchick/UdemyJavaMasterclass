public class Main {
/*
Your main method should have code to do the following:
Create a default meal, that uses the no arguments constructor.
Create a meal with a burger, and the drink and side item of your choice, with up to 3 extra toppings.
Create a meal with a deluxe burger, where all items, drink, side item and toppings up to 5 extra toppings,
  are included in the burger price.


 */
    public static void main(String[] args) {
      Meal meal = Meal.getMeal("Bacon Cheeseburger","Small Onion Ring",  "Iced Tea", "Medium");
      meal.getBurger().addToppings();
      meal.printReceipt();

        Meal meal2 = Meal.orderMeal();
        meal2.printReceipt();
    }
}
