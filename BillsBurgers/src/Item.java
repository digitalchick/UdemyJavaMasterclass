public class Item {
/*
   I've used inheritance for the Item and Burger relationships, which means Burger is an Item.
Every Item has a name, type, price or base price, and a size.

Item has the method getBasePrice, which is really just a getter method for the price, but the name is more descriptive.
Item also has getAdjustedPrice, and the printItem method.
These methods will exhibit different behavior, based on the runtime type, and we know that's polymorphism.
For the burger, the toppings or extras are individual attributes, and also have the type Item.
 */

    private String name;
    private String type;
    private double price;
    private String size;

    public Item(String name, String type, double price, String size){

        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
    }

    public double getBasePrice(){
        return price;
    }

    public double getAdjustedPrice(){
        return price;
    }

    public void printItem(){
        System.out.println(size + " " + type + " " + name + " --- " + "$" +  Double.toString(getAdjustedPrice()));
    }

    public String getType(){
        return type;
    }

    public String getSize(){
        return size;
    }
    protected void setPrice(double price){
        this.price = price;
    }

    protected void setSize(String size){
        this.size = size;
    }
}
