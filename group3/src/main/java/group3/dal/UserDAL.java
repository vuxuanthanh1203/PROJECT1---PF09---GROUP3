package group3.dal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import group3.App;
import group3.persistance.User;

public class UserDAL {
    private static Connection connection = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public static int user_id;
    public static boolean isLogin = false;

    private static Connection getConnection() throws SQLException {
        Connection conn = DbUtil.getInstance().getConnection();
        return conn;
    }

    public static boolean login() {
        String user = null;
        String user_email = null;
        String email = null;
        String user_pass = null;
        String pass = null;
        int roll = 0;
        try {
            do {
                App.header();
                System.out.println("=====================================================================");
                System.out.println("|                                LOGIN                              |");
                System.out.println("+-------------------------------------------------------------------+\n");
                while (true) {
                    System.out.print("Input your email (email@domain.com): ");
                    email = getScanner().nextLine();
                    System.out.print("\nInput your password: ");
                    pass = getScanner().nextLine();
                    if (!isEmailValid(email)) {
                        System.out.println("\n-- Invalid email !!! --\n");
                    } else {
                        String sql = "SELECT * FROM users WHERE user_email = '" + email + "' AND user_pass = '" + pass
                                + "'";
                        // String sql = "SELECT * FROM users WHERE user_email = '" + email + "' AND
                        // user_pass = '" + getMd5(pass) + "'";
                        connection = getConnection();
                        pstmt = connection.prepareStatement(sql);
                        rs = pstmt.executeQuery();
                        while (rs.next()) {
                            user_email = rs.getString("user_email");
                            user_pass = rs.getString("user_pass");
                            user = rs.getString("user_name");
                            user_id = rs.getInt("user_id");
                            roll = rs.getInt("roll");
                        }
                        if (email.equalsIgnoreCase(user_email) && pass.equalsIgnoreCase(user_pass)) {
                            if (roll == 1) {
                                System.out.println("\n-- Welcome Back " + user + " ! --\n");
                                isLogin = true;
                                App.AdScreen();
                            } else if (roll == 2) {
                                System.out.println("\n-- Welcome " + user + " to VN Airline ! --\n");
                                isLogin = true;
                                App.cusScreen();
                            }
                        } else {
                            System.out.println("\n-- Account does not exist !!! --\n");
                        }
                    }
                }
            } while (!email.equalsIgnoreCase(user_email) && !pass.equalsIgnoreCase(user_pass));
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return isLogin;
    }

    public void updateUser(User user) {
        String name = null;
        String tel = null;
        String address = null;
        try {
            App.header();
            String sql1 = "CALL search_user('" + user_id + "')";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            System.out.println("=====================================================================");
            System.out.println("|                          ACCOUNT INFORMATION                      |");
            System.out.println("+-------------------------------------------------------------------+\n");
            while (rs.next()) {
                System.out.println("- Email: " + rs.getString("user_email"));
                System.out.println("- Name: " + rs.getString("user_name"));
                System.out.println("- Tel: " + rs.getString("user_tel"));
                System.out.println("- Address: " + rs.getString("user_address"));
            }
            System.out.println("\n=====================================================================");
            System.out.println("|                            UPDATE ACCOUNT                         |");
            System.out.println("+-------------------------------------------------------------------+\n");
            name = user.getName().trim();
            tel = user.getTel().trim();
            address = user.getAddress().trim();

            if (name.isEmpty() || tel.isEmpty() || address.isEmpty()) {
                System.out.println("-- Enter Full Info !!! --");
            } else {
                String sql2 = "UPDATE users SET user_name = ?, user_tel = ?, user_address = ? WHERE user_id = '"
                        + user_id + "'";
                connection = getConnection();
                pstmt = connection.prepareStatement(sql2);
                pstmt.setString(1, name);
                pstmt.setString(2, tel);
                pstmt.setString(3, address);
                int k = pstmt.executeUpdate();
                if (k == 1) {
                    System.out.println("\n-- Update Successful ! --\n");
                } else {
                    System.out.println("\n-- Update Failed !!! --\n");
                }
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }

    public void insertCustomer(User user) {
        try {
            App.header();
            String user_email = null;
            System.out.println("=====================================================================");
            System.out.println("|                           CREATE NEW ACCOUNT                      |");
            System.out.println("+-------------------------------------------------------------------+\n");

            String email = user.getEmail().toLowerCase();
            String pass = user.getPass().toLowerCase();
            String name = user.getName().toLowerCase();
            String tel = user.getTel().toLowerCase();
            String address = user.getAddress().toLowerCase();
            while (true) {
                if (email.isEmpty() || pass.isEmpty() || name.isEmpty() || tel.isEmpty() || address.isEmpty()) {
                    System.out.println("\n-- Enter Full Info !!! --\n");
                } else if (!isEmailValid(email)) {
                    System.out.println("\n-- Invalid email !!! --\n");
                    System.out.println("\nEmail format: email@domain.com");
                } else {
                    String sql1 = "SELECT * FROM users WHERE user_email = '" + email + "'";
                    connection = getConnection();
                    pstmt = connection.prepareStatement(sql1);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        user_email = rs.getString("user_email");
                    }
                    if (email.equalsIgnoreCase(user_email)) {
                        System.out.println("\n-- Account Already Exists !!! --\n");
                    } else {
                        String sql = "INSERT INTO users(user_email, user_pass, user_name, user_tel, user_address, roll) VALUES (?, ?, ?, ?, ?, ?)";
                        connection = getConnection();
                        pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, email);
                        pstmt.setString(2, pass);
                        pstmt.setString(3, name);
                        pstmt.setString(4, tel);
                        pstmt.setString(5, address);
                        pstmt.setInt(6, 2);
                        int k = pstmt.executeUpdate();
                        if (k == 1) {
                            System.out.println("\n-- Insert Successful ! --\n");
                            login();
                        } else {
                            System.out.println("\n-- Insert Failed !!! --\n");
                        }
                    }

                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public static String getMd5(String input) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }

    public void resetKey() {
        isLogin = false;
        System.out.println("-- See you later ! --");
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
}