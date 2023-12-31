import java.util.Scanner;
public class Filter {

    public static void filter() {
        System.out.println("Choose your filter:");
        System.out.println("1- Name");
        System.out.println("2- Category");
        System.out.println("3- Price");
        System.out.println("4- Brand");

        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer == 1) {
            System.out.println("Please enter the name:");
            String name = scanner.next();
            for (int i = 0; i < DataBase.getProducts().size(); i++) {
                Product product = DataBase.getProducts().get(i);
                if (product.getName().equalsIgnoreCase(name)) {
                    System.out.println(product);
                }
            }
        } else if (answer == 2) {
            System.out.println("PLease enter the category (perfume or skincare or makeup)");
            String category = scanner.next();
            boolean test=false;
            for (int i = 0; i < DataBase.getProducts().size(); i++) {
                Product product = DataBase.getProducts().get(i);
                if (product.getCategory().equalsIgnoreCase(category)) {
                    test=true;
                    System.out.println(product);
                }
            }
            if (!test) {
                    System.out.println("no product within this category");
            }
        } else if (answer == 3) {
            System.out.println("Enter the maximum price of the product:");
            double max = scanner.nextDouble();
            System.out.println("Enter the minimum price of the product:");
            double min = scanner.nextDouble();
            boolean test=false;
            for (int i = 0; i < DataBase.getProducts().size(); i++) {
                Product product = DataBase.getProducts().get(i);
                if (product.getPrice() >= min && product.getPrice() <= max) {
                    test=true;
                    System.out.println(product);
                }
            }
            if (!test) {
                System.out.println("no product within this price range");
            }
        }
        else if (answer==4){
            System.out.println("Please enter the brand:");
            String brand = scanner.next();
            boolean test=false;
            for (int i = 0; i < DataBase.getProducts().size(); i++) {
                Product product = DataBase.getProducts().get(i);
                if (product.getBrand().equalsIgnoreCase(brand)) {
                    System.out.println(product);
                    test=true;
                }
            }
            if (!test) {
                System.out.println("no product in this brand");
            }
        }
    }}

