import java.util.Scanner;
/*
You need a meal order.

This should be composed of exactly one burger, one drink, and one side item.
The most common meal order should be created without any arguments, like a regular burger,
  a small coke, and fries, for example.
You should be able to create other meal orders, by specifying different burgers, drinks, and side items.
You need a drink, and side item.
The drink should have at least a type, size and price, and the price of the drink should change for each size.
The side item needs at least a type and price.

For each meal order, you'll want to perform these functions:
Add some additional toppings to the burger.
Change the size of the drink.
Print the itemized list. This should include the price of the burger, any extra toppings, the drink price based on size,
  and the side item price.
Print the total due amount for the meal.
 */
public class Meal {

    private Burger burger;
    private SideItem side;
    private Drink drink;

    private double totalPrice;

    public Meal(){
        burger = new Burger();
        side = new SideItem();
        drink = new Drink();

        totalPrice = calculateFinalPrice();
    }

    public Meal(Burger burger, SideItem side, Drink drink) {
        this.burger = burger;
        this.side = side;
        this.drink = drink;

        totalPrice = calculateFinalPrice();
    }

    public static Meal getMeal(String burgerType, String sideType, String drinkType, String drinkSize){
        // Factory Method

        SideItem side = new SideItem(sideType);
        Drink drink = new Drink(drinkType, drinkSize);
        Burger burger;

        switch(burgerType.toLowerCase()){
            case "bacon cheeseburger" -> burger = new BaconCheeseBurger();
            case "california burger" -> burger = new CaliforniaBurger();
            case "deluxe burger" -> burger = new DeluxeBurger();
            default -> burger = new Burger();
        }


        return (new Meal(burger, side, drink));
    }

    private double calculateFinalPrice(){

        return (burger.getBasePrice() + side.getBasePrice() + drink.getBasePrice());
    }

    public void printReceipt(){
        System.out.println("");
        System.out.printf("-".repeat(30));
        System.out.println("");
        System.out.println("Receipt for the Meal");
        System.out.printf("%s with %s | $%s %n ", burger.getType(), burger.getToppings(), burger.getBasePrice());
        System.out.printf("%s | $%s %n", side.getType(), side.getBasePrice());
        System.out.printf("%s %s | $%s %n", drink.getSize(),drink.getType(), drink.getBasePrice());
        System.out.println("");
        System.out.printf("Total-------------------- %s%n", totalPrice);
        System.out.printf("-".repeat(30));
        System.out.println("");
    }

    public Burger getBurger() {
        return burger;
    }

    public SideItem getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public void setSide(SideItem side) {
        this.side = side;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public static Meal orderMeal(){
        Scanner s = new Scanner(System.in);
        String burgerNum;
        String sideNum;
        String drinkType;
        String drinkSize;
        Meal meal;
        String moreToppings;

        System.out.printf("Please pick the burger for your order:%n 1- Regular Burger%n" +
                "2 - Bacon Cheeseburger %n" +
                "3 - California Burger %n" +
                "4 - Deluxe Burger%n");

        burgerNum = s.nextLine();

        System.out.printf("Please pick a side %n" +
                "1 - Fries %n" +
                "2 - Onion Rings %n" +
                "3 - Side Salad%n");

        sideNum = s.nextLine();

        System.out.println("What kind of drink do you want?");

        drinkType = s.nextLine();

        System.out.println("What size drink do you want? Small, Medium, or Large?");

        drinkSize = s.nextLine();

        meal = getMeal(getBurgerTypeFromNumber(burgerNum), getSideTypeFromNumber(sideNum),drinkType, drinkSize );

        System.out.printf("You have ordered a %s that has %s toppings. Do you want additional toppings? Y / N", meal.getBurger().getType(), meal.getBurger().getToppings());

        moreToppings = s.nextLine();
        if((moreToppings.toUpperCase()).equals("Y")){
            meal.getBurger().addToppings();
        }

        return meal;
    }

    private static String getBurgerTypeFromNumber(String burgerNum){

        switch(burgerNum) {
            case "1" -> {return "Regular Burger";}
            case "2" -> {return "Bacon Cheeseburger";}
            case "3" -> {return "California Burger";}
            case "4" -> {return "Deluxe Burger";}
            default -> {return "Regular Burger";}
        }

    }

    private static String getSideTypeFromNumber(String sideNum){

        switch(sideNum) {
            case "1" -> {return "Fries";}
            case "2" -> {return "Onion Rings";}
            case "3" -> {return "Side Salad";}
            default -> {return "Fries";}
        }
    }
}
