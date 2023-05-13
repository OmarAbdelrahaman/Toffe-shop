import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersList usersList = UsersList.loadFromFile();
//        UsersList usersList = new UsersList();
        Catalog catalog = Catalog.loadFromFile();
       // Item item = new Item("om ali","b","d","z","x",54002544,0.6);
        //catalog.addItem(item);
        System.out.println("Welcome to our site, choose what you want to do\n" +
                "1-Login\n" +
                "2-Register\n" +
                "3-Show Catalog\n");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String email, password, address;
        switch (input){
            case 1:
                Login login = new Login(usersList);
                System.out.println("plz enter your email: ");
                email = scanner.next();
                System.out.println("\nplz enter your password: ");

                password = scanner.next();
                if(login.isLoginSuccessful(email, password)) {
                    Customer c= new Customer (5,"adds","sdfs") ;
                    usersList.setCurrentLoggedUser(usersList.findUserByEmail(email).get(0));
                    System.out.println("\nlogin succeed, Welcome to our shop\nthis is a catalog");
                    System.out.println(catalog.getItems());
                    int input1 = 0;
                    int max = 0;
                    String name;
                    while (input1 != 6) {
                        System.out.println(" choose what you want to do\n 1-add to cart" +
                                "\n2-delete from cart \n3-show cart \n4-make order \n5-show catalog again \n6-exit ");
                        input1 = scanner.nextInt();
                        switch (input1) {
                            case 1:
                                int q;
                                if (max < 50) {
                                    System.out.println("plz enter name of order: ");
                                    name = scanner.next();
                                    while (catalog.getItemsByname(name) == null) {
                                        System.out.println("\nplz enter correct name: ");
                                        name = scanner.next();
                                    }
                                    System.out.println("plz enter quantity of order know tha max is 50 and min 1: ");
                                    q = scanner.nextInt();
                                    while (q > 50 || q < 0) {
                                        System.out.println("plz enter quantity of order know tha max is 50 and min 1: ");
                                        q = scanner.nextInt();
                                    }
                                    max += q;
                                    if (max > 50)
                                        max = 50;
                                    c.addToCart(catalog.getItemsByname(name), q);
                                } else
                                    System.out.println("you reach a maximum quantity in one order\n");
                                break;
                            case 2:
                                System.out.println("plz enter name of order want to remove from cart: ");
                                name = scanner.next();
                                if (catalog.getItemsByname(name) == null) {
                                    System.out.println("\norder does not exist in cart ");
                                } else {
                                    c.deleteFromCart(catalog.getItemsByname(name));
                                }
                                break;
                            case 3:
                                System.out.println("content of cart :\n ");
                                c.showcart();
                                break;
                            case 4:
                                double price = c.makeOrder();
                                System.out.println("\ntotal price is: " + price);
                                System.out.println("\nclick 0 if you want to pay and confirm order: ");
                                int y = scanner.nextInt();
                                if (y == 0) {
                                    String phn, Address;
                                    System.out.println("\nplz enter phone number: ");
                                    phn = scanner.next();
                                    System.out.println("\nclick 0 if you want to change your default address: ");
                                    int y1 = scanner.nextInt();
                                    if (y1 == 0) {
                                        Address = scanner.next();
                                    } else
                                        Address = usersList.findAddress(email);
                                    Payment pay = new Payment(phn, Address, price);
                                    pay.end();
                                    input1 = 6;
                                    break;
                                }
                            case 5:
                                System.out.println(catalog.getItems());
                                break;
                            default:
                                System.out.println("Wrong input");
                        }
                    }
                }
                else {
                    System.out.println("\nIncorrect data");
                }
                break;
            case 2:
                EmailSender E = new EmailSender();
                System.out.println("plz enter your valid email: ");
                email = scanner.next();
                try {
                    E.sendOTP(email);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                System.out.println("\nplz enter your password: ");

                password = scanner.next();
                System.out.println("\nplz enter your address: ");
                address = scanner.next();
                usersList.register(email, password, address);
                System.out.println("\nRegister succeed, you can now login");

                break;
            case 3:
                System.out.println(catalog.getItems());
                break;
            default:
                System.out.println("Wrong input");

        }
        usersList.saveToFile();
        catalog.saveToFile();

    }
}