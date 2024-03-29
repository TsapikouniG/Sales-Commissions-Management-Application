package output;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.Salesman;


public class TXTGenerateReport extends GenerateReport{

	
	public TXTGenerateReport(Salesman a, File fileToSave) {
	    super(a, fileToSave);
	}

	

    
    @Override
    protected String getFullPathName() {
        return fileToSave.getAbsolutePath();
    }


    @Override
    protected void createFile(String fullPathName) throws IOException {
        
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)))) {
        }
    }

    @Override
	public void writeDataToFile(String fullPathName) throws IOException {
        
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)))) {
            bufferedWriter.write("Name: " + salesman.getName());
            bufferedWriter.newLine();

            bufferedWriter.write("AFM: " + salesman.getAfm());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            bufferedWriter.write("Total Sales: " + salesman.calculateTotalSales());
            bufferedWriter.newLine();

            bufferedWriter.write("Trousers Sales: " + salesman.calculateTrouserSales());
            bufferedWriter.newLine();

            bufferedWriter.write("Skirts Sales: " + salesman.calculateSkirtsSales());
            bufferedWriter.newLine();

            bufferedWriter.write("Shirts Sales: " + salesman.calculateShirtsSales());
            bufferedWriter.newLine();

            bufferedWriter.write("Coats Sales: " + salesman.calculateCoatsSales());
            bufferedWriter.newLine();

            bufferedWriter.write("Commission: " + salesman.calculateCommission());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error writing data to TXT file: " + ex.getMessage());
        }
    }
	
}
