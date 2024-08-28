package edu.westga.cs1302.lab1.model;

import java.util.ArrayList;

/**
 * Stores information for a bill.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Bill {
	public static final double TIP_RATE = 0.2;
	public static final double TAX_RATE = 0.1;
	private ArrayList<BillItem> items;
	private double subTotal;
	private double tax;
	private double tip;

	/**
	 * Create a new empty Bill
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public Bill() {
		this.items = new ArrayList<BillItem>();
	}

	/**
	 * @return the items
	 */
	public ArrayList<BillItem> getItems() {
		return items;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @return the tip
	 */
	public double getTip() {
		return tip;
	}

	/**
	 * @return the subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}

	/**
	 * Adds the item to the bill
	 * 
	 * @precondition item != null
	 * @postcondition item is added to the list of items in the bill
	 * 
	 * @param item the item to be added to the bill
	 */
	public void addItem(BillItem item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null.");
		}
		this.items.add(item);
		this.subTotal += item.getAmount();		
	}
	
	/**
	 * Calculates tax and tip then calculates bill total
	 * 
	 * @return returns total of bill
	 */
	public double calculateTotal() {
		this.tax = this.subTotal * Bill.TAX_RATE;
		this.tip = this.subTotal * Bill.TIP_RATE;
		
		return this.subTotal + this.tax + this.tip;
	}
	

}
