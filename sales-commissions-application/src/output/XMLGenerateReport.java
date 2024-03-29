package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.Salesman;


public class XMLGenerateReport extends GenerateReport{

		
	public XMLGenerateReport(Salesman a, File fileToSave) {
	    super(a, fileToSave);
	}
	


	@Override
	protected String getFullPathName() {
	    return fileToSave.getAbsolutePath();
	}


    @Override
    protected void createFile(String fullPathName) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            documentBuilder.newDocument().createTextNode(fullPathName);
        } catch (Exception ex) {
            handleException("Error creating XML file: " + ex.getMessage());
        }
    }

    @Override
	public void writeDataToFile(String fullPathName) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.newDocument();

            org.w3c.dom.Element salesmanElem = document.createElement("Salesman");
            document.appendChild(salesmanElem);

            org.w3c.dom.Element name = document.createElement("Name");
            name.appendChild(document.createTextNode(salesman.getName()));
            salesmanElem.appendChild(name);

            org.w3c.dom.Element afm = document.createElement("AFM");
            afm.appendChild(document.createTextNode(salesman.getAfm()));
            salesmanElem.appendChild(afm);

            org.w3c.dom.Element totalSales = document.createElement("TotalSales");
            totalSales.appendChild(document.createTextNode(Double.toString(salesman.calculateTotalSales())));
            salesmanElem.appendChild(totalSales);

            org.w3c.dom.Element trouserSales = document.createElement("TrousersSales");
            trouserSales.appendChild(document.createTextNode(Float.toString(salesman.calculateTrouserSales())));
            salesmanElem.appendChild(trouserSales);

            org.w3c.dom.Element skirtsSales = document.createElement("SkirtsSales");
            skirtsSales.appendChild(document.createTextNode(Float.toString(salesman.calculateSkirtsSales())));
            salesmanElem.appendChild(skirtsSales);

            org.w3c.dom.Element shirtsSales = document.createElement("ShirtsSales");
            shirtsSales.appendChild(document.createTextNode(Float.toString(salesman.calculateShirtsSales())));
            salesmanElem.appendChild(shirtsSales);

            org.w3c.dom.Element coatsSales = document.createElement("CoatsSales");
            coatsSales.appendChild(document.createTextNode(Float.toString(salesman.calculateCoatsSales())));
            salesmanElem.appendChild(coatsSales);

            org.w3c.dom.Element commission = document.createElement("Commission");
            commission.appendChild(document.createTextNode(Double.toString(salesman.calculateCommission())));
            salesmanElem.appendChild(commission);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(fullPathName));
            transformer.transform(domSource, streamResult);
        } catch (Exception ex) {
            handleException("Error writing data to XML file: " + ex.getMessage());
        }
    }

    private void handleException(String errorMessage) {
        System.out.println(errorMessage);
    }

}

