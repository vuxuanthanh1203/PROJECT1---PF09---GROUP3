package group3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import group3.bl.FlightBL;
import group3.persistance.Flight;

public class TestBooking {
    
    //Test Empty
    @Test
    public void flightNoIsEmpty() {
        final String result = Flight.flightNo("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void flightNoIsNotEmpty() {
        final String result = Flight.flightNo("abcd");
        final String expected = "abcd";
        assertEquals(expected, result);
    }

    //Test Exist
    FlightBL fbl = new FlightBL();

    @Test
    public void flightIsExist() {
        boolean result = fbl.checkFlight("vn 177");
        assertTrue(result);
    }

    @Test
    public void flightIsNotExit() {
        boolean result = fbl.checkFlight("abcd");
        assertFalse(result);
    }
}
