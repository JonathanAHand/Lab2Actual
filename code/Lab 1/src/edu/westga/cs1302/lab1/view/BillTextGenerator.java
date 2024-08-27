package edu.westga.cs1302.lab1.view;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

/**
 * Generates text for the bill.
 * 
 * @author Jonathan Hand
 * @version 1.0
 * 
 */

public class BillTextGenerator {

	private BillItem[] items;

	/**
	 * Generates the actual text for the bill
	 * 
	 * @precondition bill != null
	 * @postcondition
	 * @param bill the bill text is being generated for
	 * 
	 * @return A string with the list of items on the bill and the total
	 */
	public String generateBillText(Bill bill) {
		if (bill == null) {
			throw new IllegalArgumentException("Invalid Input: Bill must not be null.");
		}
		StringBuilder billText = new StringBuilder();
		billText.append("ITEMS").append(System.lineSeparator());
		double subTotal = 0.0;
		for (BillItem item : this.items) {
			billText.append(item.getName()).append(" - ").append(item.getAmount()).append(System.lineSeparator());
			subTotal += item.getAmount();
		}

		billText.append(System.lineSeparator());
		billText.append("Subtotal: $").append(subTotal).append(System.lineSeparator());
		double billTax = subTotal * 0.07;
		double billTip = subTotal * 0.2;
		billText.append("TAX: $").append(billTax).append(System.lineSeparator());
		billText.append("TIP: $").append(billTip).append(System.lineSeparator());
		billText.append("Total: $").append(subTotal + billTax + billTip);

		return billText.toString();
	}

}
