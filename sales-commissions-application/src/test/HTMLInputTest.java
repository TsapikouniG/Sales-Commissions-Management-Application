package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.junit.jupiter.api.Test;

import data.Receipt;
import data.Salesman;
import input.HTMLInput;

public class HTMLInputTest {

    private static final String UPDATED_HTML_FILE_PATH = "C:\\Users\\Panik\\Downloads\\1\\TestFiles\\HTMLInputTest.html";

    @Test
    public void testReadFile() {
    	
        File sampleFile = new File(UPDATED_HTML_FILE_PATH);

        HTMLInput htmlInput = new HTMLInput(sampleFile);

        htmlInput.readFile();

        Salesman salesman = htmlInput.getSalesman();

        assertNotNull(salesman, "Salesman should not be null");
        assertEquals("Alexandros Zarras", salesman.getName(), "Incorrect name");
        assertEquals("130456093", salesman.getAfm(), "Incorrect AFM");

        assertFalse(salesman.getReceipts().isEmpty(), "No receipts found");

        Receipt firstReceipt = salesman.getReceipts().get(0);

        assertEquals(1, firstReceipt.getReceiptID(), "Incorrect Receipt ID");
        assertEquals("25/2/2014", firstReceipt.getDate(), "Incorrect date");
        assertEquals("Coats", firstReceipt.getKind(), "Incorrect kind");
        assertEquals(2000.0, firstReceipt.getSales(), 0.001, "Incorrect sales amount");
        assertEquals(10, firstReceipt.getItems(), "Incorrect number of items");

        assertEquals("Hand Made Clothes", firstReceipt.getCompany().getName(), "Incorrect company name");
        assertEquals("Greece", firstReceipt.getCompany().getCompanyAddress().getCountry(), "Incorrect country");
        assertEquals("Ioannina", firstReceipt.getCompany().getCompanyAddress().getCity(), "Incorrect city");
        assertEquals("Kaloudi", firstReceipt.getCompany().getCompanyAddress().getStreet(), "Incorrect street");
        assertEquals(10, firstReceipt.getCompany().getCompanyAddress().getStreetNumber(), "Incorrect street number");
    }
}
