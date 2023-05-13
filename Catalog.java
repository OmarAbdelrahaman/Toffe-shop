import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Catalog implements Serializable{
    private List<Item> items;

    public Catalog() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> searchItemsByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(name)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> searchItemsByBrand(String brand) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getBrand().equals(brand)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item getItemsByname(String category) {
       // List<Item> result = new ArrayList<>();
        Item ressult = null;
        for (Item item : items) {
            if (item.getName().equals(category)) {
                ressult = item;
            }
        }
        return ressult;

    }

    public void saveToFile(){
        FileManager.save((Object) this.items, "Catalog");
    }

    public static Catalog loadFromFile(){
        Catalog catalog = new Catalog();
        catalog.items = (ArrayList<Item>)FileManager.load("Catalog");
        return catalog;
    }
}