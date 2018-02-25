package uw.cp120.assignments.Assignment000;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utils
{
    public static int askInt(int min, int max) throws OpCanceledException
    {
        StringBuilder question = new StringBuilder(); 
        question.append("Enter a number between ")
                .append(min)
                .append(" and ")
                .append(max);
        
        String input = JOptionPane.showInputDialog(null, question);
        int numeric_input = 0;
        try {
            numeric_input =  Integer.parseInt(input);
        } catch ( NumberFormatException e)
        {
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(input).append(" is not a valid answer.");
        
        if (input == null) {
            throw new OpCanceledException();
        }
        
        if(numeric_input >= max || numeric_input <= min || (numeric_input == 0 ) ) 
        {
            JOptionPane.showMessageDialog(null, answer);
            askInt(min, max);
        } else {
            StringBuilder result = new StringBuilder(); 
            String newl = System.lineSeparator(); 
            result.append("your answer: ").append(numeric_input)
                                          .append(newl)
                                          .append(" is correct!");
            JOptionPane.showInputDialog(result); 
        }
        return max;
    }

    public static void main(String[] args) throws OpCanceledException
    {
        askInt(4,18);
    }
}
