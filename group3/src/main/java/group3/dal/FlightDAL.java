package group3.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import group3.App;
import group3.persistance.Flight;

public class FlightDAL {
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private static String start = "";
    private static String end = "";

    private static Connection getConnection() throws SQLException {
        Connection conn = DbUtil.getInstance().getConnection();
        return conn;
    }

    public void displayFlight() {
        try {
            App.header();
            String sql = "SELECT flight_id, flight_no, flight_date, flight_time, starting_point, destination, takeoff_time, landing_time FROM flights";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println(
                    "\n================================================================================================================================================");
            System.out.println(
                    "|                                                               LIST OF FLIGHT                                                                 |");
            System.out.println(
                    "================================================================================================================================================\n\n");
            System.out.println(
                    "================================================================================================================================================");
            System.out.printf("|| %14s %1s| %16s %-2s| %13s %-1s | %16s %-1s | %15s %-3s| %15s %-3s| %15s %-3s||\n",
                    "Flight Number", " ", "Date of Flight", " ", "Flight Time", " ", "Starting point", " ",
                    "Destination", " ", "Takeoff Time", " ", "Landing Time", " ");
            System.out.println(
                    "================================================================================================================================================");
            while (rs.next()) {
                System.out.printf("\n %13s %20s %18s %21s %20s %18s %20s \n", rs.getString("flight_no"),
                        rs.getString("flight_date"), rs.getString("flight_time"), rs.getString("starting_point"),
                        rs.getString("destination"), rs.getString("takeoff_time"), rs.getString("landing_time"));
                line();
            }
            line();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void search() {
        try {
            App.header();
            System.out.println("\n=====================================================================");
            System.out.println("|                           SEARCH FLIGHT                           |");
            System.out.println("+-------------------------------------------------------------------+\n");
            System.out.print("\n- Input Starting Point: ");
            start = getScanner().nextLine();
            System.out.print("\n- Input Destination: ");
            end = getScanner().nextLine();
            if (start.equals("") && end.equals("")) {
                System.out.println("\n-- No matching results --\n");
            } else {
                String sql = "CALL search('" + start + "','" + end + "')";
                connection = getConnection();
                pstmt = connection.prepareStatement(sql);
                rs = pstmt.executeQuery();
                System.out.println(
                        "\n================================================================================================================================================");
                System.out.println(
                        "|                                                               LIST OF FLIGHT                                                                 |");
                System.out.println(
                        "================================================================================================================================================\n\n");
                System.out.println(
                        "================================================================================================================================================");
                System.out.printf("|| %14s %1s| %16s %-2s| %13s %-1s | %16s %-1s | %15s %-3s| %15s %-3s| %15s %-3s||\n",
                        "Flight Number", " ", "Date of Flight", " ", "Flight Time", " ", "Starting point", " ",
                        "Destination", " ", "Takeoff Time", " ", "Landing Time", " ");
                System.out.println(
                        "================================================================================================================================================");
                while (rs.next()) {
                    System.out.printf("\n %13s %20s %18s %20s %20s %19s %20s \n", rs.getString("flight_no"),
                            rs.getString("flight_date"), rs.getString("flight_time"), rs.getString("starting_point"),
                            rs.getString("destination"), rs.getString("takeoff_time"), rs.getString("landing_time"));
                    line();
                }
                line();
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void chooseFlight() {
        if (start.equals("") && end.equals("")) {
            if (!UserDAL.isLogin) {
                App.menu1();
            } else {
                App.cusScreen();
            }
        } else {
            String choice;
            String continueOrNot;
            while (true) {
                System.out.println("\nDo you want to book ticket ? (Y/N)");
                choice = getScanner().nextLine().toLowerCase();
                System.out.println("\n");
                switch (choice) {
                    case "y":
                        if (!UserDAL.isLogin) {
                            System.out.println("isLogin: " + UserDAL.isLogin);
                            System.out.println("-- YOU NEED TO LOGIN TO USE THIS FUNCTION !!! --\n");
                            while (true) {
                                System.out.println("\n Do you want to login to continue ? (Y/N)");
                                continueOrNot = getScanner().nextLine().toLowerCase();
                                switch (continueOrNot) {
                                    case "y":
                                        UserDAL.login();
                                        BookingDAL.booking();
                                        break;
                                    case "n":
                                        App.menu1();
                                    default:
                                        System.out.println("Function does not exist !");
                                        break;
                                }
                            }

                        } else {
                            BookingDAL.booking();
                        }
                        break;
                    case "n":
                        if (!UserDAL.isLogin) {
                            App.menu1();
                        } else {
                            App.cusScreen();
                        }
                    default:
                        System.out.println("\n-- Function does not exist ! --\n");
                        break;
                }
            }
        }
    }

    public void insertFlight(Flight flight) {
        try {
            App.header();
            String f_no = null;
            System.out.println("=====================================================================");
            System.out.println("|                            ADD NEW FLIGHT                         |");
            System.out.println("+-------------------------------------------------------------------+\n");
            
            String flight_no = flight.getFlight_no().toUpperCase();
            String flight_date = flight.getFlight_date();
            String flight_time = flight.getFlight_time();
            String starting_point = flight.getStarting_point().toUpperCase();
            String destination = flight.getDestination().toUpperCase();
            String takeoff_time = flight.getTakeoff_time();
            String landing_time = flight.getLanding_time();

            String sql1 = "SELECT * FROM flights WHERE flight_no = '" + flight_no + "'";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                f_no = rs.getString("user_email");
            }
            if (flight_no.equalsIgnoreCase(f_no)) {
                System.out.println("\n-- Flight Already Exists !!! --\n");
            } else {
                String sql = "INSERT INTO flights(flight_no, flight_date, flight_time, starting_point, destination, takeoff_time, landing_time, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                connection = getConnection();
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, flight_no);
                pstmt.setString(2, flight_date);
                pstmt.setString(3, flight_time);
                pstmt.setString(4, starting_point);
                pstmt.setString(5, destination);
                pstmt.setString(6, takeoff_time);
                pstmt.setString(7, landing_time);
                pstmt.setInt(8, UserDAL.user_id);
                int k = pstmt.executeUpdate();
                if (k == 1) {
                    System.out.println("\n-- Insert Successful ! --\n");
                } else {
                    System.out.println("\n-- Insert Failed !!! --\n");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void updateFlight(Flight flight) {
        try {
            App.header();
            System.out.print("\n- Input Flight Number: ");
            String flight_no = getScanner().nextLine();
            String sql1 = "CALL search_flight('" + flight_no + "')";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            System.out.println(
                    "\n================================================================================================================================================");
            System.out.println(
                    "|                                                               FLIGHT DETAIL                                                                  |");
            System.out.println(
                    "================================================================================================================================================\n\n");
            System.out.println(
                    "================================================================================================================================================");
            System.out.printf("|| %14s %1s| %16s %-2s| %13s %-1s | %16s %-1s | %15s %-3s| %15s %-3s| %15s %-3s||\n",
                    "Flight Number", " ", "Date of Flight", " ", "Flight Time", " ", "Starting point", " ",
                    "Destination", " ", "Takeoff Time", " ", "Landing Time", " ");
            System.out.println(
                    "================================================================================================================================================");
            while (rs.next()) {
                System.out.printf("\n %13s %20s %18s %21s %20s %18s %20s \n", rs.getString("flight_no"),
                        rs.getString("flight_date"), rs.getString("flight_time"), rs.getString("starting_point"),
                        rs.getString("destination"), rs.getString("takeoff_time"), rs.getString("landing_time"));
                line();
            }
            line();
            System.out.println("\n=====================================================================");
            System.out.println("|                             UPDATE FLIGHT                         |");
            System.out.println("+-------------------------------------------------------------------+\n");
            String sql2 = "UPDATE flights SET flight_date = ?, takeoff_time = ?, landing_time = ? WHERE flight_no = '" + flight_no
                    + "'";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql2);
            pstmt.setString(1, flight.getFlight_date());
            pstmt.setString(2, flight.getTakeoff_time());
            pstmt.setString(3, flight.getLanding_time());
            int k = pstmt.executeUpdate();
            if (k == 1) {
                System.out.println("\n-- Update Successful ! --\n");
            } else {
                System.out.println("\n-- Update Failed !!! --\n");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }

    public void delFlight() {
        String fid = null;
        try {
            App.header();
            System.out.println("\n=====================================================================");
            System.out.println("|                             DELETE FLIGHT                         |");
            System.out.println("+-------------------------------------------------------------------+\n");
            System.out.print("\n- Input Flight Number: ");
            String flight_no = getScanner().nextLine();
            String sql = "CALL search_flight('" + flight_no + "')";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println(
                    "\n================================================================================================================================================");
            System.out.println(
                    "|                                                               FLIGHT DETAIL                                                                  |");
            System.out.println(
                    "================================================================================================================================================\n\n");
            System.out.println(
                    "================================================================================================================================================");
            System.out.printf("|| %14s %1s| %16s %-2s| %13s %-1s | %16s %-1s | %15s %-3s| %15s %-3s| %15s %-3s||\n",
                    "Flight Number", " ", "Date of Flight", " ", "Flight Time", " ", "Starting point", " ",
                    "Destination", " ", "Takeoff Time", " ", "Landing Time", " ");
            System.out.println(
                    "================================================================================================================================================");
            while (rs.next()) {
                fid = rs.getString("flight_no");
                System.out.printf("\n %13s %20s %18s %21s %20s %18s %20s \n", fid,
                        rs.getString("flight_date"), rs.getString("flight_time"), rs.getString("starting_point"),
                        rs.getString("destination"), rs.getString("takeoff_time"), rs.getString("landing_time"));
                line();
            }
            line();
            if (!flight_no.equalsIgnoreCase(fid)) {
                System.out.println("\n-- Flight Doesn't exist ! --");
            } else {
                System.out.println("\n- Do You Really Want To Delete The Flight ? (Y/N)");
                String choice = getScanner().nextLine().toLowerCase();
                switch (choice) {
                    case "y":
                        String sql1 = "DELETE FROM flights WHERE flight_no = '" + flight_no + "'";
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
                        App.manageFlight();
                        break;
                    default:
                        System.out.println("\n-- Function does not exist ! --\n");
                        break;
                }
            }
        // }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void line() {
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

}