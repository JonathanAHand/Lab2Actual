package edu.westga.cs1302.lab1.model;

/**
 * Stores information for a single item on a bill.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillItem {
	private String name;
	private double amount;

	/**
	 * Creates a new bill item with the provided name and amount.
	 * 
	 * @precondition name != null && amount > 0
	 * @postcondition getName() == name && getAmount() == amount
	 * @param item   the item listed on the bill
	 * @param name   the name of the bill item
	 * @param amount the amount (cost) of the bill item
	 */
	public BillItem(String name, double amount, String item) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null.");
		}
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be positive, but was " + amount);
		}
		this.name = name;
		this.amount = amount;
	}

	/**
	 * Return the name for the bill item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name for the bill item
	 */
	public String getName() {
		return this.name;
	}
	
	/** Return the amount for the bill item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the amount for the bill item
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/** Return the item for the bill
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the item for the bill
	 */
	public String getItem() {
		return this.getItem();
	}
}
