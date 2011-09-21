/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.ArrayList;

;

class Report {
    private double highNumber = 4.94065645841246544e-324d;
    private double lowNumber = 1.79769313486231570e+308d;
    private String reportName = "";
    private String firstName = "";
    private String lastName = "";
    private String reportOutput = "";
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
     * @return the reportOutput
     */
    public String getReportOutput() {
        return reportOutput;
    }

    /**
     * @param reportOutput the reportOutput to set
     */
    private void setReportOutput(String reportOutput) {
        this.reportOutput = reportOutput;
    }

    /**
     * @return the numbers
     */
    public ArrayList getNumbers() {
        return numbers;
    }
    
    
    public boolean enterNumber(double input_number) {
        if (input_number > this.getHighNumber()){
            this.highNumber = input_number;
        }
        if (input_number < this.getLowNumber()){
            this.lowNumber = input_number;
        }
        this.getNumbers().add(input_number);
        
        // this.setReportOutput()
        return true;
    }

    public boolean enterLastNameCharacter(char input_last_name_character){
        if (this.isNumber(input_last_name_character)){
            return false;
        } else {
            this.lastName += input_last_name_character;
            return true;
        }
        
        
    }

    public float getTotal(){
        float total = 0;
        Object number_array[] = getNumbers().toArray();

        //Total the report numbers
        for(int i=0; i<number_array.length; i++){
            total += ((Double) number_array[i]).doubleValue();
        }
        return total;
    }

    public float getAverage(){
        float average = 0;
        average = this.getTotal() / getNumbers().size();
        return average;
    }
    
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
