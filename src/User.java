import java.util.ArrayList;
import java.util.Scanner;

public class User {
    //attributes
    private String email;
    private String password;
    private String userName;
    private String address;
    private ArrayList<Product> cart = new ArrayList<Product>();
    private ArrayList<Order> userTransactions = new ArrayList<Order>();
    private double total;
    private int id;
    private int numberOfSpins;
    private String prize;
    //constructor
    public User(String email, String password, String username, int id, String address) {
        this.email = email;
        this.password = password;
        this.userName = username;
        this.id = id;
        this.total = 0;
        this.address = address;
        this.numberOfSpins=1;
        this.prize="";
    }

    //setters
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserName(String username) {
        this.userName = username;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPrize(String prize) {
        this.prize = prize;
    }
    public void setNumberOfSpins(int numberOfSpins){this.numberOfSpins=numberOfSpins;}


    //getters
    public String getEmail() {
        return email;
    }
    public String getPrize() {
        return prize;
    }
    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return userName;
    }
    public double getTotal() {
        return total;
    }
    public String getAddress() {
        return address;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Product> getCart(){return cart;}
    public ArrayList<Order> getUserTransactions(){return userTransactions;}

    //other methods
    public void userPage() {
        System.out.println("Welcome " + userName + "!");
        while (true) {
            System.out.println("1. Search product");
            System.out.println("2. Choose product");
            System.out.println("3. Remove product");
            System.out.println("4. Finalize Purchase");
            System.out.println("5. Check cart");
            System.out.println("6. Spin Wheel");
            System.out.println("7. Log Out");
            Scanner scanner1 = new Scanner(System.in);
            int answer1 = scanner1.nextInt();
            if (answer1 == 1) {
                Filter.filter();
            } else if (answer1 == 2) {
                while (true) {
                    System.out.println("Enter the ID of the product you want to choose:");
                    Scanner scanner = new Scanner(System.in);
                    int id = scanner.nextInt();
                    System.out.println("Enter the quantity you want to buy:");
                    Scanner scanner2 = new Scanner(System.in);
                    int quantity = scanner2.nextInt();
                    for (Product product : DataBase.getProducts()) {
                        if (product.getId() == id) {
                            HandlePurchase.addToCart(product, quantity, this);
                        }
                    }
                    System.out.println("Do you want to add something else to the cart ?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    Scanner scanner3 = new Scanner(System.in);
                    int answer = scanner3.nextInt();
                    if (answer==2){
                        break;
                    }
                }

            } else if (answer1 == 3) {
                System.out.println("Enter the ID of the product you want to remove:");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();
                for (Product product : cart) {
                    if (product.getId() == id) {
                        HandlePurchase.removeFromCart(product,this);
                    }
                }
            } else if (answer1 == 4) {
                HandlePurchase.finalizePurchase(this);

            }
            else if(answer1==5){
                for (int i=0; i<cart.size(); i++)
                {Product product = cart.get(i);
                    System.out.println(product);
                }
                System.out.println("your total is: "+total);

            }
            else if (answer1==6){
                if (this.numberOfSpins==0){
                    System.out.println("Sorry you have no more spins. Try again in 72h.");
                }
                else{
                    String newPrize="";
                    while (true){
                        System.out.println("Type any letter to spin");
                        Scanner sc=new Scanner(System.in);
                        String s=sc.nextLine();
                        newPrize=SpinWheel.spin();
                        this.prize=newPrize;
                        if (newPrize.equalsIgnoreCase("Try Again"))
                        { System.out.println("One other Spin");}
                        else{
                            System.out.println(newPrize);
                            break;
                        }

                    }
                    this.numberOfSpins--;

                }
            }
            else if (answer1==7) {
                System.out.println("Goodbye!");
                break;
            }
            else{
                System.out.println("Please enter a valid number");
            }
        }

    }
}

