package group3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import group3.bl.FlightBL;
import group3.persistance.Flight;

public class TestSearch {
    
    //Test Empty
    @Test
    public void startPointIsEmpty() {
        final String result = Flight.start("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void startPointIsNotEmpty() {
        final String result = Flight.start("abcd");
        final String expected = "abcd";
        assertEquals(expected, result);
    }

    @Test
    public void destinationIsEmpty() {
        final String result = Flight.destination("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void destinationIsNotEmpty() {
        final String result = Flight.destination("abcd");
        final String expected = "abcd";
        assertEquals(expected, result);
    }

    //Test Exist
    FlightBL fbl = new FlightBL();

    @Test
    public void placeIsExist() {
        boolean result = fbl.checkSearch("ha noi", "da nang");
        assertTrue(result);
    }

    @Test
    public void placeIsNotExit() {
        boolean result = fbl.checkSearch("hai phong", "bac giang");
        assertFalse(result);
    }
}
