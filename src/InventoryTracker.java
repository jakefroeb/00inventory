import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jakefroeb on 9/7/16.
 */
public class InventoryTracker {
    public static void main(String[] args) {
        ArrayList<InventoryItem> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1. Add item to inventory");
            System.out.println("2. Remove an item from inventory");
            System.out.println("3. Update quantity of an item");

            String option = scanner.nextLine();

            if(option.equals("1")){
                addItem(items, scanner);
            }
            else if( option.equals("2")){
                removeItem(items, scanner);
            }
            else if(option.equals("3")){
                updateQauntity(items, scanner);
            }
            else{
                System.out.println("Invalid option");
            }
            int i = 1;
            for(InventoryItem item : items){

                int quantity = item.getQuantity();
                String name = item.getName();
                String category =item.getCategory();
                System.out.printf("%s . %s [%s] %s\n",i,category,quantity,name);
                i++;
            }
            System.out.println("Options");
        }

    }

    private static void addItem (ArrayList<InventoryItem> items, Scanner scanner) {
        System.out.println("Please enter the category for the item");
        String category = scanner.nextLine();
        boolean found = false;
        do {
            try {
                found = checkCategory(category);
            } catch (Exception e) {
                System.out.println("Invalid category please select a new category");
                category = scanner.nextLine();
            }
        }while(!found);

        System.out.println("Please enter the name of the item.");
        String itemName = scanner.nextLine();
        System.out.println("Please enter the ammount of " + itemName);
        Integer quantity = Integer.parseInt(scanner.nextLine());
        createItem(items,itemName,quantity,category);
    }

    private static boolean checkCategory(String category) throws Exception {

        if(category.equalsIgnoreCase("food") || category.equalsIgnoreCase("electronics") ||
                category.equalsIgnoreCase("furniture") || category.equalsIgnoreCase("drinks")
                || category.equalsIgnoreCase("clothing")){
            return true;
        }
        else{
            throw new Exception("Invalid category!");
        }
    }

    private static void createItem(ArrayList<InventoryItem> items,String name, int quantity, String category){
        if(category.equalsIgnoreCase("food")){
            Food food = new Food(name,quantity,category);
            items.add(food);
        }else if(category.equalsIgnoreCase("electronics")){
            Electronics electronics = new Electronics(name,quantity,category);
            items.add(electronics);
        }else if(category.equalsIgnoreCase("furniture")){
            Furniture furniture = new Furniture(name,quantity,category);
            items.add(furniture);
        }else if(category.equalsIgnoreCase("drinks")){
            Drinks drinks = new Drinks(name,quantity,category);
            items.add(drinks);
        }else if(category.equalsIgnoreCase("clothing")){
            Clothing clothing = new Clothing(name,quantity,category);
            items.add(clothing);
        }

    }

    private static void removeItem(ArrayList<InventoryItem> items, Scanner scanner) {
        System.out.println("Enter the item number you would wish to remove");
        Integer itemNumber = Integer.parseInt(scanner.nextLine());
        items.remove(itemNumber - 1);
    }

    private static void updateQauntity(ArrayList<InventoryItem> items, Scanner scanner) {
        System.out.println("Enter the item number of the item you wish to update the quantity");
        Integer itemNumber = Integer.parseInt(scanner.nextLine());
        InventoryItem item = items.get(itemNumber - 1);
        System.out.println("Please enter the new quantity of this item");
        Integer newQuantity = Integer.parseInt(scanner.nextLine());
        item.setQuantity(newQuantity);
        items.set(itemNumber-1 , item);
    }
}
