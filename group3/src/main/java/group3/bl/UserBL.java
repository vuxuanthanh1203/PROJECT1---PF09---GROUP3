package group3.bl;

import group3.dal.UserDAL;
import group3.persistance.User;

public class UserBL {
    private static UserDAL udal = new UserDAL();

    public static void login() {
        UserDAL.login();
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