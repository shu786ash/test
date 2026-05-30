package Ashish_management;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BillingService {

    public static void generateBill(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Customer ID: ");
            int customerId = sc.nextInt();

            System.out.print("Enter Room Number: ");
            int roomNo = sc.nextInt();

            System.out.println("Choose Room Type:");
            System.out.println("1. Normal Room");
            System.out.println("2. Deluxe Room");

            int choice = sc.nextInt();

            double pricePerDay = 0;

            if(choice == 1) {

                pricePerDay = 1000;

            } else if(choice == 2) {

                pricePerDay = 2000;

            } else {

                System.out.println("Invalid Choice");
                return;
            }
             

            sc.nextLine();

            System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
            String checkIn = sc.nextLine();

            System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
            String checkOut = sc.nextLine();

            LocalDate inDate = LocalDate.parse(checkIn);

            LocalDate outDate = LocalDate.parse(checkOut);

            long days = ChronoUnit.DAYS.between(inDate, outDate);

            double amount = pricePerDay * days;

            System.out.println("Total Days: " + days);

            System.out.println("Total Amount: " + amount);

            sc.nextLine();

            System.out.print("Enter Payment Status (Paid/Pending): ");
            String status = sc.nextLine();

            String sql =
                    "INSERT INTO billing(customer_id, room_no, total_amount, payment_status) VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, customerId);
            ps.setInt(2, roomNo);
            ps.setDouble(3, amount);
            ps.setString(4, status);

            ps.executeUpdate();

            System.out.println("Bill Generated Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}