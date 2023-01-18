package main.java;
/**
 * 
 */


import java.text.NumberFormat;

/**
 * Defines the BabyBook class.
 * Stores information about the book such as the name of the product and the number of pages.
 * @author Hendrik Braasch 
 *
 */
public class BabyBook extends Product
{
	private String name;
	private int pageCount;
	/**
	 * @param code the product code
	 * @param price the product's price
	 * @param name the product's name
	 * @param pageCount the number of pages in the book
	 * @throws IllegalCodeException
	 * @author Hendrik Braasch 
	 */
	public BabyBook(Integer code, double price, String name, int pageCount) throws IllegalCodeException {
		super(code, price);
		this.name = name;
		this.pageCount = pageCount;
	}
	
	/**
	 * Sets the product's name
	 * @param name the product's name
	 * @author Hendrik Braasch 
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the product's name
	 * @return the product's name
	 * @author Hendrik Braasch 
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the page count
	 * @param pages numbers of pages in the book
	 * @author Hendrik Braasch 
	 */
	public void setPageCount(int pages)
	{
		this.pageCount = pages;
	}
	
	/**
	 * Gets the number of pages
	 * @return the number of pages in the product
	 * @author Hendrik Braasch 
	 */
	public int getPageCount()
	{
		return this.pageCount;
	}
	
	@Override
	public String toString()
	{
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return this.name + " Code: " + super.getCode() + " Pages: " + this.pageCount + " Price: " + currencyFormat.format(super.getPrice());
	}
}
