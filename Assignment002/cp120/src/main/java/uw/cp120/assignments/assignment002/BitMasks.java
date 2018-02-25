package cp120.assignments.assignment002;

public class BitMasks
{
    public static String decode(int register) 
    {
        int[] countMasks = { 0b0000000000000111,
                             0b0000000000011000,
                             0b0000000111100000,
                             0b0000011000000000,
                             0b0000100000000000,
                             0b1111000000000000
                            };
        int countField = 0; 
        int count = 0; 
        String[] text = { "origin=", "security=", "data=", "count=", "start=", "control=" };
        int[] registerOrder = { 0, 3, 5, 9, 11, 12 };
        String result = ""; 
       
        for ( int i = 0; i < 6; i++ )
        {
            countField = register & countMasks[i];
            count = countField >> registerOrder[i];
            if ( i != 5) 
            {
                result += text[i] + count + ",";  
            } else 
            {
                result += text[i] + count;
            }

        }
        return result; 
    }
    
    public static void main(String[] args)
    {
    }
}
