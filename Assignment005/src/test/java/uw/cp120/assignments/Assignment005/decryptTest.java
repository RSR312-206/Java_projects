package uw.cp120.assignments.Assignment005;

import junit.framework.TestCase;


public class decryptTest
        extends TestCase
{
    public void test()
    {   
        new Crypto(); 
        
        String dog = Crypto.decrypt("0 1 2 103 115 108"); 
        assertEquals(dog, "100111103");
        
        String wallaby = Crypto.decrypt("121 1 2 90 101 113 114 104 106");
        assertEquals(wallaby, "0087971081089798121");  
    }
}
