/**
 * Created by jakefroeb on 9/7/16.
 */
public class InventoryItem {
    protected String name;
    protected Integer quantity;
    protected String category;


    public InventoryItem(){}

    public InventoryItem(String name, Integer quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
