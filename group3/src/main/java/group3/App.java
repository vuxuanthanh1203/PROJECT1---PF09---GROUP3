package group3;

import java.util.Scanner;

import group3.bl.AdminBL;
import group3.bl.BookingBL;
import group3.bl.CustomerBL;
import group3.bl.FlightBL;
import group3.persistance.Admin;
import group3.persistance.Customer;
import group3.persistance.Flight;

public class App {
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu1() {
        int choice;

        while (true) {
            System.out.println("===========================================");
            System.out.println("|                   MENU                  |");
            System.out.println("+-----------------------------------------+\n");
            System.out.println("| 1. Login                                |\n");
            System.out.println("| 2. Register                             |\n");
            System.out.println("| 3. Search & View Flight                 |\n");
            System.out.println("| 4. Exit                                 |\n");
            System.out.println("+-----------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            Customer customer = new Customer();
            CustomerBL cbl = new CustomerBL();
            FlightBL fbl = new FlightBL();
            switch (choice) {
                case 1:
                    header();
                    CustomerBL.cusLog();
                    header();
                    cusScreen();
                    break;
                case 2:
                    header();
                    cbl.addCustomer(customer);
                    break;
                case 3:
                    header();
                    fbl.listFlight();
                    fbl.searchFlight();
                    fbl.chooseFlight();
                    break;
                case 4:
                    header();
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
            System.out.println("\n\n===========================================");
            System.out.println("|                   MENU                  |");
            System.out.println("+-----------------------------------------+\n");
            System.out.println("| 1. Update Account                       |\n");
            System.out.println("| 2. Search & View Flight                 |\n");
            System.out.println("| 3. Book Ticket                          |\n");
            System.out.println("| 4. Manage Ticket                        |\n");
            System.out.println("| 5. Logout                               |\n");
            System.out.println("+-----------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            Customer customer = new Customer();
            CustomerBL cbl = new CustomerBL();
            FlightBL fbl = new FlightBL();
            BookingBL bbl = new BookingBL();
            switch (choice) {
                case 1:
                    header();
                    cbl.updateCus(customer);
                    break;
                case 2:
                    header();
                    fbl.listFlight();
                    fbl.searchFlight();
                    fbl.chooseFlight();
                    break;
                case 3:
                    header();
                    bbl.booking();
                    break;
                case 4:
                    header();
                    manageTicket();
                    break;
                case 5:
                    header();
                    cbl.resetKey();
                    menu1();
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
            System.out.println("\n\n===========================================");
            System.out.println("|              MANAGE TICKET              |");
            System.out.println("+-----------------------------------------+\n");
            System.out.println("| 1. View Ticket                          |\n");
            System.out.println("| 2. Cancel Ticket                        |\n");
            System.out.println("| 3. Back                                 |\n");
            System.out.println("+-----------------------------------------+\n");

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

        while (true) {
            header();
            System.out.println("===========================================");
            System.out.println("|                   MENU                  |");
            System.out.println("+-----------------------------------------+\n");
            System.out.println("| 1. Admin                                |\n");
            System.out.println("| 2. Customer                             |\n");
            System.out.println("| 3. Exit                                 |\n");
            System.out.println("+-----------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            AdminBL abl = new AdminBL();
            switch (choice) {
                case 1:
                    header();
                    AdminBL.adLog();
                    break;
                case 2:
                    header();
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
            System.out.println("\n\n===========================================");
            System.out.println("|                   MENU                  |");
            System.out.println("+-----------------------------------------+\n");
            System.out.println("| 1. Update Account                       |\n");
            System.out.println("| 2. Manage Flight                        |\n");
            System.out.println("| 3. Logout                               |\n");
            System.out.println("+-----------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            Admin admin = new Admin();
            AdminBL abl = new AdminBL();
            switch (choice) {
                case 1:
                    header();
                    abl.updateAd(admin);
                    break;
                case 2:
                    header();
                    manageFlight();
                    break;
                case 3:
                    header();
                    abl.resetKey();
                    menu1();
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
            System.out.println("\n\n===========================================");
            System.out.println("|               MANAGE FLIGHT             |");
            System.out.println("+-----------------------------------------+\n");
            System.out.println("| 1. Add New Flight                       |\n");
            System.out.println("| 2. Update Flight                        |\n");
            System.out.println("| 3. Delete Flight                        |\n");
            System.out.println("| 4. List Flight                          |\n");
            System.out.println("| 5. Back                                 |\n");
            System.out.println("+-----------------------------------------+\n");

            System.out.print("Choice your action: ");
            choice = getScanner().nextInt();
            AdminBL abl = new AdminBL();
            FlightBL fbl = new FlightBL();
            Flight flight = new Flight();
            switch (choice) {
                case 1:
                    header();
                    fbl.addFlight(flight);
                    break;
                case 2:
                    header();
                    fbl.updateFlight(flight);
                    break;
                case 3:
                    header();
                    fbl.delFlight();
                    break;
                case 4:
                    header();
                    fbl.listFlight();
                    break;
                case 5:
                    header();
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
