public class Perfume extends Product {

    private String volume;

    public Perfume(String name, double price, int id, int quantity, String brand, String volume) {
        super(name,"Perfume", price, id, quantity, brand);
        this.volume = volume;
    }

    public String getShade() {
        return volume;
    }
    public void setShade(String volume) {
        this.volume = volume;
    }
    @Override
    public String toString() {
        return
                "name: " + getName() +
                        " , category: " + getCategory() +
                        " , price: " + getPrice() +
                        " , brand: " + getBrand() +
                        " , volume: " + volume +" , id: "+getId();
    }
}
