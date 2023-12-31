
import java.util.Scanner;
import java.util.ArrayList;
public class Admin {
    private int id;
    private static int compteur=0;
    private String userName;
    private String password;
    public Admin(String username, String password) {
        this.id=compteur;
        compteur++;
        this.userName = username;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.userName = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void adminPage() {
        System.out.println("Welcome Admoun!");
        while (true) {
            System.out.println("1. Delete User");
            System.out.println("2. Add Product");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Add Promo Code");
            System.out.println("5. Activate/Deactivate Promo Code");
            System.out.println("6. Add Admin");
            System.out.println("7. View users");
            System.out.println("8. View admins");
            System.out.println("9. View products");
            System.out.println("10. Update product price");
            System.out.println("11. Search Product");
            System.out.println("12. Log Out");

            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            switch (answer) {
                case 1:
                    deleteUser();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    updateProductQuantity();
                    break;
                case 4:
                    addPromoCode();
                    break;
                case 5:
                    activateDeactivatePromoCode();
                    break;
                case 6:
                    addNewAdmin();
                    break;
                case 7:
                    viewUsers();
                    break;
                case 8:
                    viewAdmins();
                    break;
                case 9:
                    viewProducts();
                    break;
                case 10:
                    updateProductPrice();
                    break;
                case 11:
                    Filter.filter();
                    break;
                case 12:
                    System.out.println("GoodBye !");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void deleteUser() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the ID of the user you want to delete: ");
            int id = scanner.nextInt();
            boolean test=false;
            int deletedId=0;
            for (int i = 0; i < DataBase.getUsers().size(); i++) {
                if (DataBase.getUsers().get(i).getId() == id) {
                    deletedId = i;
                    test=true;
                    break;
                }
            }
            if (test) {
                User deletedUser = DataBase.getUsers().remove(deletedId);
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found.");
            }
        }
    private void addNewProduct() {
        Scanner scanner = new Scanner(System.in);
        Product newProduct;
        System.out.println("Enter the name of the new product:");
        String name = scanner.nextLine();
        System.out.println("Enter the brand of the new product:");
        String brand = scanner.nextLine();
        System.out.println("Enter the price of the new product:");
        double price = scanner.nextDouble();
        System.out.println("Enter the quantity of the new product:");
        int quantity = scanner.nextInt();
        System.out.println("Enter the category of the new product:");
        Scanner scanner1=new Scanner(System.in);
        String category = scanner1.nextLine();
        if (category.equalsIgnoreCase("skincare"))
        {
            System.out.println("Enter the skin type:");
            Scanner scanner2=new Scanner(System.in);
            String skinType = scanner2.nextLine();
            newProduct = new SkinCareProduct(name, price, DataBase.getProducts().size() + 1, quantity, brand, skinType);
        }
        else if (category.equalsIgnoreCase("makeup")) {
                System.out.println("Enter the shade:");
                Scanner scanner2=new Scanner(System.in);
                String shade = scanner2.nextLine();
                newProduct = new MakeUpProduct(name, price, DataBase.getProducts().size() + 1, quantity, brand, shade);
            }
        else if (category.equalsIgnoreCase("perfume")) {
                System.out.println("Enter the volume:");
                Scanner scanner2=new Scanner(System.in);
                String volume = scanner2.nextLine();
                newProduct = new Perfume(name, price, DataBase.getProducts().size() + 1, quantity, brand, volume);
            }
        else {
                System.out.println("Invalid product category.");
                return;
            }
        DataBase.addProduct(newProduct);
        System.out.println("Product added successfully!");
    }
    private void updateProductQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the product you want to update:");
        int id = scanner.nextInt();
        int index = -1;
        boolean test=false;
        for (int i = 0; i < DataBase.getProducts().size(); i++) {
            if (DataBase.getProducts().get(i).getId() == id) {
               index = i;
                test=true;
                break;
            }
        }

        if (test) {
            System.out.println("Enter the new quantity: ");
            int newQuantity = scanner.nextInt();

            DataBase.getProducts().get(index).setQuantity(newQuantity);

            System.out.println("Product quantity updated successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }
    private void addPromoCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the promo code:");
        String code = scanner.nextLine();
        boolean test = true;
        for (int i=0 ; i< DataBase.getPromoCodes().size(); i++) {
           String  existingCode=DataBase.getPromoCodes().get(i).getCode();
            if (existingCode.equals(code)) {
                test = false;
                break;
            }
        }
        if (test) {
            System.out.println("Enter the discount percentage:");
            double pourcentage = scanner.nextDouble();
            PromoCode newPromoCode = new PromoCode(code, pourcentage);
            DataBase.addPromoCode(newPromoCode);
            System.out.println("Promo code added successfully!");
        } else {
            System.out.println("Promo code already exists.");
        }
    }
    private void activateDeactivatePromoCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the promo code:");
        String code = scanner.nextLine();
        PromoCode promo =null;
        boolean test = false;
        for (int i=0 ; i< DataBase.getPromoCodes().size(); i++) {
            String  codeToUpdate=DataBase.getPromoCodes().get(i).getCode();
            if (codeToUpdate.equals(code)) {
                promo =DataBase.getPromoCodes().get(i);
                test = true;
                break;
            }
        }
        if (test) {
            System.out.println("Do you wish to activate or deactivate? ");
            System.out.println("1. Activate");
            System.out.println("2. Deactivate");
            int answer = scanner.nextInt();
            if (answer==1){
                promo.activate();
            }
            else if (answer==2)
            { promo.deactivate();}
            System.out.println("Promo code updated successfully!");
        } else {
            System.out.println("Promo code doesnt exist .");
        }
    }
    private void addNewAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new admin username:");
        String userName = scanner.nextLine();
        boolean test = true;
        for (Admin admin : DataBase.getAdmins()) {
            if (admin.getUsername().equals(userName)) {
                test = false;
                break;
            }
        }
        if (test) {
            System.out.println("Enter the new admin password:");
            String password = scanner.nextLine();
            Admin newAdmin = new Admin(userName, password);
            DataBase.addAdmin(newAdmin);
            System.out.println("New admin added successfully!");
        } else {
            System.out.println("Username already exists.");
        }
    }
    private void viewUsers() {
        ArrayList<User> users = DataBase.getUsers();
        if (users.isEmpty()) {
            System.out.println("No users yet.");
        } else {
            System.out.println("List of all users:");
            for (User user : users) {
                System.out.println("User ID: " + user.getId());
                System.out.println("Username: " + user.getUserName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Address: " + user.getAddress());
                System.out.println("Transactions history: ");
                for (Order order: user.getUserTransactions())
                    {order.printOrder();}
                System.out.println("---------------");
            }
        }
    }
    private void viewAdmins() {
        ArrayList<Admin> admins = DataBase.getAdmins();
        if (admins.isEmpty()) {
            System.out.println("No admins found.");
        } else {
            System.out.println("List of all admins:");
            for (Admin admin : admins) {
                System.out.println("Admin ID: " + admin.getId());
                System.out.println("Username: " + admin.getUsername());
                System.out.println("---------------");
            }
        }
    }
    private void viewProducts() {
        ArrayList<Product> products = DataBase.getProducts();

        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("List of all products:");
            for (Product product : products) {
                System.out.println(product);
                System.out.println("---------------");
            }
        }
    }
    private void updateProductPrice() {
        System.out.println("Enter the ID of the product you want to update:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Product product=null;
        for (int i = 0; i < DataBase.getProducts().size(); i++) {
            if (DataBase.getProducts().get(i).getId() == id) {
                product=DataBase.getProducts().get(i);

                break;
            }
        }
        if (product == null) {
            System.out.println("Product not found with ID: " + id);
        } else {
            System.out.println("Enter the new price for the product:");
            double price = scanner.nextDouble();
            product.setPrice(price);
            System.out.println("Product price updated successfully.");
        }
    }
}
