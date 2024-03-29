package input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.Receipt;

public class HTMLReceiptsFileAdder extends ReceiptsFileAdder {

    public HTMLReceiptsFileAdder() {
        receipt = new Receipt();
    }

    public void setFileToAppend(File fileToAppend) {
        this.fileToAppend = fileToAppend;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public void appendSpecificData() {
        System.out.println("Entered into the HTML.");
        try (FileWriter fileWriter = new FileWriter(fileToAppend, true)) {
            fileWriter.write("<p>");
            fileWriter.write("<br>Receipt ID: " + receipt.getReceiptID());
            fileWriter.write("<br>Date: " + receipt.getDate());
            fileWriter.write("<br>Kind: " + receipt.getKind());
            fileWriter.write("<br>Sales: " + receipt.getSales());
            fileWriter.write("<br>Items: " + receipt.getItems());
            fileWriter.write("<br>Company: " + receipt.getCompany().getName());
            fileWriter.write("<br>Country: " + receipt.getCompany().getCompanyAddress().getCountry());
            fileWriter.write("<br>City: " + receipt.getCompany().getCompanyAddress().getCity());
            fileWriter.write("<br>Street: " + receipt.getCompany().getCompanyAddress().getStreet());
            fileWriter.write("<br>Number: " + receipt.getCompany().getCompanyAddress().getStreetNumber());
            fileWriter.write("</p>\n");

            // Add a line break and close the HTML structure
            fileWriter.write("</body>\n");
            fileWriter.write("</html>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setReceiptID(String receiptID) {
        this.receipt.setReceiptID(Integer.parseInt(receiptID));
    }

    public void setDate(String date) {
        this.receipt.setDate(date);
    }

    public void setKind(String kind) {
        this.receipt.setKind(kind);
    }

    public void setSales(String sales) {
        this.receipt.setSales(Double.parseDouble(sales));
    }

    public void setItems(String items) {
        this.receipt.setItems(Integer.parseInt(items));
    }

    public void setCompany(String company) {
        this.receipt.getCompany().setName(company);
    }

    public void setCountry(String country) {
        this.receipt.getCompany().getCompanyAddress().setCountry(country);
    }

    public void setCity(String city) {
        this.receipt.getCompany().getCompanyAddress().setCity(city);
    }

    public void setStreet(String street) {
        this.receipt.getCompany().getCompanyAddress().setStreet(street);
    }

    public void setNumber(String number) {
        this.receipt.getCompany().getCompanyAddress().setStreetNumber(Integer.parseInt(number));
    }
}
