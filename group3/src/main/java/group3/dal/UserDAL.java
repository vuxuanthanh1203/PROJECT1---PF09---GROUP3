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

    public boolean login(User user) {
        String userName = null;
        String user_email = null;
        String email = "";
        String user_pass = null;
        String password = "";
        int roll = 0;
        try {
            do {
                App.header();
                System.out.println("=====================================================================");
                System.out.println("|                                LOGIN                              |");
                System.out.println("+-------------------------------------------------------------------+\n");
                while (true) {
                    System.out.print("Input your email (email@domain.com): ");
                    email = user.getEmail();
                    // = getScanner().nextLine().toLowerCase();
                    System.out.print("\nInput your password: ");
                    password = getMd5(user.getPass());
                    // = getMd5(getScanner().nextLine());
                    if (email.isEmpty() || password.isEmpty()) {
                        System.out.println("\n-- Email or Password is not blank !!! --\n");
                    } else if (!isEmailValid(email)) {
                        System.out.println("\n-- Invalid email !!! --\n");
                    } else {
                        String sql = "SELECT * FROM users WHERE user_email = '" + email + "' AND user_pass = '"
                                + password + "'";
                        connection = getConnection();
                        pstmt = connection.prepareStatement(sql);
                        rs = pstmt.executeQuery();
                        while (rs.next()) {
                            user_email = rs.getString("user_email");
                            user_pass = rs.getString("user_pass");
                            userName = rs.getString("user_name");
                            user_id = rs.getInt("user_id");
                            roll = rs.getInt("roll");
                        }
                        if (email.equalsIgnoreCase(user_email) && password.equalsIgnoreCase(user_pass)) {
                            if (roll == 1) {
                                System.out.println("\n-- Welcome Back " + userName + " ! --\n");
                                isLogin = true;
                                App.AdScreen();
                            } else if (roll == 2) {
                                System.out.println("\n-- Welcome " + userName + " to VN Airline ! --\n");
                                isLogin = true;
                                App.cusScreen();
                            }
                        } else {
                            System.out.println("\n-- Account does not exist !!! --\n");
                        }
                    }
                }
            } while (!email.equalsIgnoreCase(user_email) && !password.equalsIgnoreCase(user_pass));
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
            System.out.print("\n- Name: ");
            name = user.getName().trim();
            System.out.print("\n- Tel: ");
            tel = user.getTel().trim();
            System.out.print("\n- Address: ");
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

            System.out.print("\n- Email: ");
            String email = user.getEmail().toLowerCase();
            System.out.print("\n- Password: ");
            String pass = user.getPass().toLowerCase();
            System.out.print("\n- Name: ");
            String name = user.getName().toUpperCase();
            System.out.print("\n- Tel: ");
            String tel = user.getTel().toLowerCase();
            System.out.print("\n- Address: ");
            String address = user.getAddress().toUpperCase();
            // while (true) {
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
                    pstmt.setString(2, getMd5(pass));
                    pstmt.setString(3, name);
                    pstmt.setString(4, tel);
                    pstmt.setString(5, address);
                    pstmt.setInt(6, 2);
                    int k = pstmt.executeUpdate();
                    if (k == 1) {
                        System.out.println("\n-- Insert Successful ! --\n");
                        login(user);
                    } else {
                        System.out.println("\n-- Insert Failed !!! --\n");
                    }
                }

            }
            // }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public static boolean checkEmail(String email) {
        boolean result = false;
        try {
            String sql = "SELECT user_email FROM users WHERE user_email = '" + email + "'";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (email.equalsIgnoreCase(rs.getString("user_email"))) {
                    result = true;
                } else {
                    result = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return result;
    }

    public static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkAccount(String email, String pass) {
        boolean result = false;
        try {
            String sql = "SELECT user_email, user_pass FROM users WHERE user_email = '" + email + "'AND user_pass = '"
                    + pass + "'";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (email.equalsIgnoreCase(rs.getString("user_email"))
                        && pass.equalsIgnoreCase(rs.getString("user_pass"))) {
                    result = true;
                } else {
                    result = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return result;
    }

    public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }

    public void resetKey() {
        isLogin = false;
        System.out.println("\n-- See you later ! --\n");
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
}