package uw.cp120.assignments.Assignment004;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
/**
 * @author rachelroutson
 *
 */
public class UtilsTest 
    extends TestCase
{
    public void testApp() throws OpCanceledException
    {
        new Utils(); 
        int askMe =  Utils.askInt(4, 67);
        int input = 2;
       
    }
}
