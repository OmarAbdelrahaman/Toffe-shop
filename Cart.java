import java.util.*;

public class Cart {
    private Map<Item, Integer> items; // map of items and their quantity

    public Cart() {
        items = new HashMap<>();
    }

    public void addToCart(Item item, int quantity) {
        if (items.containsKey(item)) {
            int currentQuantity = items.get(item);
            items.put(item, currentQuantity + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public void deleteFromCart(Item item) {
        items.remove(item);
    }

    public void clearCart() {
        items.clear();
    }

    public void displayCart() {
        System.out.println("Current Cart:");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(item.getName() + " x " + quantity + " = $" + item.getPrice() * quantity);
        }
    }

    public double totalPrciceOrder(){
        double total = 0.0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()){
            Item item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;

        }
        return total;
    }

}

