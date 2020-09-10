package group3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import group3.bl.BookingBL;

public class TestCancelTicket {
    // Test Exist
    BookingBL bbl = new BookingBL();

    @Test
    public void ticketIsExist() {
        boolean result = bbl.checkTicket("1");
        assertTrue(result);
    }

    @Test
    public void ticketIsNotExit() {
        boolean result = bbl.checkTicket("100");
        assertFalse(result);
    }
}
