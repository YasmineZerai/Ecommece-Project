public abstract class Product {
    //attributes
    private String name;
    private double price;
    private int quantity;
    private String category;
    private int id;
    private String brand;

    //constructor
    public Product(String name, String category, double price, int id, int quantity, String brand) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
        this.brand=brand;

    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    //getters
    public String getName() {
        return this.name;
    }
    public String getCategory() {
        return this.category;
    }
    public double getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public int getId() {
        return this.id;
    }
    public String getBrand() {
        return brand;
    }

    @Override
    public abstract String toString();
}