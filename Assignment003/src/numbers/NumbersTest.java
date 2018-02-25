package numbers;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import cp120.assignments.assignment003.Numbers;

public class NumbersTest
{
    @Test
    public void test()
    {
        new Numbers(); 
        
        //isPrime
        boolean isPrime = Numbers.isPrime(4);
        assertEquals( isPrime, true ); 
        
        boolean isNotPrime = Numbers.isPrime(12); 
        assertEquals( isNotPrime, false); 

        //LCM
        int lcm = Numbers.lcm(122, 12);
        assertEquals( lcm, 732 ); 
        int inverseLcm = Numbers.lcm(98, 300); 
        assertEquals(inverseLcm,14700);
        
        //GCF
        int gcf = Numbers.gcf(68, 120); 
        assertEquals(gcf, 4); 
        
        //Sum number
        int digitSum = Numbers.digitSum(3984); 
        assertEquals(digitSum, 24);
        
        //mean
        double[] numbers = { 12, 45, 90, 13, 8, 74 };
        double mean = Numbers.mean(numbers); 
        assertEquals(mean, 40.333333333333, 0.02);
        
        //median
        double[] evenArr = { 3, 1, 4, 2, 5, 9 }; 
        double median = Numbers.median(evenArr); 
        assertEquals(median, 5, 0.02); 
        
        double[]oddArr = { 2, 15, 56, 9, 34, 10, 18 };
        double median2 = Numbers.median(oddArr); 
        assertEquals(median2, 15, 0.02); 
        
        //factorial
        int number = 12; 
        BigInteger factorial = Numbers.factorial(5); 
        assertEquals(factorial, BigInteger.valueOf(120));
        
        //factorial x2
        BigInteger factorial2 = Numbers.factorial(BigInteger.valueOf(10)); 
        assertEquals(factorial2, BigInteger.valueOf(3628800));
       
    }
}

