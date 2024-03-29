package test;

import output.TXTGenerateReport;
import data.Salesman;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TXTGenerateReportTest {

    @Test
    void testWriteDataToFile() {
        Salesman salesman = new Salesman();
        salesman.setName("Apostolos Zarras");
        salesman.setAfm("130456093");

        File customDirectory = new File("C:\\Users\\Panik\\Downloads\\1\\TestFiles");

        File tempFile = new File(customDirectory, "TXTGenerateReportTest.txt");

        TXTGenerateReport txtGenerateReport = new TXTGenerateReport(salesman, tempFile);

        String expectedData = "Name: Apostolos Zarras\n" +
                "AFM: 130456093\n" +
                "\n" +
                "\n" +
                "Total Sales: 0.0\n" +
                "Trousers Sales: 0.0\n" +
                "Skirts Sales: 0.0\n" +
                "Shirts Sales: 0.0\n" +
                "Coats Sales: 0.0\n" +
                "Commission: 0.0";

        try {
            txtGenerateReport.writeDataToFile(tempFile.getAbsolutePath());
        } catch (IOException e) {
            fail("Exception thrown while writing data to the file: " + e.getMessage());
        }

        try {
            String actualData = new String(Files.readAllBytes(Paths.get(tempFile.getAbsolutePath())));

            expectedData = expectedData.replace("\r\n", "\n");
            actualData = actualData.replace("\r\n", "\n");

            assertEquals(expectedData, actualData, "The content of the file is not as expected");
        } catch (IOException e) {
            fail("Exception thrown while reading data from the file: " + e.getMessage());
        }
    }
}

