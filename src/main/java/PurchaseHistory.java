package main.java;
/**
 * 
 */


import java.util.*;
/**
 * Defines the PurchaseHistory class.
 * Stores a list of all purchases.
 * @author Hendrik Braasch 
 *
 */
public class PurchaseHistory
{
	private ArrayList<Product> purchases;
	
	/**
	 * Initialises the list of purchases
	 * @param purchases list of product objects
	 * @author Hendrik Braasch 
	 */
	public PurchaseHistory(ArrayList<Product> purchases)
	{
		this.purchases = purchases;
	}
	
	/**
	 * Gets all purchases
	 * @return the list of purchases
	 * @author Hendrik Braasch 
	 */
	public ArrayList<Product> getPurchases()
	{
		return this.purchases;
	}
	
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		
		for(Product product : purchases)
		{
			string.append(product);
			string.append("\n");
		}
		
		return string.toString();
	}
}
