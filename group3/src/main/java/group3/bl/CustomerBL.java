package group3.bl;

import group3.dal.CustomerDAL;
import group3.persistance.Customer;

public class CustomerBL {
    private static CustomerDAL cdal = new CustomerDAL();

    public void addCustomer(Customer customer) {
        cdal.insertCustomer(customer);
    }

    public static void cusLog() {
        CustomerDAL.Cuslogin();
    }

    public void updateCus(Customer customer) {
        cdal.updateCustomer(customer);
    }

    public void resetKey() {
        cdal.resetKey();
    }
}