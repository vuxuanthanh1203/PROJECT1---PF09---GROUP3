package group3.bl;

import group3.dal.UserDAL;
import group3.persistance.User;

public class UserBL {
    private static UserDAL udal = new UserDAL();

    public  boolean login(String email, String pass) {
        return udal.login(email, pass);
    }

    public void addCustomer(User user) {
        udal.insertCustomer(user);
    }

    public void updateUser(User user) {
        udal.updateUser(user);
    }

    public void resetKey() {
        udal.resetKey();
    }
}