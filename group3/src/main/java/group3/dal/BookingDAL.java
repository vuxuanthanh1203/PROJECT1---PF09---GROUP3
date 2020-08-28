package group3.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import group3.App;

public class BookingDAL {
    private static Connection connection = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    private static Connection getConnection() throws SQLException {
        Connection conn = DbUtil.getInstance().getConnection();
        return conn;
    }

    public static void booking() {
        String flight = null;
        String flight_no = null;
        String type = null;
        String ticket_Type = null;
        int eachTicket = 0;
        int quantity;
        int totalPrice;
        int fId = 0;
        int tID = 0;
        try {
            do {
                App.header();
                System.out.println("\n=====================================================================");
                System.out.println("|                          BOOKING TICKET                           |");
                System.out.println("+-------------------------------------------------------------------+\n");
                System.out.print("\n- Enter Flight Number: ");
                flight = getScanner().nextLine();
                String sql1 = "SELECT * FROM flights WHERE flight_no = '" + flight + "'";
                connection = getConnection();
                pstmt = connection.prepareStatement(sql1);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    flight_no = rs.getString("flight_no");
                    fId = rs.getInt("flight_id");
                    // System.out.println("flight ID = " + fId);
                }
                if (!flight.equalsIgnoreCase(flight_no)) {
                    System.out.println("-- Flight Doesn't exist ! --");
                } else {
                    do {
                        System.out.println("\n(Ticket Type: A = 300k, B = 600K, C = 900K)");
                        System.out.print("- Enter Ticket Type: ");
                        type = getScanner().nextLine();
                        String sql2 = "SELECT * FROM ticketType WHERE type_name = '" + type + "'";
                        connection = getConnection();
                        pstmt = connection.prepareStatement(sql2);
                        rs = pstmt.executeQuery();
                        if (rs.next()) {
                            ticket_Type = rs.getString("type_name");
                            eachTicket = rs.getInt("ticket_price");
                            tID = rs.getInt("type_id");
                        }
                        if (!type.equalsIgnoreCase(ticket_Type)) {
                            System.out.println("-- Invalid Ticket Type !!!--");
                        } else {
                            System.out.print("\n- Enter The Quantity: ");
                            quantity = getScanner().nextInt();
                            totalPrice = quantity * eachTicket;
                            System.out.println("\n- Total Money = " + totalPrice + " VND");
                            String choice;
                            while (true) {
                                System.out.println("\n- Do you want to payment ? (Y/N)");
                                choice = getScanner().nextLine().toLowerCase();
                                System.out.println("\n");
                                DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                Date dateobj = new Date();
                                switch (choice) {
                                    case "y":
                                        String sql3 = "INSERT INTO booking(flight_id, type_id, user_id, booking_date, quantity, total_price) VALUES (?, ?, ?, ?, ?, ?)";
                                        connection = getConnection();
                                        pstmt = connection.prepareStatement(sql3);
                                        pstmt.setInt(1, fId);
                                        pstmt.setInt(2, tID);
                                        pstmt.setInt(3, UserDAL.user_id);
                                        pstmt.setString(4, df.format(dateobj));
                                        pstmt.setInt(5, quantity);
                                        pstmt.setInt(6, totalPrice);
                                        int k = pstmt.executeUpdate();
                                        if (k == 1) {
                                            System.out.println("\n-- Booking Successful ! --\n");
                                            App.cusScreen();
                                        } else {
                                            System.out.println("\n-- Booking Failed !!! --\n");
                                        }
                                        break;
                                    case "n":
                                        App.cusScreen();
                                        break;
                                    default:
                                        System.out.println("\n-- Function does not exist ! --\n");
                                        break;
                                }
                            }
                        }
                    } while (!type.equalsIgnoreCase(ticket_Type));
                }
            } while (!flight.equalsIgnoreCase(flight_no));
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }

    public void viewTicket() {
        try {
            App.header();
            String sql = "CALL view_ticket('" + UserDAL.user_id + "')";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println(
                    "\n======================================================================================================================");
            System.out.println(
                    "|                                                  LIST OF TICKET                                                    |");
            System.out.println(
                    "======================================================================================================================\n");
            while (rs.next()) {
                System.out.print("\n- Ticket ID: " + rs.getInt("booking_id"));
                System.out.println("\t\t\t\t\t\t\t- Flight Number: " + rs.getString("flight_no"));
                System.out.print("\n- Flight Time: " + rs.getString("flight_time"));
                System.out.println("\t\t\t\t\t\t- Full Name: " + rs.getString("user_name"));
                System.out.print("\n- Takeoff Time: " + rs.getString("takeoff_time"));
                System.out.print("  - Landing Time: " + rs.getString("landing_time"));
                System.out.println("\t\t- Address: " + rs.getString("user_address"));
                System.out.print("\n- Flight Date: " + rs.getString("flight_date"));
                System.out.println("\t\t\t\t\t- Ticket Type: " + rs.getString("type_name"));
                System.out.print("\n- Start Point: " + rs.getString("starting_point"));
                System.out.println("  - Destination: " + rs.getString("destination") + "\n");
                line();
            }
            line();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void cancelTicket() {
        int ticketID = 0;
        int ticket = 0;
        // String choice;
        try {
            App.header();
            System.out.println("\n=====================================================================");
            System.out.println("|                             CANCEL TICKET                         |");
            System.out.println("+-------------------------------------------------------------------+\n");
            System.out.print("- Enter Ticket ID: ");
            ticket = getScanner().nextInt();
            String sql = "CALL view_ticketID('" + UserDAL.user_id + "','" + ticket + "')";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println(
                    "\n======================================================================================================================");
            System.out.println(
                    "|                                                    TICKET DETAIL                                                   |");
            System.out.println(
                    "======================================================================================================================\n");
            while (rs.next()) {
                ticketID = rs.getInt("booking_id");

                System.out.print("\n- Ticket ID: " + ticketID);
                System.out.println("\t\t\t\t\t\t\t- Flight Number: " + rs.getString("flight_no"));
                System.out.print("\n- Flight Time: " + rs.getString("flight_time"));
                System.out.println("\t\t\t\t\t\t- Full Name: " + rs.getString("user_name"));
                System.out.print("\n- Takeoff Time: " + rs.getString("takeoff_time"));
                System.out.print("  - Landing Time: " + rs.getString("landing_time"));
                System.out.println("\t\t- Address: " + rs.getString("user_address"));
                System.out.print("\n- Flight Date: " + rs.getString("flight_date"));
                System.out.println("\t\t\t\t\t- Ticket Type: " + rs.getString("type_name"));
                System.out.print("\n- Start Point: " + rs.getString("starting_point"));
                System.out.println("  - Destination: " + rs.getString("destination") + "\n");
                line();

            }
            line();
            if (ticket != ticketID) {
                System.out.println("\n-- Ticket Doesn't exist ! --");
            } else {
                System.out.println("\n- Do You Really Want To Delete The Ticket ? (Y/N)");
                String choice = getScanner().nextLine().toLowerCase();
                switch (choice) {
                    case "y":
                        String sql1 = "DELETE FROM booking WHERE booking_id = '" + ticket + "'";
                        connection = getConnection();
                        pstmt = connection.prepareStatement(sql1);
                        int k = pstmt.executeUpdate();
                        if (k == 1) {
                            System.out.println("\n-- Delete Complete ! --\n");
                        } else {
                            System.out.println("\n-- Delete Failed !!! --\n");
                        }
                        break;
                    case "n":
                        App.manageTicket();
                        break;
                    default:
                        System.out.println("\n-- Function does not exist ! --\n");
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void line() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------");
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
}