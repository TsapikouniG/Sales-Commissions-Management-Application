package input;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

public class XMLInput extends Input {

    public XMLInput(File receiptFileXML) {
        this.inputFile = receiptFileXML;
        inputFilePath = inputFile.getAbsolutePath();
    }

    @Override
    public void readFile() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("Salesman");

            parseSalesmanInfo((Element) nodeLst.item(0));

            NodeList receiptsNodeList = doc.getElementsByTagName("Receipt");
            int size = receiptsNodeList.getLength();

            for (int i = 0; i < size; i++) {
                parseReceiptInfo((Element) receiptsNodeList.item(i));
                addReceipt();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There was a problem while reading the XML file.");
            e.printStackTrace();
        }
    }

    private void parseSalesmanInfo(Element salesmanElement) {
        name = getElementValue(salesmanElement, "Name");
        afm = getElementValue(salesmanElement, "AFM");
        addSalesman();
    }

    private void parseReceiptInfo(Element receiptElement) {
        receiptID = Integer.parseInt(getElementValue(receiptElement, "ReceiptID"));
        date = getElementValue(receiptElement, "Date");
        kind = getElementValue(receiptElement, "Kind");
        sales = Double.parseDouble(getElementValue(receiptElement, "Sales"));
        items = Integer.parseInt(getElementValue(receiptElement, "Items"));
        companyName = getElementValue(receiptElement, "Name");
        companyCountry = getElementValue(receiptElement, "Country");
        companyCity = getElementValue(receiptElement, "City");
        companyStreet = getElementValue(receiptElement, "Street");
        companyStreetNumber = Integer.parseInt(getElementValue(receiptElement, "Number"));
    }

    private String getElementValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent().trim();
        } else {
            return "";
        }
    }
}
