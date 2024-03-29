package input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.Receipt;


public class TXTReceiptsFileAdder extends ReceiptsFileAdder {

    public TXTReceiptsFileAdder() {
        receipt = new Receipt();
    }



    public void setFileToAppend(File fileToAppend) {
        this.fileToAppend = fileToAppend;
    }

    
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    
    public void appendSpecificData() {
    	System.out.println("Εntered into the TXT.");
        try (FileWriter fileWriter = new FileWriter(fileToAppend, true)) {

        	fileWriter.write("\n");
            fileWriter.write("Receipt ID: " + receipt.getReceiptID() + "\n");
            fileWriter.write("Date: " + receipt.getDate() + "\n");
            fileWriter.write("Kind: " + receipt.getKind() + "\n");
            fileWriter.write("Sales: " + receipt.getSales() + "\n");
            fileWriter.write("Items: " + receipt.getItems() + "\n");
            fileWriter.write("Company: " + receipt.getCompany().getName() + "\n");
            fileWriter.write("Country: " + receipt.getCompany().getCompanyAddress().getCountry() + "\n");
            fileWriter.write("City: " + receipt.getCompany().getCompanyAddress().getCity() + "\n");
            fileWriter.write("Street: " + receipt.getCompany().getCompanyAddress().getStreet() + "\n");
            fileWriter.write("Number: " + receipt.getCompany().getCompanyAddress().getStreetNumber() + "\n");
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
