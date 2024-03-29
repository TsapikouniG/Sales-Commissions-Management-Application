package data;

import java.util.ArrayList;

import input.ReceiptsFileAdder;
import input.TXTReceiptsFileAdder;
import input.XMLReceiptsFileAdder;
import input.HTMLReceiptsFileAdder;
public class Salesman {
    private String name;
    private String afm;
    private ArrayList<Receipt> allReceipts;
    private ReceiptsFileAdder fileAppender;

    public Salesman() {
        allReceipts = new ArrayList<Receipt>();
    }

    public void setFileType(String fileType) {
        if ("TXT".equals(fileType)) {
            fileAppender = new TXTReceiptsFileAdder();
        } else if ("XML".equals(fileType)) {
            fileAppender = new XMLReceiptsFileAdder();
        } else if ("HTML".equals(fileType)) {
            fileAppender = new HTMLReceiptsFileAdder();
        }
    }

    public void setHTMLFileType() {
        fileAppender = new HTMLReceiptsFileAdder();
    }

    public ArrayList<Receipt> getReceipts() {
        return allReceipts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public double calculateTotalSales() {
        return calculateTotalSum("Sales");
    }

    public int calculateTotalItems() {
        return (int) calculateTotalSum("Items");
    }

    public float calculateSkirtsSales() {
        return calculateClotheKind("Skirts");
    }

    public float calculateCoatsSales() {
        return calculateClotheKind("Coats");
    }

    public float calculateTrouserSales() {
        return calculateClotheKind("Trousers");
    }

    public float calculateShirtsSales() {
        return calculateClotheKind("Shirts");
    }

    private double calculateTotalSum(String type) {
        double totalSum = 0;
        for (Receipt receipt : allReceipts) {
            if (receipt != null) {
                if ("Sales".equals(type)) {
                    totalSum += receipt.getSales();
                } else if ("Items".equals(type)) {
                    totalSum += receipt.getItems();
                }
            }
        }
        return totalSum;
    }



    private float calculateClotheKind(String kind) {
        float kindSum = 0;
        for (Receipt receipt : allReceipts) {
            if (kind.equals(receipt.getKind())) {
                kindSum += receipt.getItems();
            }
        }
        return kindSum;
    }
    
    public double calculateCommission() {
        double commission = 0;
        double totalSales = calculateTotalSales();
        if (totalSales > 6000 && totalSales <= 10000) {
            commission = 0.1 * (totalSales - 6000);
        } else if (totalSales > 10000 && totalSales <= 40000) {
            commission = (((totalSales - 10000) * 0.15) + (10000 * 0.1));
        } else if (totalSales > 40000) {
            commission = 10000 * 0.1 + 30000 * 0.15 + (totalSales - 40000) * 0.2;
        }
        return commission;
    }
    
    public Receipt createReceipt(int receiptID, String date, String kind, double sales, int items,
		            String companyName, String country, String city, String street, int streetNumber) {
		Receipt receipt = new Receipt();
		receipt.setReceiptID(receiptID);
		receipt.setDate(date);
		receipt.setKind(kind);
		receipt.setSales(sales);
		receipt.setItems(items);
		
		Company company = new Company();
		company.setName(companyName);
		
		Address companyAddress = new Address();
		companyAddress.setCountry(country);
		companyAddress.setCity(city);
		companyAddress.setStreet(street);
		companyAddress.setStreetNumber(streetNumber);
		
		company.setCompanyAddress(companyAddress);
		receipt.setCompany(company);
		
		return receipt;
		}
		
		public void appendFile(Receipt receipt) {
		ReceiptsFileAdder concreteFileAdder = getReceiptsFileAdder();
		concreteFileAdder.setReceipt(receipt);
		concreteFileAdder.appendFile();
		}
    

    public ReceiptsFileAdder getReceiptsFileAdder() {
        return fileAppender;
    }
}
