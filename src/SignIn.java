import java.util.Scanner;

public class SignIn {
    public static User signInUser() {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        String email="";
        while (true){
            System.out.println("Enter your email:");
            email = scanner.nextLine();
            boolean test=false;
            for(User checking: DataBase.getUsers())
            {if (checking.getEmail().equalsIgnoreCase(email)) {
                user=checking;
                test = true;
                break;
            }}
            if (test)
            {break;}
            else{
                System.out.println("Email not on our system. Try again.");
            }

        }
        while (true)
        {
            System.out.println("Enter your password:");
            String enteredPassword = scanner.nextLine();
            if (!enteredPassword.equals(user.getPassword())) {
                System.out.println("Incorrect password. Please try again.");
            }
            else {
                System.out.println("Sign-in successful!");
                break;
            }
            }
        return user;
    }
    public static Admin signInAdmin() {
        Scanner scanner = new Scanner(System.in);
        Admin admin = null;
        String userName="";
        while (true){
            System.out.println("Enter your UserName:");
           userName = scanner.nextLine();
            boolean test=false;
            for(Admin checking: DataBase.getAdmins())
            {if (checking.getUsername().equalsIgnoreCase(userName)) {
                admin=checking;
                test = true;
                break;
            }}
            if (test)
            {break;}
            else{
                System.out.println("Email not on our system. Try again.");
            }

        }
        while (true)
        {
            System.out.println("Enter your password:");
            String enteredPassword = scanner.nextLine();
            if (!enteredPassword.equals(admin.getPassword())) {
                System.out.println("Incorrect password. Please try again.");
            }
            else {
                System.out.println("Sign-in successful!");
                break;
            }
        }
        return admin;
    }

}