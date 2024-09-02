package edu.westga.cs1302.lab1.view;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

class TestGenerateBillText {

	private BillTextGenerator generator;
	
	@BeforeEach
	void setUp() {
        this.generator = new BillTextGenerator();
    }

	@Test
	public void testBillShouldNotBeNull() {
		BillTextGenerator text = new BillTextGenerator();
		assertThrows(IllegalArgumentException.class, () -> {
			text.generateBillText(null);
		});
	}
	
	@Test
    void testGenerateBillTextWithOnlyOneItem() {
        Bill bill = new Bill();
        bill.addItem(new BillItem("Coffee", 3.50, "Beverage"));
        bill.calculateTotal();

        String expected = "ITEMS\n"
                          + "Coffee - $3.50\n\n" 
                          + "Subtotal: $3.50\n" 
                          + "TAX: $0.35\n" 
                          + "TIP: $0.70\n"
                          + "Total: $4.55";

        assertEquals(expected, this.generator.generateBillText(bill));
    }
	
	@Test
    void testGenerateBillTextWithMultipleItems() {
        Bill bill = new Bill();
        bill.addItem(new BillItem("Bagel", 2.75, "Food"));
        bill.addItem(new BillItem("Tea", 1.50, "Beverage"));
        bill.calculateTotal();

        String expected = "ITEMS\n" 
                          + "Bagel - $2.75\n" 
                          + "Tea - $1.50\n\n"
                          + "Subtotal: $4.25\n"
                          + "TAX: $0.43\n"
                          + "TIP: $0.85\n"
                          + "Total: $5.53";

        assertEquals(expected, this.generator.generateBillText(bill));
    }
	
}
