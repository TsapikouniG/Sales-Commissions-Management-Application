package output;

import data.Salesman;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;

public abstract class GenerateReport {

    protected Salesman salesman;
    protected File fileToSave;


    public GenerateReport(Salesman salesman, File fileToSave) {
        this.salesman = salesman;
        this.fileToSave = fileToSave;
    }

    public void saveFile() {
        try {
            String fullPathName = getFullPathName();
            createFile(fullPathName);
            writeDataToFile(fullPathName);
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    protected abstract String getFullPathName();

    protected abstract void createFile(String fullPathName) throws IOException;

    protected abstract void writeDataToFile(String fullPathName) throws IOException;

    protected void handleException(Exception ex) {
        JOptionPane.showMessageDialog(null, "Error during file generation: " + ex.getMessage());
    }
    
    
}
