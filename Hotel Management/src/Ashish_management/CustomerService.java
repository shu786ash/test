package Ashish_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerService {
    public static void registerCustomer(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter Room Number: ");
            int roomNo = sc.nextInt();
            sc.nextLine();

            String sql =
                    "INSERT INTO customers(name, age, gender, phone, room_no) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, phone);
            ps.setInt(5, roomNo);

            ps.executeUpdate();

            System.out.println("Customer Registered Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public static void viewCustomers() {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM customers";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf(
                    "\n%-5s %-15s %-5s %-10s %-15s %-10s\n",
                    "ID",
                    "Name",
                    "Age",
                    "Gender",
                    "Phone",
                    "Room No"
            );

            while (rs.next()) {

                System.out.printf(
                        "%-5d %-15s %-5d %-10s %-15s %-10d\n",

                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("phone"),
                        rs.getInt("room_no")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}