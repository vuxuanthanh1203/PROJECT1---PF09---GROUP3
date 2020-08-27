package group3.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import group3.persistance.Customer;

public class CustomerDAL {
    private static Connection connection = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public static int user_id;
    public static boolean isLogin = false;

    private static Connection getConnection() throws SQLException {
        Connection conn = DbUtil.getInstance().getConnection();
        return conn;
    }

    public static boolean Cuslogin() {
        String user = null;
        String customer_email = null;
        String email = null;
        String customer_pass = null;
        String pass = null;
        try {
            do {
                System.out.println("===========================================");
                System.out.println("|                  LOGIN                  |");
                System.out.println("+-----------------------------------------+\n");
                System.out.print("Input your email: ");
                email = getScanner().nextLine();
                System.out.print("\nInput your password: ");
                pass = getScanner().nextLine();
                String sql = "SELECT * FROM customers WHERE cus_email = '" + email + "' AND cus_pass = '" + pass + "'";
                connection = getConnection();
                pstmt = connection.prepareStatement(sql);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    customer_email = rs.getString("cus_email");
                    customer_pass = rs.getString("cus_pass");
                    user = rs.getString("cus_name");
                    user_id = rs.getInt("cus_id");
                }
                if (email.equalsIgnoreCase(customer_email) && pass.equalsIgnoreCase(customer_pass)) {
                    System.out.println("\n-- Welcome " + user + " to VN Airline ! --\n");
                    isLogin = true;
                } else {
                    System.out.println("\n-- Account does not exist !!! --\n");
                }
            } while (!email.equalsIgnoreCase(customer_email) && !pass.equalsIgnoreCase(customer_pass));
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return isLogin;
    }

    public void insertCustomer(Customer customer) {
        try {
            String cus_email = null;
            System.out.println("===========================================");
            System.out.println("|             CREATE NEW ACCOUNT          |");
            System.out.println("+-----------------------------------------+\n");
            
            String email = customer.getEmail().toLowerCase();
            String pass = customer.getPass().toLowerCase();
            String name = customer.getName().toLowerCase();
            String tel = customer.getTel().toLowerCase();
            String address = customer.getAddress().toLowerCase();

            String sql1 = "SELECT * FROM customers WHERE cus_email = '" + email + "'";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cus_email = rs.getString("cus_email");
            }
            if (email.equalsIgnoreCase(cus_email)) {
                System.out.println("\n-- Account Already Exists !!! --\n");
            } else {
                String sql = "INSERT INTO customers(cus_email, cus_pass, cus_name, cus_tel, cus_address) VALUES (?, ?, ?, ?, ?)";
                connection = getConnection();
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, email);
                pstmt.setString(2, pass);
                pstmt.setString(3, name);
                pstmt.setString(4, tel);
                pstmt.setString(5, address);
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

    public void updateCustomer(Customer customer) {
        try {
            String sql1 = "CALL search_cus('" + user_id + "')";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            System.out.println("===========================================");
            System.out.println("|            ACCOUNT INFORMATION           |");
            System.out.println("+-----------------------------------------+\n");
            while (rs.next()) {
                System.out.println("- Email: " + rs.getString("cus_email"));
                System.out.println("- Name: " + rs.getString("cus_name"));
                System.out.println("- Tel: " + rs.getString("cus_tel"));
                System.out.println("- Address: " + rs.getString("cus_address"));
            }
            System.out.println("\n===========================================");
            System.out.println("|              UPDATE ACCOUNT             |");
            System.out.println("+-----------------------------------------+\n");
            String sql2 = "UPDATE customers SET cus_name = ?, cus_tel = ?, cus_address = ? WHERE cus_id = '" + user_id
                    + "'";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql2);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getTel());
            pstmt.setString(3, customer.getAddress());
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

    
    public void resetKey() {
        isLogin = false;
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
}