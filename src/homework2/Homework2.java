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
        ReportData reportData = new ReportData();
		
        // Create the keyboard scanner
        Scanner keyboard= new Scanner (System.in);
		
        // String for capturing user input
        String userInput = new String();
		
        // Create counter int for number input
        int counter = 0;
        
        boolean hasError = false;
        
        // Printout of uninitialized String (Q:3)
        // System.out.println(userInput);
        
        // Gather First Name as a String (Q:1)
        do {
            System.out.println("Please Enter your First Name:");
            userInput = keyboard.nextLine();
            if (! reportData.setFirstName(userInput)) {
                hasError = true;
                System.out.println("You entered invalid text.  Please try again.");
            } else {
                hasError = false;
            }
        } while (userInput.isEmpty() || hasError);
        
        System.out.println("Current First Name: " + reportData.getFirstName());
        
        
        // Gather Last Name One Character at a Time (Q:1)
        System.out.println("Please Enter your Last Name One Character at a Time.  (Send a blank line to end)");
        do {
            userInput = keyboard.nextLine();
            
            if (! userInput.equals("")) {
                if (! reportData.enterLastNameCharacter(userInput.charAt(0))){
                    System.out.println("The character you entered is a number.  Please try again.");
                    hasError = true;
                } else {
                    hasError = false;
                }
            }
            System.out.println("Current Last Name: " + reportData.getLastName());
        } while (!userInput.isEmpty());
        
        // Gather Report Name as a String (Q:2)
        System.out.println("Please Enter the Name of the Report:");
        reportData.setReportName(keyboard.nextLine());
        
        
        // Gather the seven report numbers. (Q:4)
        System.out.println("Please enter seven number.  One on each line.  (Send a blank line to end early)");
        do {
            userInput = keyboard.nextLine();
            
            if (! userInput.isEmpty()) {
                if (! reportData.enterNumber(Double.parseDouble(userInput))){
                    hasError = true;
                } else {
                    hasError = false;
                    
					System.out.println("Total: " + reportData.getTotal());
					System.out.println("Average: " + reportData.getAverage());
					System.out.println("High: " + reportData.getHighNumber());
					System.out.println("Low: " + reportData.getLowNumber());
					// System.out.println("Count: " + counter);
					counter++;
                }
            }

            
        } while ( !( userInput.isEmpty() && counter >= 1 ) && (counter < 7));
        
		// Use a static function to create and display the Report
		ReportView.createAndShowReport(reportData);
		
        
    }
    
    
    
}