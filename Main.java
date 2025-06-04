//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = "";
        String password = "";
        while (true) {
            try {
                System.out.println("Enter the email");
                email = sc.nextLine();
                validateEmail(email);
                break;
            } catch (InvalidEmailException e) {
                System.out.println("Invalid email: " + e.getMessage());
            }
        }
        System.out.println("Enter the password");
        password = sc.nextLine();
        boolean isExist = DataBaseConnection.checkLoginCrediantals(email, password);
        if (isExist) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Credentials Not Found Please Register");
            System.out.println("Enter email");
            email = sc.nextLine();
            System.out.println("Enter password");
            password = sc.nextLine();
            DataBaseConnection.registerUser(email, password);
            if (DataBaseConnection.checkLoginCrediantals(email, password)) {
                System.out.println("Register successfully Please Login");
                System.out.println("Enter email");
                String email2 = sc.nextLine();
                System.out.println("Enter password");
                String password2 = sc.next();
                boolean isLogin = DataBaseConnection.checkLoginCrediantals(email2, password2);
                if (isLogin) {
                    System.out.println("Login Successfully");
                    System.out.println("Welcome to Food Order App");
                } else {
                    System.out.println("Login Failed");
                }


            } else {
                System.out.println("Something went wrong");
            }
        }

        User user = new User();
        user.menu();
        user.displayItem();
        user.selectItem();
    }
        public static void validateEmail(String email) throws InvalidEmailException {
            if (!email.endsWith("gmail.com")) {
                throw new InvalidEmailException(" Email must end with @gmail.com");
            }

    }
}
