import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private static int idCounter = 0;
    private Map<String, List<Cart>> orders;

    public Order() {
        orders = new HashMap<>();
    }
    public int getIdCounter() {
        return idCounter;
    }


    public void addCartToOrder(String email, Cart cart) {
        if (orders.containsKey(email)) {
            orders.get(email).add(cart);
        } else {
            List<Cart> cartList = new ArrayList<>();
            cartList.add(cart);
            orders.put(email, cartList);
        }
        System.out.println("Order placed successfully!");
        System.out.println("Your order ID is: " + ++idCounter);
    }

    public void displayOrder(String email, int orderId) {
        if (orders.containsKey(email)) {
            List<Cart> cartList = orders.get(email);
            for (int i = 0; i < cartList.size(); i++) {
                if (i + 1 == orderId) {
                    Cart cart = cartList.get(i);
                    cart.displayCart();
                    return;
                }
            }
            System.out.println("Order ID not found!");
        } else {
            System.out.println("No orders found for email " + email);
        }
    }

//    public void reOrder(String email, int orderId) {
//        if (orders.containsKey(email)) {
//            List<Cart> cartList = orders.get(email);
//            for (int i = 0; i < cartList.size(); i++) {
//                if (i + 1 == orderId) {
//                    Cart cart = cartList.get(i);
//                    for (Map.Entry<Item, Integer> entry : cart.getItems().entrySet()) {
//                        Item item = entry.getKey();
//                        int quantity = entry.getValue();
//                        item.decreaseStock(quantity);
//                    }
//                    System.out.println("Order has been re-ordered successfully!");
//                    return;
//                }
//            }
//            System.out.println("Order ID not found!");
//        } else {
//            System.out.println("No orders found for email " + email);
//        }
//    }

    public void displayOrderHistory(String email) {
        if (orders.containsKey(email)) {
            List<Cart> cartList = orders.get(email);
            for (int i = 0; i < cartList.size(); i++) {
                Cart cart = cartList.get(i);
                System.out.println("Order ID: " + (i + 1));
                cart.displayCart();
            }
        } else {
            System.out.println("No orders found for email " + email);
        }
    }
}
