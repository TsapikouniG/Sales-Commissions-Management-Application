package test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Receipt;
import data.Salesman;

public class SalesmanTest {

    private Salesman salesman;
    private Receipt receipt1;
    private Receipt receipt2;

    @BeforeEach
    public void setUp() {
        salesman = new Salesman();


        receipt1 = new Receipt();
        receipt1.setSales(5000.0);
        receipt1.setItems(10);
        receipt1.setKind("Shirts");
        salesman.getReceipts().add(receipt1);

        receipt2 = new Receipt();
        receipt2.setSales(3000.0);
        receipt2.setItems(15);
        receipt2.setKind("Coats");
        salesman.getReceipts().add(receipt2);
    }

    @Test
    public void testCalculateTotalSales() {
        double expectedTotalSales = 5000.0 + 3000.0;
        assertEquals(expectedTotalSales, salesman.calculateTotalSales());
    }

    @Test
    public void testCalculateTotalItems() {
        int expectedTotalItems = 10 + 15;
        assertEquals(expectedTotalItems, salesman.calculateTotalItems());
    }

    @Test
    public void testCalculateShirtsSales() {
        float expectedShirtsSales = 10; 
        assertEquals(expectedShirtsSales, salesman.calculateShirtsSales());
    }

    @Test
    public void testCalculateCoatsSales() {
        float expectedCoatsSales = 15; 
        assertEquals(expectedCoatsSales, salesman.calculateCoatsSales());
    }

    @Test
    public void testCalculateCommission() {
        double expectedCommission = 0.1 * (8000.0 - 6000.0);
        assertEquals(expectedCommission, salesman.calculateCommission());
    }

  

}
