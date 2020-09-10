package group3.persistance;

import java.util.Scanner;

public class Flight {
    private String flight_no;
    private String flight_date;
    private String flight_time;
    private String starting_point;
    private String destination;
    private String takeoff_time;
    private String landing_time;

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public String getFlight_no() {
        System.out.print("\n- Flight Number: ");
        return flight_no = getScanner().nextLine();
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public String getFlight_date() {
        System.out.print("\n- Flight date(yyyy/MM/dd): ");
        return flight_date = getScanner().nextLine();
    }

    public void setFlight_date(String flight_date) {
        this.flight_date = flight_date;
    }

    public String getFlight_time() {
        System.out.print("\n- Flight Time(hh:mm:ss): ");
        return flight_time = getScanner().nextLine();
    }

    public void setFlight_time(String flight_time) {
        this.flight_time = flight_time;
    }

    public String getStarting_point() {
        System.out.print("\n- Starting point: ");
        return starting_point = getScanner().nextLine();
    }

    public void setStarting_point(String starting_point) {
        this.starting_point = starting_point;
    }

    public String getDestination() {
        System.out.print("\n- Destination: ");
        return destination = getScanner().nextLine();
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTakeoff_time() {
        System.out.print("\n- Takeoff Time(hh:mm:ss): ");
        return takeoff_time = getScanner().nextLine();
    }

    public void setTakeoff_time(String takeoff_time) {
        this.takeoff_time = takeoff_time;
    }

    public String getLanding_time() {
        System.out.print("\n- Landing Time(hh:mm:ss): ");
        return landing_time = getScanner().nextLine();
    }

    public void setLanding_time(String landing_time) {
        this.landing_time = landing_time;
    }

    public static String start(String start) {
        String start_point = start;
        return start_point;
    }

    public static String destination(String des) {
        String destination = des;
        return destination;
    }

    public static String flightNo(String f_no) {
        String flightNo = f_no;
        return flightNo;
    }

    public static String flightDate(String f_date) {
        String flightDate = f_date;
        return flightDate;
    }

    public static String flightTime(String f_time) {
        String flightTime = f_time;
        return flightTime;
    }

    public static String takeOff(String t_time) {
        String takeOff = t_time;
        return takeOff;
    }

    public static String landing(String l_time) {
        String landing = l_time;
        return landing;
    }
    
}