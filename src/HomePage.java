import java.util.Scanner;
public class HomePage {
    public static void homePage() {
        while (true){
            System.out.println("Welcome to our e-commerce website");
            System.out.println("choose one of these numbers to continue:");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            Scanner Sc = new Scanner(System.in);
            int answer = Sc.nextInt();
            if (answer == 1) {
                User user = null;
                while (true) {
                    System.out.println("1- Are you already a member ?  tap 1 to Sign in");
                    System.out.println("2- Are you new here ? tap 2 to Sign in");
                    Scanner scanner = new Scanner(System.in);
                    int answer2 = scanner.nextInt();

                    if (answer2 == 1) {
                        user = SignIn.signInUser();
                        break;
                    } else if (answer2 == 2) {
                        user = Register.registerUser();
                        break;
                    } else {
                        System.out.println("Please enter a valid number. Either 1 or 2");
                    }
                }
                user.userPage();
            } else if (answer == 2) {
                Admin admin = SignIn.signInAdmin();
                admin.adminPage();
            }
            else if (answer==3)
            { System.out.println("GoodBye ! See You Soon <3");
            break;}
            else{System.out.println("Please enter a valid number. either 1 or 2 or 3");}
        }
    }}