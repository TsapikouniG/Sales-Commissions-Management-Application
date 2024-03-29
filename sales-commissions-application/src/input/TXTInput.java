package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TXTInput extends Input {

    private boolean readingReceipts = false;

    public TXTInput(File receiptFileTXT) {
        this.inputFile = receiptFileTXT;
        inputFilePath = inputFile.getAbsolutePath();
    }

    @Override
    public void readFile() {
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(inputFilePath));
            String line;
            while ((line = br.readLine()) != null) {
            	parseSalesmanInfo(line);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseSalesmanInfo(String line) {
        if (line.startsWith("Name:")) {
            name = line.substring(line.indexOf(":") + 1).trim();
        } else if (line.startsWith("AFM:")) {
            afm = line.substring(line.indexOf(":") + 1).trim();
            addSalesman();
        } else if (line.startsWith("Receipts")) {
            readingReceipts = true;
        } else if (readingReceipts) {
        	parseReceiptInfo(line);
        }
    }

    private void parseReceiptInfo(String line) {
        if (line.startsWith("Receipt ID")) {
            receiptID = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
        } else if (line.startsWith("Date")) {
            date = line.substring(line.indexOf(":") + 1).trim();
        } else if (line.startsWith("Kind")) {
            kind = line.substring(line.indexOf(":") + 1).trim();
        } else if (line.startsWith("Sales")) {
            sales = Double.parseDouble(line.substring(line.indexOf(":") + 1).trim());
        } else if (line.startsWith("Items")) {
            items = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
        } else if (line.startsWith("Company")) {
            companyName = line.substring(line.indexOf(":") + 1).trim();
        } else if (line.startsWith("Country")) {
            companyCountry = line.substring(line.indexOf(":") + 1).trim();
        } else if (line.startsWith("City")) {
            companyCity = line.substring(line.indexOf(":") + 1).trim();
        } else if (line.startsWith("Street")) {
            companyStreet = line.substring(line.indexOf(":") + 1).trim();
        } else if (line.startsWith("Number")) {
            companyStreetNumber = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
            addReceipt();
        }
    }

}
