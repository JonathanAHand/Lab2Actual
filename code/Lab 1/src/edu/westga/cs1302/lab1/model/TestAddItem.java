package edu.westga.cs1302.lab1.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAddItem {

	private Bill bill;

	@BeforeEach
	public void setUp() {
		this.bill = new Bill();
	}

	@Test
	public void testAddItemUpdatesSubtotalCorrectly() {
		BillItem item1 = new BillItem("Monster", 3.00, "Energy Drink");
		BillItem item2 = new BillItem("Doughnut", 2.00, "Food");

		this.bill.addItem(item1);
		this.bill.addItem(item2);

		assertEquals(5.00, this.bill.getSubTotal());
	}

	@Test
	public void testSingleItemAdded() {
		BillItem item1 = new BillItem("Red Bull", 2.00, "Energy Drink");

		this.bill.addItem(item1);

		assertEquals(1, this.bill.getItems().size());
		assertEquals(2.00, this.bill.getSubTotal());
	}

	@Test
	public void testMultipleItemsAdded() {
		BillItem item1 = new BillItem("Red Bull", 3.00, "Energy Drink");
		BillItem item2 = new BillItem("Red Bull", 2.00, "Energy Drink");
		BillItem item3 = new BillItem("Bud Light Lime", 10.99, "Beer");

		this.bill.addItem(item1);
		this.bill.addItem(item2);
		this.bill.addItem(item3);

		assertEquals(3, this.bill.getItems().size());
		assertEquals(15.99, this.bill.getSubTotal());
	}
}
