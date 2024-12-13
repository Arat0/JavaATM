import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getInstance();
        Authentication auth = new Authentication(database);


        //The start of the main menu loop
        // only basic, we need to add most transaction
        //some error due to not being complete 
        System.out.println("Welcome to the Java Bank");
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Enter your account number: ");
                String accountNumber = scanner.nextLine();
                System.out.print("Enter Pin: ");
                String pin = scanner.nextLine();

                User user = auth.login(accountNumber, pin);
                if (user != null) {
                    System.out.println("Login successful! \n Welcome " + user.getName());
                    Menu menu = new Menu(user, scanner, database);
                    menu.displayMainMenu();
                } else {
                    System.out.println("Invalid account number or pin. Please try again. \n");
                }
            } else if (option == 2) {
                System.out.println("thank you for using the Java Bank! goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

}
