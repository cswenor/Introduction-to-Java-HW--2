/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.ArrayList;
import java.util.Vector;

;

class ReportData {
    private double highNumber = Double.MIN_VALUE;
    private double lowNumber = Double.MAX_VALUE;
    private String reportName = "";
    private String firstName = "";
    private String lastName = "";
	private ArrayList<ArrayList> reportData = new ArrayList<ArrayList>();
    private ArrayList numbers = new ArrayList();

    /**
     * @return the highNumber
     */
    public double getHighNumber() {
        return highNumber;
    }

    /**
     * @return the lowNumber
     */
    public double getLowNumber() {
        return lowNumber;
    }

    /**
     * @return the name
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * @param name the name to set
     */
    public void setReportName(String name) {
        this.reportName = name;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public boolean setFirstName(String firstName) {
        
        String newFirstName = "";
        for(int i = 0; i < firstName.length(); i++){
            if( ! this.isNumber(firstName.charAt(i)) && (firstName.charAt(i) != ' ')) {
                newFirstName += firstName.charAt(i);
            }   
        }
        this.firstName = newFirstName;
        return true;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

	/**
	 * @return the reportData
	 */
	public ArrayList<ArrayList> getReportData() {
		return reportData;
	}

    /**
     * @return the numbers
     */
    public ArrayList getNumbers() {
        return numbers;
    }
    
    /**
	 * Accept a number and save it to the report.  Then generate the report info for later use
	 * @param input_number
	 * @return 
	 */
    public boolean enterNumber(double input_number) {
		// If the input number is the highest one so far then set it to the high Number
        if (input_number > this.getHighNumber()){
            this.highNumber = input_number;
        }
		// Also if it's the lowest number set it to the lowest number
        if (input_number < this.getLowNumber()){
            this.lowNumber = input_number;
        }
        this.getNumbers().add(input_number);
		
		// Generate and save the Report Data for later display
		ArrayList<String> reportRow = new ArrayList<String>();
		reportRow.add(Double.toString(input_number));
		reportRow.add(Double.toString(this.highNumber));
		reportRow.add(Double.toString(this.lowNumber));
		reportRow.add(Float.toString(this.getTotal()));
		reportRow.add(Float.toString(this.getAverage()));
		
        this.getReportData().add(reportRow);
        return true;
    }

	/**
	 * Accept a Character and check to see if it's a number.  If it is a number ignore the input and return false.
	 * @param input_last_name_character
	 * @return 
	 */
    public boolean enterLastNameCharacter(char input_last_name_character){
        // Check to see if the Last Name Character is a Number if it is don't save it and return false
		if (this.isNumber(input_last_name_character)){
            return false;
        } else {
            this.lastName += input_last_name_character;
            return true;
        }
        
        
    }
	
	/**
	 * Return the total of all the numbers in the report
	 * @return total
	 */
    public float getTotal(){
        float total = 0;
        Object number_array[] = getNumbers().toArray();

        //Total the report numbers
        for(int i=0; i<number_array.length; i++){
            total += ((Double) number_array[i]).doubleValue();
        }
        return total;
    }
	
	/**
	 * Return the average of all the numbers in the report
	 * @return average
	 */
    public float getAverage(){
        float average = 0;
        average = this.getTotal() / getNumbers().size();
        return average;
    }
    
	/**
	 * A Validation checker to show I can use a switch case
	 * @param inputCharacter
	 * @return 
	 */
    private boolean isNumber(char inputCharacter){
        boolean isNum = true;
        switch (inputCharacter) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                isNum = true;
                break;
            default:
                isNum = false;
        }
        
        return isNum;
    }
}

