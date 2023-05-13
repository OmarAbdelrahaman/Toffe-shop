import java.util.*;

public class Customer {
    private int id;
    private String email;
    private String address;
    private Cart cart;
    private Order order;

    public Customer(int id, String email, String address) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.cart = new Cart();
        this.order = new Order();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }


    public void addToCart(Item item, int quantity) {
        cart.addToCart(item, quantity);
    }

    public void deleteFromCart(Item item) {
        cart.deleteFromCart(item);
    }

    public void showcart() {
        cart.displayCart();
    }

    public double makeOrder() {
        double total = cart.totalPrciceOrder();
        order.addCartToOrder(email, cart);
        cart.clearCart();
        return total;
    }

    public void showOrder() {
        order.displayOrder(email, order.getIdCounter());
    }



    public void showOrderHistory() {
        order.displayOrderHistory(email);
    }

    public void reOrder(int orderId) {
        //order.reOrder(email, orderId);
    }
}
