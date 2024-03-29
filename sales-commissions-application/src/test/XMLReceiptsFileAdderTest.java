package test;

import input.XMLReceiptsFileAdder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XMLReceiptsFileAdderTest {

    private static final String TEST_DIR_PATH = "C:\\Users\\Panik\\Downloads\\1\\TestFiles";
    private static final String TEST_FILE_PATH = TEST_DIR_PATH + "\\TMLReceipt_Compare.xml";
    private static final String EXPECTED_FILE_PATH = "C:\\Users\\Panik\\Downloads\\1\\TestFiles\\XMLReceiptsFileAdderTest.xml";
    
    @BeforeEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE_PATH));
    }
    
    @Test
    void testAppendAndParseXmlFile() throws IOException {
        XMLReceiptsFileAdder xmlReceiptsFileAdder = new XMLReceiptsFileAdder();

        xmlReceiptsFileAdder.setFileToAppend(new File(TEST_FILE_PATH));
        xmlReceiptsFileAdder.setReceiptID("1");
        xmlReceiptsFileAdder.setDate("25/2/2014");
        xmlReceiptsFileAdder.setKind("Coats");
        xmlReceiptsFileAdder.setSales("2000");
        xmlReceiptsFileAdder.setItems("10");
        xmlReceiptsFileAdder.setCompany("Hand Made Clothes");
        xmlReceiptsFileAdder.setCountry("Greece");
        xmlReceiptsFileAdder.setCity("Ioannina");
        xmlReceiptsFileAdder.setStreet("Kaloudi");
        xmlReceiptsFileAdder.setNumber("10");

        xmlReceiptsFileAdder.appendSpecificData();

        assertTrue(Files.exists(Path.of(TEST_FILE_PATH)), "File should be created");

        List<String> generatedLines = Files.readAllLines(Path.of(TEST_FILE_PATH))
                .stream()
                .map(String::strip) 
                .skip(1)
                .collect(Collectors.toList());

        List<String> expectedLines = Files.readAllLines(Path.of(EXPECTED_FILE_PATH))
                .stream()
                .map(String::strip) 
                .skip(1)
                .collect(Collectors.toList());

        assertEquals(expectedLines.size() , generatedLines.size(), "Number of lines doesn't match");

        for (int i = 0; i < expectedLines.size(); i++) {
            assertEquals(expectedLines.get(i), generatedLines.get(i), "Line " + (i) + " doesn't match");
        }
    }
}

