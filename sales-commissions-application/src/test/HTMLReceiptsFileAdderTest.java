package test;

import input.HTMLReceiptsFileAdder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HTMLReceiptsFileAdderTest {

    private static final String TEST_DIR_PATH = "C:\\Users\\Panik\\Downloads\\1\\TestFiles";
    private static final String TEST_FILE_PATH = TEST_DIR_PATH + "\\HTMLReceipt_Compare.html";
    private static final String EXPECTED_FILE_PATH = "C:\\Users\\Panik\\Downloads\\1\\TestFiles\\HTMLReceiptsFileAdderTest.html";

    @BeforeEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE_PATH));
    }

    @Test
    void testAppendAndParseHtmlFile() throws IOException {

        HTMLReceiptsFileAdder htmlReceiptsFileAdder = new HTMLReceiptsFileAdder();

        htmlReceiptsFileAdder.setFileToAppend(new File(TEST_FILE_PATH));
        htmlReceiptsFileAdder.setReceiptID("1");
        htmlReceiptsFileAdder.setDate("25/2/2014");
        htmlReceiptsFileAdder.setKind("Coats");
        htmlReceiptsFileAdder.setSales("2000.0");
        htmlReceiptsFileAdder.setItems("10");
        htmlReceiptsFileAdder.setCompany("Hand Made Clothes");
        htmlReceiptsFileAdder.setCountry("Greece");
        htmlReceiptsFileAdder.setCity("Ioannina");
        htmlReceiptsFileAdder.setStreet("Kaloudi");
        htmlReceiptsFileAdder.setNumber("10");

        htmlReceiptsFileAdder.appendSpecificData();

        List<String> generatedLines = Files.readAllLines(Path.of(TEST_FILE_PATH));

        List<String> expectedLines = Files.readAllLines(Path.of(EXPECTED_FILE_PATH));

        assertEquals(expectedLines.size(), generatedLines.size(), "Number of lines doesn't match");

        for (int i = 0; i < expectedLines.size(); i++) {
            assertEquals(expectedLines.get(i), generatedLines.get(i), "Line " + (i + 1) + " doesn't match");
        }

    }

}
