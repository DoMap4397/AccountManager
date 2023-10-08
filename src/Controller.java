import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    String username;
    String password;
    Repository repository = new Repository();
    List<User> users = repository.getData();
    Scanner scanner = new Scanner(System.in);

    public void home() {
        Menu.mainMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                createNewAccount();
                break;
            default:
                break;
        }
    }

    public Controller() throws FileNotFoundException {
    }

    public void login() {
        boolean flag = false;
        while (!flag) {
            System.out.println("Enter your username: ");
            username = scanner.nextLine();
//            password = scanner.nextLine();
            int count = 0;
            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getUsername())) ;
                {
                    count++;
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();
                    if (password.equals(users.get(i).getPassword())) {
                        loginSuccess();
                        flag = true;
                    } else {
                        loginFail();
                        break;
                    }
                }
            }
            if (count==0) {
                System.out.println("Re-Check Username");
            }
        }
    }

    public void loginSuccess() {
        System.out.println("Welcome: " + username);
    }

    public void loginFail() {
        System.out.println("Login Fail!!!");
        Menu.loginFail();
    }

    public void changePassword() {

    }

    public void changeUsername() {

    }

    public void changeEmail() {

    }

    public void forgetPassword() {

    }

    public void createNewAccount() {

    }
}
