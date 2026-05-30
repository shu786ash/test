package Ashish_management;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        if (!LoginService.login(username, password)) {
            System.out.println("Login Failed...");
            return;
        }
        System.out.println("Login Successful");
        while (true) {
            System.out.println("\n<===== Welcome to HOTEL MANAGEMENT SYSTEM =====>");
            System.out.println("1. Register Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Book Room");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            sc.nextLine();
            switch (choice) {

                case 1 -> CustomerService.registerCustomer(sc);
                case 2 -> CustomerService.viewCustomers();
                case 3 -> BookingService.bookRoom(sc);
                case 4 -> BillingService.generateBill(sc);
                case 5 -> {
                    System.out.println("Thank You...");
                    return;
                }
                default ->  System.out.println("Invalid Choice");
            }
        }
    }
}