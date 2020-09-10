package group3.bl;

import group3.dal.UserDAL;
import group3.persistance.User;

public class UserBL {
    private static UserDAL udal = new UserDAL();

    public  boolean login(User user) {
        return udal.login(user);
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

	public boolean checkLogin(String email, String password) {
        return UserDAL.checkAccount(email, password);
    }

	public boolean checkEmail(String email) {
        return UserDAL.checkEmail(email);
    }

    public boolean checkEmailValidate(String email) {
        return UserDAL.isEmailValid(email);
    }

}