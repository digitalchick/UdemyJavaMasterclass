public class Drink extends Item {

    public Drink(){
        super("Drink","Coke", 1.29, "Medium" );

    }

    public Drink(String type, String size) {
        super("Drink", type, 1.29, size);
        switch( size.toLowerCase()){
            case "medium" -> this.setPrice(1.59);
            case "large" -> this.setPrice(1.79);
            default -> this.setPrice(1.29);
        }
    }


    public void upsizeDrink(String size){
        this.setSize(size);
        this.setPrice(this.getBasePrice() + 0.30);
    }


}
