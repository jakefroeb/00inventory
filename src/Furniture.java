/**
 * Created by jakefroeb on 9/7/16.
 */
public class Furniture extends InventoryItem{

    public Furniture(String name, int quantity){
        super(name,quantity);
        this.category = "Furniture";
    }
}
