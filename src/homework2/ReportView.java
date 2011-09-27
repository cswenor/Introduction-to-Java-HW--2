/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Created a separate class for using the Swing Table to create my report
 * @author cswenor
 */
public class ReportView extends JPanel {

    public ReportView(ReportData reportData) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Add Name Panel and Name
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Name:"));
        JTextField nameTextField = new JTextField(reportData.getFirstName() + " " + reportData.getLastName());
        nameTextField.setEditable(false);
        namePanel.add(nameTextField);
        add(namePanel);


        // JTable Requires a Object[][], and I am storing data in a multideminsional ArrayList so I have to convert
        int rowSize = reportData.getReportData().size();

        Object[][] reportDataObject = new Object[rowSize][5];
        int rowCount = 0;
        int colCount = 0;

        for (ArrayList<String> row : reportData.getReportData()) {
            for (String cell : row) {
                reportDataObject[rowCount][colCount] = cell;
                colCount++;
            }
            rowCount++;
            colCount = 0;
        }

        // Set Column Names
        String[] columnNames = {"Input Number",
            "Highest Number",
            "Lowest Number",
            "Total (by the row)",
            "Average Number (by the row)"};

        JTable table = new JTable(reportDataObject, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);

        //Add Report Stats Panel
        JPanel statsPanel = new JPanel();

        statsPanel.add(new JLabel("Overall Total:"));
        JTextField reportTotalTextField = new JTextField(Float.toString(reportData.getTotal()));
        reportTotalTextField.setEditable(false);
        statsPanel.add(reportTotalTextField);

        statsPanel.add(new JLabel("Overall Average:"));
        JTextField reportAverageTextField = new JTextField(Float.toString(reportData.getAverage()));
        reportAverageTextField.setEditable(false);
        statsPanel.add(reportAverageTextField);
        add(statsPanel);
    }

    public static void createAndShowReport(ReportData reportData) {
        //Create and set up the window.
        JFrame frame = new JFrame(reportData.getReportName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //Create and set up the content pane.
        ReportView newContentPane = new ReportView(reportData);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.add(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
