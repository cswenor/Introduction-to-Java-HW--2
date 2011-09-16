/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.Scanner;
/**
 *
 * @author cswenor
 */
public class Homework2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create the Report object
        Report report = new Report();
        // Create the keyboard scanner
        Scanner keyboard= new Scanner (System.in);
        // String for capturing user input
        String userInput = new String();
        // Create counter int for number input
        int counter = 0;
        
        // Printout of uninitialized String (Q:3)
        // System.out.println(userInput);
        
        // Gather First Name as a String (Q:1)
        System.out.println("Please Enter your First Name:");
        report.setFirstName(keyboard.next());
        
        // Skip line Fix
        keyboard.nextLine();
        
        
        // Gather Last Name One Character at a Time (Q:1)
        System.out.println("Please Enter your Last Name One Character at a Time.  (Send a blank line to end)");
        do {
            userInput = keyboard.nextLine();
            
            if (! userInput.equals(""))
                report.enterLastNameCharacter(userInput.charAt(0));
            
            System.out.println("Current Last Name: " + report.getLastName());
        } while (! userInput.equals(""));
        
        // Gather Report Name as a String (Q:2)
        System.out.println("Please Enter the Name of the Report:");
        report.setReportName(keyboard.next());
        
        // Skip line Fix
        keyboard.nextLine();
        
        // Gather the seven report numbers. (Q:4)
        System.out.println("Please enter seven number.  One on each line.  (Send a blank line to end early)");
        do {
            userInput = keyboard.nextLine();
            
            if (! userInput.equals(""))
            {
                report.enterNumber(Double.parseDouble(userInput));
                counter++;
            }

            System.out.println("Total: " + report.getTotal());
            System.out.println("Average: " + report.getAverage());
            System.out.println("High: " + report.getHighNumber());
            System.out.println("Low: " + report.getLowNumber());
        } while (! userInput.equals("") || counter <=7);
        

        
        System.out.println(report.getFirstName());
        System.out.println(report.getLastName());
        System.out.println(report.getReportName());
        
    }
    
    
    
}