package group3.bl;

import group3.dal.FlightDAL;
import group3.persistance.Flight;
public class FlightBL {
    private FlightDAL fdal = new FlightDAL();

    public void listFlight() {
        fdal.displayFlight();
    }

    public void searchFlight() {
        fdal.search();
    }
    
    public void chooseFlight() {
        fdal.chooseFlight();
    }

    public void addFlight(Flight flight) {
        fdal.insertFlight(flight);
    }

    public void updateFlight(Flight flight) {
        fdal.updateFlight(flight);
    }

    public void delFlight() {
        fdal.delFlight();
    }

    
    public boolean checkFlight(String f_no) {
        return FlightDAL.checkFlight(f_no);
    }

    public boolean checkSearch(String start, String des) {
        return FlightDAL.checkPlace(start, des);
    }

    public boolean checkDateValidate(String date) {
        return FlightDAL.isDateValid(date);
    }

    public boolean checkTimeValidate(String time) {
        return FlightDAL.isTimeValid(time);
    }
}