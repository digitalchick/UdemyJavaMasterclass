import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/*
ArrayList Challenge Instructions:

The challenge is to create an interactive console program.
And give the user a menu of options as shown here:

Available Actions:

0 - to Shutdown

1- to add item(s) to list ( comma delimited list)

2- to remove any items (comma delimited list)

Enter a number for which action you want to do:

Using the Scanner class, solicit a menu item, 0, 1 or 2,  and process
the item accordingly.

*Your grocery list should be an ArrayList.
*You should use methods on the ArrayList, to add items, remove items,
  check if an item is already in the list, and print a sorted list.
*You should print the list, sorted alphabetically, after each operation.
*You shouldn't allow duplicate items in the list.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        String item;
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean stillGoing = true;

        while(stillGoing){
            System.out.println("This is your current grocery list: " + groceryList);
            System.out.println();
            System.out.print(optionsString());
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> groceryList = addItem(groceryList);
                case 2 -> groceryList = removeItem(groceryList);
                default -> stillGoing = false;
            }

            groceryList.sort(Comparator.naturalOrder());
            System.out.println("Grocery List: " + groceryList);
            System.out.println();

        }
    }

    public static String optionsString(){
        String optionsScreen = """
                Available actions:
                                
                0 - to shutdown
                                
                1 - to add item(s) to list (comma delimited list)
                                
                2 - to remove any items (comma delimited list)
                                
                Enter a number for which action you want to do:
                """;
        return optionsScreen;
    }

    public static ArrayList<String> addItem(ArrayList<String> list){
        Scanner scanner = new Scanner(System.in);
        String item;

        System.out.println("Please enter the item you want to add:");
        item = scanner.nextLine();
        String[] items = item.toLowerCase().split(",");
        ArrayList<String> itemsList = new ArrayList(List.of(items));
        
        for(int i=0;i<itemsList.size();i++){
            itemsList.set(i,itemsList.get(i).trim());
            if(list.contains(itemsList.get(i))){
                System.out.println("List already contains: " + itemsList.get(i));
                itemsList.remove(i);

            }
        }
        System.out.println(itemsList);

        list.addAll(itemsList);
        System.out.println("Your item(s) is added!");


        return list;
    }

    public static ArrayList<String> removeItem(ArrayList<String> list){
        Scanner scanner = new Scanner(System.in);
        String item;


        System.out.println("Please enter the item you want to remove:");

        item = scanner.nextLine();
        String[] items = item.toLowerCase().split(",");

        list.removeAll(List.of(items));
         System.out.println("Your items are removed");
        return list;
    }
}
