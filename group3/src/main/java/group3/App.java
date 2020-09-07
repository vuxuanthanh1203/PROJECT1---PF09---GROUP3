package group3;

import java.util.Scanner;

import group3.bl.BookingBL;
import group3.bl.FlightBL;
import group3.bl.UserBL;
import group3.persistance.Flight;
import group3.persistance.User;

public class App {
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu1() {
        int choice;

        while (true) {
            header();
            System.out.println("=====================================================================");
            System.out.println("|                                MENU                               |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                                                                   |");
            System.out.println("| 1. Register                                                       |");
            System.out.println("|                                                                   |");
            System.out.println("| 2. Search & View Flight                                           |");
            System.out.println("|                                                                   |");
            System.out.println("| 3. Exit                                                           |");
            System.out.println("|                                                                   |");
            System.out.println("+-------------------------------------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            User user = new User();
            UserBL ubl = new UserBL();
            FlightBL fbl = new FlightBL();
            switch (choice) {
                case 1:
                    ubl.addCustomer(user);
                    break;
                case 2:
                    fbl.listFlight();
                    fbl.searchFlight();
                    fbl.chooseFlight();
                    break;
                case 3:
                    System.out.println("(^.^) Thanks for choosing us ! (^.^) ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Function does not exist !");
                    break;
            }
        }
    }

    public static void cusScreen() {
        int choice;

        while (true) {
            header();
            System.out.println("\n\n=====================================================================");
            System.out.println("|                                MENU                               |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                                                                   |");
            System.out.println("| 1. Update Account                                                 |");
            System.out.println("|                                                                   |");
            System.out.println("| 2. Search & View Flight                                           |");
            System.out.println("|                                                                   |");
            System.out.println("| 3. Book Ticket                                                    |");
            System.out.println("|                                                                   |");
            System.out.println("| 4. Manage Ticket                                                  |");
            System.out.println("|                                                                   |");
            System.out.println("| 5. Logout                                                         |");
            System.out.println("|                                                                   |");
            System.out.println("+-------------------------------------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            User user = new User();
            UserBL ubl = new UserBL();
            FlightBL fbl = new FlightBL();
            BookingBL bbl = new BookingBL();
            switch (choice) {
                case 1:
                    ubl.updateUser(user);
                    break;
                case 2:
                    fbl.listFlight();
                    fbl.searchFlight();
                    fbl.chooseFlight();
                    break;
                case 3:
                    bbl.booking();
                    break;
                case 4:
                    manageTicket();
                    break;
                case 5:
                    ubl.resetKey();
                    menu();
                    break;
                default:
                    System.out.println("Function does not exist !");
                    break;
            }
        }
    }

    public static void manageTicket() {
        int choice;

        while (true) {
            header();
            System.out.println("\n\n=====================================================================");
            System.out.println("|                             MANAGE TICKET                         |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                                                                   |");
            System.out.println("| 1. View Ticket                                                    |");
            System.out.println("|                                                                   |");
            System.out.println("| 2. Cancel Ticket                                                  |");
            System.out.println("|                                                                   |");
            System.out.println("| 3. Back                                                           |");
            System.out.println("|                                                                   |");
            System.out.println("+-------------------------------------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            BookingBL bbl = new BookingBL();
            switch (choice) {
                case 1:
                    bbl.viewTicket();
                    break;
                case 2:
                    bbl.cancelTicket();
                    break;
                case 3: 
                    cusScreen();
                    break;
                default:
                    System.out.println("Function does not exist !");
                    break;
            }
        }
    }

    public static void menu() {
        int choice;
        String email = null;
        String pass = null;

        while (true) {
            header();
            System.out.println("=====================================================================");
            System.out.println("|                                 MENU                              |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                                                                   |");
            System.out.println("| 1. Login                                                          |");
            System.out.println("|                                                                   |");
            System.out.println("| 2. Continue As Guest                                              |");
            System.out.println("|                                                                   |");
            System.out.println("| 3. Exit                                                           |");
            System.out.println("|                                                                   |");
            System.out.println("+-------------------------------------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            switch (choice) {
                case 1:
                    UserBL.login(email, pass);
                    break;
                case 2:
                    menu1();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void AdScreen() {
        int choice;

        while (true) {
            header();
            System.out.println("\n\n=====================================================================");
            System.out.println("|                                 MENU                              |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                                                                   |");
            System.out.println("| 1. Update Account                                                 |");
            System.out.println("|                                                                   |");
            System.out.println("| 2. Manage Flight                                                  |");
            System.out.println("|                                                                   |");
            System.out.println("| 3. Logout                                                         |");
            System.out.println("|                                                                   |");
            System.out.println("+-------------------------------------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            User user = new User();
            UserBL ubl = new UserBL();
            switch (choice) {
                case 1:
                    ubl.updateUser(user);
                    break;
                case 2:
                    manageFlight();
                    break;
                case 3:
                    ubl.resetKey();
                    menu();
                    break;
                default:
                    System.out.println("Function does not exist !");
                    break;
            }
        }
    }

    public static void manageFlight() {
        int choice;

        while (true) {
            header();
            System.out.println("\n\n=====================================================================");
            System.out.println("|                             MANAGE FLIGHT                         |");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|                                                                   |");
            System.out.println("| 1. Add New Flight                                                 |");
            System.out.println("|                                                                   |");
            System.out.println("| 2. Update Flight                                                  |");
            System.out.println("|                                                                   |");
            System.out.println("| 3. Delete Flight                                                  |");
            System.out.println("|                                                                   |");
            System.out.println("| 4. List Flight                                                    |");
            System.out.println("|                                                                   |");
            System.out.println("| 5. Back                                                           |");
            System.out.println("|                                                                   |");
            System.out.println("+-------------------------------------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            FlightBL fbl = new FlightBL();
            Flight flight = new Flight();
            switch (choice) {
                case 1:
                    fbl.addFlight(flight);
                    break;
                case 2:
                    fbl.updateFlight(flight);
                    break;
                case 3:
                    fbl.delFlight();
                    break;
                case 4:
                    fbl.listFlight();
                    break;
                case 5:
                    AdScreen();
                    break;
                default:
                    System.out.println("Function does not exist !");
                    break;
            }
        }
    }

    public static void header() {
        System.out.println("\n\n+-------------------------------------------------------------------+");
        System.out.println("|                   Flight Ticket Management System                 |");
        System.out.println("|                            PF09 - Group 3                         |");
        System.out.println("+-------------------------------------------------------------------+\n");
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
