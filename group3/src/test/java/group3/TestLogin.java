package group3;

import group3.bl.UserBL;
import junit.framework.TestCase;

public class TestLogin extends TestCase {
    public void login(){
        UserBL ubl = new UserBL();
        boolean result = ubl.login("vxt@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
        // boolean expected = true;
        // assertTrue(result);
        assertEquals(result, true);
    }
}
