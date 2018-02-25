package uw.cp120.assignments.Assignment005;

import junit.framework.TestCase;


public class encryptTest
    extends TestCase
{
    public void test()
  {
      new Crypto(); 
      
      String alligator = Crypto.encrypt("Alligator"); 
      assertEquals(alligator, "01268112113111110105125121125");  
      
      String squirrel = Crypto.encrypt("Squirrel"); 
      assertEquals(squirrel, "101109286117122111121122");
      
      String wallaby = Crypto.encrypt("Wallaby"); 
      assertEquals(wallaby, "1211290101113114104106"); 
      
      String x = Crypto.encrypt("X"); 
      assertEquals(x, "8812");
      
      String dog = Crypto.encrypt("dog"); 
      assertEquals(dog, "012103115108"); 
  } 
} 
