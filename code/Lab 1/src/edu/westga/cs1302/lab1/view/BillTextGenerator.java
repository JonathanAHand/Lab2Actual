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
		
		for (BillItem item : bill.getItems()) {
			billText.append(item.getName()).append(" - ").append(this.currencyFormatter(item.getAmount())).append(System.lineSeparator());
		}

		billText.append(System.lineSeparator());
		billText.append("Subtotal: $").append(this.currencyFormatter(bill.getSubTotal())).append(System.lineSeparator());
		double total = bill.calculateTotal();
		
		billText.append("TAX: $").append(this.currencyFormatter(bill.getTax())).append(System.lineSeparator());
		billText.append("TIP: $").append(this.currencyFormatter(bill.getTip())).append(System.lineSeparator());
		billText.append("Total: $").append(this.currencyFormatter(total));

		return billText.toString();
		}
	
	private String currencyFormatter(double amount) {
		return String.format("%.2f", amount);
	}

}
