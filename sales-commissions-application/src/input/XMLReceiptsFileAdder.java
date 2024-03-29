package input;

import java.io.File;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import data.Receipt;

public class XMLReceiptsFileAdder extends ReceiptsFileAdder {
	
	 public XMLReceiptsFileAdder() {
	        receipt = new Receipt();
	    }

    public void setFileToAppend(File fileToAppend) {
        this.fileToAppend = fileToAppend;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public void appendSpecificData() {
    	try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(fileToAppend);

            Element receipts = (Element) doc.getElementsByTagName("Receipts").item(0);

            Element newReceipt = doc.createElement("Receipt");

            createElementAndAppend(doc, newReceipt, "ReceiptID", Integer.toString(receipt.getReceiptID()));
            createElementAndAppend(doc, newReceipt, "Date", receipt.getDate());
            createElementAndAppend(doc, newReceipt, "Kind", receipt.getKind());
            createElementAndAppend(doc, newReceipt, "Sales", Double.toString(receipt.getSales()));
            createElementAndAppend(doc, newReceipt, "Items", Integer.toString(receipt.getItems()));
            createElementAndAppend(doc, newReceipt, "Company", receipt.getCompany().getName());
            createElementAndAppend(doc, newReceipt, "Country", receipt.getCompany().getCompanyAddress().getCountry());
            createElementAndAppend(doc, newReceipt, "City", receipt.getCompany().getCompanyAddress().getCity());
            createElementAndAppend(doc, newReceipt, "Street", receipt.getCompany().getCompanyAddress().getStreet());
            createElementAndAppend(doc, newReceipt, "Number", Integer.toString(receipt.getCompany().getCompanyAddress().getStreetNumber()));

            receipts.appendChild(newReceipt); 

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMSource source = new DOMSource(doc);
            try (FileWriter fileWriter = new FileWriter(fileToAppend)) {
                StreamResult result = new StreamResult(fileWriter);
                transformer.transform(source, result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createElementAndAppend(Document doc, Node parent, String elementName, String textContent) {
        Element element = doc.createElement(elementName);
        element.appendChild(doc.createTextNode(textContent));
        parent.appendChild(element);
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
