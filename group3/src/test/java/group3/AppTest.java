package group3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import group3.bl.UserBL;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    UserBL ubl = new UserBL();
    /**
     * Rigorous Test :-)
     */
    @Test
    // public void shouldAnswerWithTrue()
    // {
    //     assertTrue( true );
    // }
    public void login(){
        boolean result = ubl.login("vxt@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055");
        // boolean expected = true;
        // assertTrue(result);
        assertEquals(result, true);

    }
}
