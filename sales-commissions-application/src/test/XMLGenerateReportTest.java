package test;

import output.XMLGenerateReport;
import data.Salesman;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class XMLGenerateReportTest {

    @Test
    void testWriteDataToFile() throws IOException {
        Salesman salesman = new Salesman();
        salesman.setName("Apostolos Zarras");
        salesman.setAfm("130456093");

        File customDirectory = new File("C:\\Users\\Panik\\Downloads\\1\\TestFiles");

        File tempFile = new File(customDirectory, "XMLGenerateReportTest.xml");

        XMLGenerateReport xmlGenerateReport = new XMLGenerateReport(salesman, tempFile);

        String expectedData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<Salesman>\n" +
                "    <Name>Apostolos Zarras</Name>\n" +
                "    <AFM>130456093</AFM>\n" +
                "    <TotalSales>0.0</TotalSales>\n" +
                "    <TrousersSales>0.0</TrousersSales>\n" +
                "    <SkirtsSales>0.0</SkirtsSales>\n" +
                "    <ShirtsSales>0.0</ShirtsSales>\n" +
                "    <CoatsSales>0.0</CoatsSales>\n" +
                "    <Commission>0.0</Commission>\n" +
                "</Salesman>";

        xmlGenerateReport.writeDataToFile(tempFile.getAbsolutePath());

        try {
            String actualData = new String(Files.readAllBytes(Paths.get(tempFile.getAbsolutePath())));

            expectedData = expectedData.replaceAll("\\s", "");
            actualData = actualData.replaceAll("\\s", "");

            assertEquals(expectedData, actualData, "The content of the file is not as expected");
        } catch (IOException e) {
            fail("Exception thrown while reading data from the file: " + e.getMessage());
        }

    }
}
