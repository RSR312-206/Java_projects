package cp120.assignments.assignment003;

import java.math.BigInteger;
import java.util.Arrays;

public class Numbers

{
    public static boolean isPrime( int num )
    {
        for ( int i = 2; i < num / 2;  i++ )
        {
            if ( num % i == 0  ) {
                return false; 
            }
        }
        return true;
    }
    
    public static int lcm( int param1, int param2 )
    {
        int inc; 
        int max_num = 0;
        int min_num = 0; 
        int lcm = 0; 
        
        if ( param1 < param2 ) 
        {
            max_num = param2;
            min_num = param1; 
        } else {
            max_num = param1;
            min_num = param2; 
        }
        for ( int i = 1; i <= min_num; i++ )
        {
            inc = max_num * i;
            if ( inc % min_num == 0 )
            {
                lcm = inc;  
                break; 
            }
        }
        return lcm; 
    }
    
    public static int gcf( int param1, int param2 )
    {
        while ( param1 != 0 && param2 != 0 )
            {
                int factor = param2;
                param2 = param1 % param2;
                param1 = factor; 
            }
        return param1 + param2; 
    }
    
    public static int digitSum( int num ) 
    {
        int sum = 0;
        while ( num > 0 ) 
        {
             int smallestNumber = num % 10;
             sum += smallestNumber; 
             num = num / 10; 
        }
        return sum; 
    }
    
    public static double mean( double[] arr )
    {
        Double sum = 0d;
        for (Double vals : arr) {
            sum += vals;
        }
        sum =  sum / arr.length;
        return sum; 
    }
    
    public static double median( double[] arr ) 
    {
        Arrays.sort(arr);
        int middle = arr.length / 2; 
        if ( arr.length % 2 == 0 )
        {
            double firstHalf = arr[middle - 1]; 
            double secondHalf = arr[middle]; 
            return (int) ( firstHalf + secondHalf / 2 ); 
        } else {
            return arr[middle]; 
        }
    }
    
    public static BigInteger factorial( int num )
    {
        BigInteger result = BigInteger.ONE;

        for (; num > 1; num-- ) 
        {
            result = result.multiply(BigInteger.valueOf(num));
        }
        return result;
    }
    
    public static BigInteger factorial( BigInteger num )
    {
        BigInteger result = BigInteger.ONE;

        while (!num.equals(BigInteger.ZERO)) {
            result = result.multiply(num);
            num = num.subtract(BigInteger.ONE);
    }
    return result;
    }
}