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
        System.out.print("\n- Email: ");
        return email = getScanner().nextLine();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        System.out.print("\n- Password: ");
        return pass = getScanner().nextLine();
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        System.out.print("\n- Name: ");
        return name = getScanner().nextLine();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        System.out.print("\n- Tel: ");
        return tel = getScanner().nextLine();
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        System.out.print("\n- Address: ");
        return address = getScanner().nextLine();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // public User(String email, String pass, String name, String tel, String address) {
    //     this.email = email;
    //     this.pass = pass;
    //     this.name = name;
    //     this.tel = tel;
    //     this.address = address;
    // }
}