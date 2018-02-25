package uw.cp120.assignments.Assignment005;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays; 


/**
 * 
 * @author rachelroutson
 * primary methods: encrypt, decrypt
 * encrypt accepts a String parameter
 * and returns an encrypted String
 * 
 * helper methods for encrypt: 
 * breakDownString(String arg)
 * stringToUnicodeAndIncrement(String arg)
 * 
 * decrypt accepts an encrypted String argument
 * and returns the decrypted String. 
 * 
 * helper methods for decrypt:
 * breakDownString(String arg)
 * subtractIncramentallyFromUnicode(String str)
 * removePadding(String str)
 */
public class Crypto
{
    /**
     * @param str
     * @return encrypted String str
     */
    public static String encrypt(String str) 
    {
        /**
         * Add the necessary padding to the string
         * and assign it to the String variable padString. 
         */
        String padString = ""; 
       
        if(str.length() % 3 == 0)
        {
            padString = str + "\u0000\u0000\u0000";
        } else if( str.length() % 3 == 1) 
        {
            padString = str + "\u0000\u0000"; 
        } else {
            padString = str + "\u0000";
        }
        
        /**
         * calling breakdownString parses the string
         * with List<String> into groups of 3 and returns the List. 
         */
        List<String> separatedString = breakDownString(padString, 3);
        
        /**
         * If the Array length is greater than 1, 
         * this loop shifts the position of each item in the array
         * one position to the right, and makes the last index the first.
         * The modified array is then joined as a single string. 
         */

        String combinedString; 
        String lastItem = separatedString.get(separatedString.size() - 1); 
         
        for (int i = separatedString.size() - 1;  i > 0; i--) 
        {
            separatedString.set(i, separatedString.get(i-1)); 
        }
    
       separatedString.set(0,  lastItem); 
       combinedString = String.join("", separatedString);
       
       /**
        * calling encryptedString passes the combinedList into the method and returns
        * the encrypted string.
        */
       System.out.println(stringToUnicodeAndIncrement(combinedString) + " encrypted");
       return stringToUnicodeAndIncrement(combinedString); 
    }
   
    /**
     * 
     * @param string
     * @param groupSize
     * @return
     * this method accepts to parameters- the string and the groupSize
     * it returns an Array which parsed the string into indices in an array
     *  according to the length of the groupSize
     */
    private static List<String> breakDownString(String string, int groupSize) {
        List<String> chunk = new ArrayList<String>(); 
        for (int i = 0; i < string.length(); i += groupSize)
        {
            chunk.add(string.substring(i, Math.min(string.length(), i + groupSize)));
        }
        return chunk;
    }

    /**
     * 
     * @param combinedList
     * @return String finalString
     * This method accepts a string and traverses that string
     * and converts each letter to it's Unicode equivalent.
     * It then uses the variable incr to add incrementally to each Unicode value.
     * The Unicode char in position 1 in the string gets an increment of 1;
     * position 2 gets an increment of 2, etc. Each new number is appended to
     * the variable transformed using a StringBuilder. 
     * This pattern continues to the end of the string.
     * The StringBuilder is then casted to a regular String and returned.
     */
    private static String stringToUnicodeAndIncrement(String combinedString) 
    {
        int incr = 0;
        int transformed = 0;
        StringBuilder finalString = new StringBuilder();
        
        for (int i = 0; i < combinedString.length(); i++) {
            char c = combinedString.charAt(i); 
            transformed = ((int)c + incr);
            finalString.append(transformed); 
            incr ++; 
        }
        return finalString.toString(); 
    }
    /**
     * 
     * @param str
     * @return decrypted string
     * decrypt 
     */
    public static String decrypt( String str )
    {
        String subtractedString = subtractIncramentallyFromUnicode(str); 
        List<String> separatedString = breakDownString(subtractedString, 3); 
        
        String combinedString; 
        String firstItem = separatedString.get(0); 
        for (int i = 0; i < separatedString.size() - 1; i++) 
        {
            separatedString.set(i, separatedString.get(i+1)); 
        }
       separatedString.set(separatedString.size() - 1,  firstItem); 
       combinedString = String.join("", separatedString);
       System.out.println(removePadding(combinedString) + " decrypted");
       return removePadding(combinedString); 

    }
    /**
     * 
     * @param str
     * @return padlessString
     * this method trims up to 3 0's from
     * the end of the string. 
     * it's redunduant and needs to be refactored
     */
    private static String removePadding(String str)
    {
        StringBuilder padlessString = new StringBuilder(str);
        if (str.charAt(str.length() - 1) == '0') {
            padlessString.deleteCharAt(str.length() - 1);
            
        }
        if (str.charAt(str.length() - 1) == '0')  {
            padlessString.deleteCharAt(padlessString.length() - 1);
            
        }
        if (str.charAt(str.length() - 3) == '0') {
            padlessString.deleteCharAt(padlessString.length() - 1);
            
        }
        return padlessString.toString(); 
    }

    /**
     * 
     * @param str
     * @return finalString
     * this method incrementally subtracts starting at the
     * 0th index of the String and returns the result
     */
    private static String subtractIncramentallyFromUnicode(String str)
    {
        List<String> myList = new ArrayList<String>(Arrays.asList(str.replace(" ", ",").split(",")));
        
        int decr = 0; 
        int transformed = 0;
        StringBuilder finalString = new StringBuilder(); 
        
        for( int i = 0; i < myList.size(); i++)
        { 
            String c = myList.get(i); 
            transformed = (Integer.parseInt(c) - decr);
            finalString.append(transformed); 
            decr ++; 
        }
        return finalString.toString(); 
    }
}
