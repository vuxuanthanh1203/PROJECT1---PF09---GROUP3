package group3;

import static org.junit.Assert.*;

import org.junit.Test;

import group3.bl.UserBL;
import group3.persistance.User;

public class TestLogin {
    UserBL ubl = new UserBL();

    @Test
    public void loginCorrect() {
        boolean result = ubl.checkLogin("vxt@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
        assertTrue(result);
    }

    @Test
    public void loginNotCorrect() {
        boolean result = ubl.checkLogin("admin", "1234");
        assertFalse(result);
    }

    @Test
    public void emailValidate() {
        boolean result = ubl.checkEmailValidate("vxt@gmail.com");
        assertTrue(result);
    }

    @Test
    public void emailInvalidate() {
        boolean result = ubl.checkEmailValidate("abcd1234");
        assertFalse(result);
    }

    @Test
    public void emailIsEmpty() {
        final String result = User.emailLogin("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void emailIsNotEmpty() {
        final String result = User.emailLogin("vxt@gmail.com");
        final String expected = "vxt@gmail.com";
        assertEquals(expected, result);
    }

    @Test
    public void passIsEmpty() {
        final String result = User.passLogin("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void passIsNotEmpty() {
        final String result = User.emailLogin("1234");
        final String expected = "1234";
        assertEquals(expected, result);
    }
}
