package group3.bl;

import group3.dal.AdminDAL;
import group3.persistance.Admin;

public class AdminBL {
    private static AdminDAL adal = new AdminDAL();

    public void updateAd(Admin admin) {
        adal.updateAdmin(admin);
    }

    public static void adLog() {
        AdminDAL.Adlogin();
    }

    public void resetKey() {
        adal.resetKey();
    }
}