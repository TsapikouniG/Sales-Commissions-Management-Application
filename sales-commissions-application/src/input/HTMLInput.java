package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLInput extends Input {

    private boolean readingReceipts = false;
    private boolean htmlTagsAdded = false;

    public HTMLInput(File receiptFileHTML) {
        this.inputFile = receiptFileHTML;
        inputFilePath = inputFile.getAbsolutePath();
    }

    @Override
    public void readFile() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(inputFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                parseHTMLContent(line);
            }
            addSalesman();
            addReceipt();
            closeHTMLTags(); 
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

    private void parseHTMLContent(String line) {
        if (line.contains("<p>")) {
            readHTMLContent(line);
        } else if (line.contains("</html>")) {
        }
    }

    private void readHTMLContent(String line) {
        try {
            startHTMLTags();

            if (line.contains("Name:")) {
                name = getValueAfterColon(line);
                System.out.println("Name: " + name);
            } else if (line.contains("AFM:")) {
                afm = getValueAfterColon(line);
                addSalesman();
            } else if (line.contains("Receipt ID:")) {
                receiptID = parseIntegerValue("Receipt ID", line);
                addReceipt();
            } else if (line.contains("Date:")) {
                date = getValueAfterColon(line);
            } else if (line.contains("Kind:")) {
                kind = getValueAfterColon(line);
            } else if (line.contains("Sales:")) {
                sales = parseDoubleValue("Sales", line);
            } else if (line.contains("Items:")) {
                items = parseIntegerValue("Items", line);
            } else if (line.contains("Company:")) {
                companyName = getValueAfterColon(line);
            } else if (line.contains("Country:")) {
                companyCountry = getValueAfterColon(line);
            } else if (line.contains("City:")) {
                companyCity = getValueAfterColon(line);
            } else if (line.contains("Street:")) {
                companyStreet = getValueAfterColon(line);
            } else if (line.contains("Number:")) {
                companyStreetNumber = parseIntegerValue("Number", line);
            }
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line + ". Error: " + e.getMessage());
            // Log the exception or handle it appropriately
        }
    }

    protected String getValueAfterColon(String line) {
        String value = line.substring(line.indexOf(":") + 1).trim();
        value = value.replaceAll("</p>", "").trim();
        return value;
    }
    
    
    protected int parseIntegerValue(String fieldName, String line) {
        try {
            String valueString = line.replaceAll(".*<p>" + fieldName + ":\\s*(.+?)</p>.*", "$1").trim();
            return Integer.parseInt(valueString);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer value for " + fieldName + ". Line: " + line);
            return 0; 
        }
    }

    protected double parseDoubleValue(String fieldName, String line) {
        try {
            String valueString = line.replaceAll(".*<p>" + fieldName + ":\\s*(.+?)</p>.*", "$1").trim();
            return Double.parseDouble(valueString);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing double value for " + fieldName + ". Line: " + line);
            return 0.0; 
        }
    }
    private void startHTMLTags() {
        if (!readingReceipts) {
            System.out.println("Start HTML Tags");
            readingReceipts = true;
            if (!htmlTagsAdded) {
                try (FileWriter fileWriter = new FileWriter(inputFile, true)) {
                    fileWriter.write("<html>\n");
                    fileWriter.write("<body>\n"); 
                    htmlTagsAdded = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void closeHTMLTags() {
        if (readingReceipts) {
            System.out.println("Close HTML Tags");
            readingReceipts = false;
            if (htmlTagsAdded) {
                try (FileWriter fileWriter = new FileWriter(inputFile, true)) {
                    fileWriter.write("</body>\n"); 
                    fileWriter.write("</html>\n");
                    htmlTagsAdded = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
