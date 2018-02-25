package cp120.assignments.assignment002;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BitMasksTest
{

    @Test
    void test()
    {
       String methodCall = BitMasks.decode(0b1001000101101101);
       String result1 = "origin=5,security=1,data=11,count=0,start=0,control=9";
       assertEquals( methodCall, result1 ); 
    }

}
