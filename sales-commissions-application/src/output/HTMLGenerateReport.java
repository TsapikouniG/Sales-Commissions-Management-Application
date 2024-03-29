package output;

import data.Salesman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class HTMLGenerateReport extends GenerateReport {

    public HTMLGenerateReport(Salesman salesman, File fileToSave) {
        super(salesman, fileToSave);
    }

    @Override
    protected String getFullPathName() {
        return fileToSave.getAbsolutePath();
    }

    @Override
    protected void createFile(String fullPathName) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)))) {
            // Add HTML structure, head, and styling
            bufferedWriter.write("<html>\n<head>\n<title>Sales Report</title>\n</head>\n<body>\n");
        }
    }

    @Override
    public void writeDataToFile(String fullPathName) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName), true))) {
            // Write data to HTML file
            bufferedWriter.write("<p>Name: " + salesman.getName() + "</p>\n");
            bufferedWriter.write("<p>AFM: " + salesman.getAfm() + "</p>\n");
            bufferedWriter.write("<br>\n<br>\n<br>\n");
            bufferedWriter.write("<p>Total Sales: " + salesman.calculateTotalSales() + "</p>\n");
            bufferedWriter.write("<p>Trousers Sales: " + salesman.calculateTrouserSales() + "</p>\n");
            bufferedWriter.write("<p>Skirts Sales: " + salesman.calculateSkirtsSales() + "</p>\n");
            bufferedWriter.write("<p>Shirts Sales: " + salesman.calculateShirtsSales() + "</p>\n");
            bufferedWriter.write("<p>Coats Sales: " + salesman.calculateCoatsSales() + "</p>\n");
            bufferedWriter.write("<p>Commission: " + salesman.calculateCommission() + "</p>\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error writing data to HTML file: " + ex.getMessage());
        }
    }

    @Override
    protected void handleException(Exception ex) {
        // Handle exceptions specific to HTML generation
        JOptionPane.showMessageDialog(null, "Error during HTML file generation: " + ex.getMessage());
    }
}
