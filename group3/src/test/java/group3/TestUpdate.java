package group3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import group3.persistance.User;

public class TestUpdate {
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
}
