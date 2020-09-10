package group3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import group3.bl.FlightBL;

public class TestDeleteFlight {
        // Test Exist
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
