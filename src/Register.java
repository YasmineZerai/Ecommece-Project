import java.util.Scanner;
public class Register {
    public static User registerUser() {
        Scanner scanner = new Scanner(System.in);
        String email="";
        while (true){
            System.out.println("Enter your email:");
            email = scanner.nextLine();
            boolean test=false;
            for(User user : DataBase.getUsers())
            {
                if (user.getEmail().equalsIgnoreCase(email)) {
                    test = true;
                    break;
                }
            }
            if (test)
            {   System.out.println("email already existing in our system");
                System.out.println("please try another email");
            }
            else break;
        }
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your address:");
        String address = scanner.nextLine();
        String password="";
        while (true) {
            System.out.println("Enter your password:");
            Scanner scanner2 = new Scanner(System.in);
            password = scanner2.nextLine();
            System.out.println("Enter your password again to verify it :");
            Scanner scanner3 = new Scanner(System.in);
            String verifPassword = scanner3.nextLine();
            if(verifPassword.equalsIgnoreCase(password))
                break;
            else{
                System.out.println("Please verify your password");
            }
        }
        User newUser = new User(email, password, username, DataBase.getProducts().size()+1, address);
        DataBase.addUser(newUser);
        System.out.println("User registration successful!");
        return newUser;
    }
}
