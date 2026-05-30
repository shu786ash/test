package Ashish_management;

import java.sql.*;
import java.util.Scanner;

public class BookingService {

    public static void bookRoom(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Customer ID: ");
            int customerId = sc.nextInt();

            System.out.print("Enter Room Number: ");
            int roomNo = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
            String checkIn = sc.nextLine();

            System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
            String checkOut = sc.nextLine();

            // CHECK ROOM AVAILABILITY

            String checkQuery =
            "SELECT * FROM bookings WHERE room_no = ?";

            PreparedStatement checkPs =
            con.prepareStatement(checkQuery);

            checkPs.setInt(1, roomNo);

            ResultSet rs = checkPs.executeQuery();

            if(rs.next()) {

                System.out.println("Room is not available");

                return;
            }

            // INSERT BOOKING

            String sql =
            "INSERT INTO bookings(customer_id, room_no, checkin_date, checkout_date) VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setInt(1, customerId);
            ps.setInt(2, roomNo);
            ps.setString(3, checkIn);
            ps.setString(4, checkOut);

            ps.executeUpdate();

            System.out.println("Room Booked Successfully");

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }
}