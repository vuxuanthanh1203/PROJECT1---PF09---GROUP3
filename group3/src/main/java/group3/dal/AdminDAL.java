package group3.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import group3.App;
import group3.persistance.Admin;

public class AdminDAL {
    private static Connection connection = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public static int ad_id;
    public static boolean isLogin = false;

    private static Connection getConnection() throws SQLException {
        Connection conn = DbUtil.getInstance().getConnection();
        return conn;
    }

    public static boolean Adlogin() {
        String admin = null;
        String admin_email = null;
        String email = null;
        String admin_pass = null;
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
                String sql = "SELECT * FROM admins WHERE ad_email = '" + email + "' AND ad_pass = '" + pass + "'";
                connection = getConnection();
                pstmt = connection.prepareStatement(sql);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    admin_email = rs.getString("ad_email");
                    admin_pass = rs.getString("ad_pass");
                    admin = rs.getString("ad_name");
                    ad_id = rs.getInt("ad_id");
                }
                if (email.equalsIgnoreCase(admin_email) && pass.equalsIgnoreCase(admin_pass)) {
                    System.out.println("\n-- Welcome Back " + admin + " ! --\n");
                    App.AdScreen();
                    isLogin = true;
                } else {
                    System.out.println("\n-- Account does not exist !!! --\n");
                }
            } while (!email.equalsIgnoreCase(admin_email) && !pass.equalsIgnoreCase(admin_pass));
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return isLogin;
    }

    public void updateAdmin(Admin admin) {
        try {
            String sql1 = "CALL search_ad('" + ad_id + "')";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            System.out.println("===========================================");
            System.out.println("|            ACCOUNT INFORMATION           |");
            System.out.println("+-----------------------------------------+\n");
            while (rs.next()) {
                System.out.println("- Email: " + rs.getString("ad_email"));
                System.out.println("- Name: " + rs.getString("ad_name"));
                System.out.println("- Tel: " + rs.getString("ad_tel"));
                System.out.println("- Address: " + rs.getString("ad_address"));
            }
            System.out.println("\n===========================================");
            System.out.println("|              UPDATE ACCOUNT             |");
            System.out.println("+-----------------------------------------+\n");
            String sql2 = "UPDATE admins SET ad_name = ?, ad_tel = ?, ad_address = ? WHERE ad_id = '" + ad_id
                    + "'";
            connection = getConnection();
            pstmt = connection.prepareStatement(sql2);
            pstmt.setString(1,admin.getName());
            pstmt.setString(2,admin.getTel());
            pstmt.setString(3,admin.getAddress());
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