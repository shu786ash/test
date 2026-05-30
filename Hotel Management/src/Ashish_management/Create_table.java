package Ashish_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create_table {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hotel_db";
        String user = "root";
        String password = "root";

        String customerTable =
                "CREATE TABLE IF NOT EXISTS customers ("
                        + "customer_id INT AUTO_INCREMENT PRIMARY KEY," + "name VARCHAR(50),"
                        + "age INT,"
                        + "gender VARCHAR(20),"
                        + "phone VARCHAR(20),"
                        + "room_no INT"
                        + ")";
        String bookingTable =
                "CREATE TABLE IF NOT EXISTS bookings ("
                        + "booking_id INT AUTO_INCREMENT PRIMARY KEY,"
                        + "customer_id INT,"
                        + "room_no INT,"
                        + "checkin_date DATE,"
                        + "checkout_date DATE"
                        + ")";
        String billingTable =
                "CREATE TABLE IF NOT EXISTS billing ("
                        + "bill_id INT AUTO_INCREMENT PRIMARY KEY,"
                        + "customer_id INT,"
                        + "room_no INT,"
                        + "total_amount DOUBLE,"
                        + "payment_status VARCHAR(20)"
                        + ")";
        String insertCustomer =
                "INSERT INTO customers(name, age, gender, phone, room_no) VALUES "
                        + "('Ashish',22,'Male','9876543210',101),"
                        + "('Rahul',25,'Male','9876500000',102),"
                        + "('Priya',21,'Female','9999999999',103),"
                        + "('Sneha',24,'Female','8888888888',104)";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, password);
            System.out.println("Connection Created");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(customerTable);
            stmt.executeUpdate(bookingTable);
            stmt.executeUpdate(billingTable);
            System.out.println("Tables Created Successfully");
            stmt.executeUpdate(insertCustomer);
            System.out.println("Sample Records Inserted");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}