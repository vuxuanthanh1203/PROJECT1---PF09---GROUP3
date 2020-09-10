package group3.persistance;

import java.util.Scanner;

public class User {
    private String email;
    private String pass;
    private String name;
    private String tel;
    private String address;

    
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public String getEmail() {
        return email = getScanner().nextLine();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass = getScanner().nextLine();
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name = getScanner().nextLine();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel = getScanner().nextLine();
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address = getScanner().nextLine();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String emailLogin(String email) {
        String user_email = email;
        return user_email;
    }

    public static String passLogin(String pass) {
        String user_pass = pass;
        return user_pass;
    }

    public static String userName(String name) {
        String userName = name;
        return userName;
    }

    public static String userTel(String tel) {
        String userTel = tel;
        return userTel;
    }

    public static String userAddress(String address) {
        String userAddress = address;
        return userAddress;
    }
}