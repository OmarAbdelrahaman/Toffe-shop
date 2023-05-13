import java.io.Serializable;


public class Item implements Serializable{
    private String name;
    private String category;
    private String description;
    private String image;
    private String brand;
    private double price;
    private double discount;

    public Item(String name, String category, String description, String image, String brand, double price, double discount) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "  category: " + this.category + "\n description: " + this.description + "  brand: "
                + this.brand + "\n price: " + this.price + "  discount: " + this.discount+"\n\n";
    }
}