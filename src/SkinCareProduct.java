public class SkinCareProduct extends Product{
    private String skinType;

    public SkinCareProduct(String name, double price, int id, int quantity, String brand, String skinType) {
        super(name,"SkinCare", price, id, quantity, brand);
        this.skinType = skinType;
    }

    public String getSkinType() {
        return skinType;
    }
    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }
    @Override
    public String toString() {
        return
                " name: " + getName() +
                        " , category: " + getCategory() +
                " , price: " + getPrice() +
                " , brand: " + getBrand() + " , id: "+getId()+
                        ", skinType : " + skinType ;
    }
}
