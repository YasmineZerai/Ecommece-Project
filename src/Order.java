import java.util.ArrayList;

public class Order {
    static int i=0;
    private int id;
    private double toPay;
    Order(double money){
        i++;
        id=i;
        toPay=money;
    }
    private ArrayList<Product> products = new ArrayList<Product>();
    public void addProduct(Product p) {
        products.add(p);
    }
    public void printOrder(){
        System.out.println("Order n°: "+this.id);
        System.out.println("details: ");
        for (int j = 0; j >= products.size();j++) {
            Product product = products.get(j);
            System.out.println(product);
        }
        System.out.println("Total Price: "+toPay);
    }
}
