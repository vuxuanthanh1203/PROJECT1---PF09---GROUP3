package group3;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import group3.dal.UserDAL;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    // public void shouldAnswerWithTrue()
    // {
    //     assertTrue( true );
    // }
    public void testLogin() {
        UserDAL udal = new UserDAL();
        boolean result = UserDAL.login();
        assertFalse(result);
        
    }
}
