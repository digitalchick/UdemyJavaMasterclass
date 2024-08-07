public class SideItem extends Item {

    public SideItem(){
        super("Side Item", "Fries", 1.79, "Small");
        //type = "Small Fry";
        this.setPrice(1.79);
    }

    public SideItem(String type){
       super("Side Item", type, 1.79, "Medium");
        calculatePrice();
    }


    private void calculatePrice(){

        switch(this.getType()){
            case "Onion Rings" -> {this.setPrice(2.19);}
            case "Side Salad" -> {this.setPrice(2.49);}
            default -> {this.setPrice(1.79);}
        }
    }
}
