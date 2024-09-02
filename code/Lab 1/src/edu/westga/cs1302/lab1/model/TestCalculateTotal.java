package edu.westga.cs1302.lab1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestCalculateTotal {

	@Test
	public void testWhenSubtotalIsZeroValue() {
		Bill bill = new Bill();
		bill.setSubTotal(0.0);
		assertEquals(0.0, bill.calculateTotal(), 0.01);
	}

	@Test
	public void testWhenSubtotalIsNormalValue() {
		Bill bill = new Bill();
		bill.setSubTotal(100.0);
		double expectedTotal = 100.0 + (100.0 * Bill.TAX_RATE) + (100.0 * Bill.TIP_RATE);
		assertEquals(expectedTotal, bill.calculateTotal(), 0.01);
	}

	@Test
	public void testWhenSubtotalIsNegativeValue() {
		Bill bill = new Bill();
		bill.setSubTotal(-50.0);
		double expectedTotal = -50.0 + (-50.0 * Bill.TAX_RATE) + (-50.0 * Bill.TIP_RATE);
		assertEquals(expectedTotal, bill.calculateTotal(), 0.01);
	}
	
	@Test
    public void testWhenSubtotalIsLarge() {
        Bill bill = new Bill();
        bill.setSubTotal(1000000.09);
        double expectedTotal = 1000000.09 + (1000000.09 * Bill.TAX_RATE) + (1000000.09 * Bill.TIP_RATE);
        assertEquals(expectedTotal, bill.calculateTotal(), 0.01);
	}
	
	@Test
    public void testWhenSubtotalIsSmall() {
        Bill bill = new Bill();
        bill.setSubTotal(0.009);
        double expectedTotal = 0.009 + (0.009 * Bill.TAX_RATE) + (0.009 * Bill.TIP_RATE);
        assertEquals(expectedTotal, bill.calculateTotal(), 0.01);
	}
	
}
