package group3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import group3.bl.FlightBL;
import group3.persistance.Flight;

public class TestUpdateFlight {

    // Test Empty
    @Test
    public void flightDateIsEmpty() {
        final String result = Flight.flightDate("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void flightDateIsNotEmpty() {
        final String result = Flight.flightDate("abcd");
        final String expected = "abcd";
        assertEquals(expected, result);
    }

    @Test
    public void takeOffTimeIsEmpty() {
        final String result = Flight.takeOff("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void takeOffTimeIsNotEmpty() {
        final String result = Flight.takeOff("abcd");
        final String expected = "abcd";
        assertEquals(expected, result);
    }

    @Test
    public void landingTimeIsEmpty() {
        final String result = Flight.landing("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void landingTimeIsNotEmpty() {
        final String result = Flight.landing("abcd");
        final String expected = "abcd";
        assertEquals(expected, result);
    }

    // Test validate
    FlightBL fbl = new FlightBL();

    @Test
    public void dateValidate() {
        boolean result = fbl.checkDateValidate("2020/09/10");
        assertTrue(result);
    }

    @Test
    public void dateInvalidate() {
        boolean result = fbl.checkTimeValidate("123456");
        assertFalse(result);
    }

    @Test
    public void TimeValidate() {
        boolean result = fbl.checkTimeValidate("01:00:00");
        assertTrue(result);
    }

    @Test
    public void TimeInvalidate() {
        boolean result = fbl.checkTimeValidate("123456");
        assertFalse(result);
    }

    // Test Exist
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
