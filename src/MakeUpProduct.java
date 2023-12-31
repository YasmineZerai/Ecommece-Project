public class MakeUpProduct extends Product {
    private String name;

    private String shade;

    public MakeUpProduct(String name, double price, int id, int quantity, String brand, String shade) {
        super(name,"MakeUp", price, id, quantity, brand);
        this.shade = shade;
        this.name=name;
    }

    public String getShade() {
        return shade;
    }
    public void setShade(String shade) {
        this.shade = shade;
    }
    @Override
    public String toString() {
        return
                "name: " + getName() +
                " , category: " + getCategory() +
                " , price: " + getPrice() +
                " , brand: " + getBrand() +
                " , shade: " + shade +" , id: "+getId();
    }
}

