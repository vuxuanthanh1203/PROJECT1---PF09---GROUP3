package group3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import group3.bl.UserBL;
import group3.persistance.User;

public class TestRegister {

    // Test Empty
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

    @Test
    public void nameIsEmpty() {
        final String result = User.userName("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void nameIsNotEmpty() {
        final String result = User.userName("1234");
        final String expected = "1234";
        assertEquals(expected, result);
    }

    @Test
    public void telIsEmpty() {
        final String result = User.userTel("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void telIsNotEmpty() {
        final String result = User.userTel("1234");
        final String expected = "1234";
        assertEquals(expected, result);
    }

    @Test
    public void addressIsEmpty() {
        final String result = User.userAddress("");
        final String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void addressIsNotEmpty() {
        final String result = User.userAddress("1234");
        final String expected = "1234";
        assertEquals(expected, result);
    }

    // Test validate
    UserBL ubl = new UserBL();

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

    // Test Exist
    @Test
    public void emailIsExist() {
        boolean result = ubl.checkEmail("vxt@gmail.com");
        assertTrue(result);
    }

    @Test
    public void emailIsNotExit() {
        boolean result = ubl.checkEmail("admin@gmail.com");
        assertFalse(result);
    }
}
