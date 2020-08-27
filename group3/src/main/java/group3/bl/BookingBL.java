package group3.bl;

import group3.dal.BookingDAL;

public class BookingBL {
    private BookingDAL bdal = new BookingDAL();

    public void booking() {
        BookingDAL.booking();
    }
    
    public void viewTicket() {
        bdal.viewTicket();
    }

    public void cancelTicket() {
        bdal.cancelTicket();
    }
}