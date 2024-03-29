package test;

import input.TXTReceiptsFileAdder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TXTReceiptsFileAdderTest {

    private static final String TEST_DIR_PATH = "C:\\Users\\Panik\\Downloads\\1\\TestFiles";
    private static final String TEST_FILE_PATH = TEST_DIR_PATH + "\\TXTReceipt_Compare.txt";
    private static final String EXPECTED_FILE_PATH = "C:\\Users\\Panik\\Downloads\\1\\TestFiles\\TXTReceiptsFileAdderTest.txt";
    
    @BeforeEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE_PATH));
    }
    
    @Test
    void testAppendAndParseTxtFile() throws IOException {
     
        TXTReceiptsFileAdder txtReceiptsFileAdder = new TXTReceiptsFileAdder();

        txtReceiptsFileAdder.setFileToAppend(new File(TEST_FILE_PATH));
        txtReceiptsFileAdder.setReceiptID("1");
        txtReceiptsFileAdder.setDate("25/2/2014");
        txtReceiptsFileAdder.setKind("Coats");
        txtReceiptsFileAdder.setSales("2000");
        txtReceiptsFileAdder.setItems("10");
        txtReceiptsFileAdder.setCompany("Hand Made Clothes");
        txtReceiptsFileAdder.setCountry("Greece");
        txtReceiptsFileAdder.setCity("Ioannina");
        txtReceiptsFileAdder.setStreet("Kaloudi");
        txtReceiptsFileAdder.setNumber("10");

        txtReceiptsFileAdder.appendSpecificData();

        List<String> generatedLines = Files.readAllLines(Path.of(TEST_FILE_PATH));

        List<String> expectedLines = Files.readAllLines(Path.of(EXPECTED_FILE_PATH));

        assertEquals(expectedLines.size(), generatedLines.size(), "Number of lines doesn't match");

        for (int i = 0; i < expectedLines.size(); i++) {
            assertEquals(expectedLines.get(i), generatedLines.get(i), "Line " + (i + 1) + " doesn't match");
        }
        
    }
    
}
