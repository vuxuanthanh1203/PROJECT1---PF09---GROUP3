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
}