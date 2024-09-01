package edu.westga.cs1302.lab1.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConstuctor {

	@Test
	public void testConstructorHasValidValues() {
		BillItem item = new BillItem("Starbucks", 10.99, "coffee");
		assertEquals("Starbucks", item.getName());
		assertEquals(10.99, item.getAmount());
		assertEquals("coffee", item.getItem());
	}

	@Test
	public void testNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem(null, 10.99, "coffee");
		});
	}

	@Test
	public void testNameNotEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("", 10.99, "coffee");
		});
	}

	@Test
	public void testItemNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("Starbucks", 10.99, null);
		});
	}

	@Test
	public void testItemEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("Starbucks", 10.99, "");
		});
	}

	@Test
	public void testWhenAmountOneAboveBoundary() {
		BillItem item = new BillItem("Starbucks", 0.01, "coffee");
		assertEquals("Starbucks", item.getName());
		assertEquals(0.01, item.getAmount());
		assertEquals("coffee", item.getItem());
	}

	@Test
	public void testWhenAmountAtBoundary() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("Egglands Best", 0.00, "free eggs");
		});
	}

	@Test
	public void testWhenAmountBelowBoundary() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("Egglands Best", -3.99, "negative eggs");
		});
	}

	@Test
	public void testGetName() {
		BillItem item = new BillItem("Milk", 6.00, "item");
		assertEquals("Milk", item.getName());
	}

	@Test
	public void testGetAmount() {
		BillItem item = new BillItem("Bread", 4.99, "item");
		assertEquals(4.99, item.getAmount());
	}

	@Test
	public void testGetItem() {
		BillItem item = new BillItem("Detergent", 14.68, "Tide");
		assertEquals("Tide", item.getItem());
	}

}
