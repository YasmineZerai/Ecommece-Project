import java.util.Scanner;

public class HandlePurchase {
    public static void addToCart(Product p, int q, User user) {
        if (p.getQuantity() == 0) {
            System.out.println("Sorry we're out of " + p.getName());
        } else if (p.getQuantity() < q) {
            System.out.println("Sorry we only have " + p.getQuantity() + " items of " + p.getName() + " we cant provide " + q);
            System.out.println("Please try again with less quantity or look for our other categories");
        } else {
            user.getCart().add(p);
            double addedAmount = p.getPrice() * q;
           user.setTotal(user.getTotal()+addedAmount);
            p.setQuantity(p.getQuantity() - q);
            System.out.println("Product added to cart successfully.");
            System.out.println("Your total now is: " + user.getTotal());
        }
    }
    public static void removeFromCart(Product p,User user) {
        if (!(user.getCart().contains(p))) {
            System.out.println("You didnt buy this product");
        } else {
            user.getCart().remove(p);
            p.setQuantity(p.getQuantity() - 1);
            double removedAmount = p.getPrice();
            user.setTotal(user.getTotal()-removedAmount);
            System.out.println("This product is removed from the cart.");
            System.out.println("Your total now is: " + user.getTotal());
        }
    }
    public static void payment(User user) {
        System.out.println("your total is :"+user.getTotal());
        if (!(user.getPrize().equalsIgnoreCase("No luck") ||(user.getPrize().equalsIgnoreCase("")) ))
        {   System.out.println("You have won a "+user.getPrize()+" from your latest wheel spin.");
            if (user.getPrize().equalsIgnoreCase("Discount 20%"))
            {user.setTotal(user.getTotal()-(user.getTotal()*20/100));
                System.out.println("your new total is: "+user.getTotal());
            }
            else if (user.getPrize().equalsIgnoreCase("Discount 30%"))
            {user.setTotal(user.getTotal()-(user.getTotal()*30/100));
                System.out.println("your new total is: "+user.getTotal());
            }
            else if (user.getPrize().equalsIgnoreCase("Free shipping"))
            {
                System.out.println("Congratulations! The shipping is free");
            }
            user.setPrize("");

        }
        Scanner Sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("Do you have a PROMO code you wish to use ?");
            System.out.println("1- Yes");
            System.out.println("2- No");

            int answer = Sc.nextInt();
            if (answer == 1) {
                System.out.println("Enter the promo code :");
                double pourcentage = 0;
                Scanner scanner = new Scanner(System.in);
                String enteredCode = scanner.next();
                boolean test = false;
                for (int i = 0; i < DataBase.getPromoCodes().size(); i++) {
                    PromoCode promoCode = DataBase.getPromoCodes().get(i);
                    if (promoCode.getCode().equalsIgnoreCase(enteredCode)) {
                        pourcentage = promoCode.getDiscountPercentage();
                        test = true;
                    }
                    if (!test) {
                        System.out.println("this code doesnt exist");
                    } else {
                        user.setTotal(user.getTotal() - (user.getTotal() * pourcentage / 100));
                        System.out.println("your new total is: " + user.getTotal());
                    }

                }
                break;

            } else if (answer != 2) {
                System.out.println("enter a valid number please");
            }
        }
        System.out.println("Choose your payment method:");
        System.out.println("1- Tap 1 to choose Cash");
        System.out.println("2-Tap 2 to choose Credit Card");

        int answer = Sc.nextInt();
        while (true){
            if (answer == 1) {
                System.out.println("Your order will be delivered in 3 to 5 days.We will contact you soon.");
                System.out.println("do you want to continue shopping ?");
                System.out.println("1-Yes");
                System.out.println("2-No");
                int answer2 = Sc.nextInt();
                if (answer2 == 1) {
                    user.userPage();
                } else if (answer2 == 2) {
                    System.out.println("Goodbye! See you soon.");

                }
                break;

            }
            else if (answer == 2) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your credit card number:");
                String creditCardNumber = scanner.nextLine();
                System.out.println("Enter your credit card password:");
                String creditCardPassword = scanner.nextLine();
                System.out.println("Your order will be delivered in 3 to 5 days.We will contact you soon.");
                System.out.println("do you want to continue shopping ?");
                System.out.println("1-Yes");
                System.out.println("2-No");
                int answer2 = Sc.nextInt();
                if (answer2 == 1) {
                    user.userPage();
                } else if (answer2 == 2) {
                    System.out.println("Goodbye! See you soon.");


                }
                break;
            }
            else{
                System.out.println("Please enter a valid number");
            }
        }
    }
    public static void finalizePurchase(User user) {
        if (user.getCart().isEmpty())
            System.out.println("Your cart is empty!!");
        else {

            Order order = new Order(user.getTotal());
            for (int i = user.getCart().size() - 1; i >= 0; i--) {
                Product product = user.getCart().get(i);
                order.addProduct(product);
                user.getCart().remove(i);
            }
            user.getUserTransactions().add(order);
            HandlePurchase.payment(user);
            System.out.println("order finalized successfully.");
            System.out.println("your order is: ");
            order.printOrder();

        }
    }
}
