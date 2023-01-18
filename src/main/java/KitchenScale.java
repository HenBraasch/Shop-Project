package main.java;
/**
 * 
 */


import java.text.NumberFormat;

/**
 * Defines the KitchenScale class.
 * Stores the name of the product and the year of first release.
 * @author Hendrik Braasch 
 *
 */
public class KitchenScale extends Product
{
	private String name;
	private int year;
	
	/**
	 * @param code the product's code
	 * @param price the product's price
	 * @throws IllegalCodeException
	 * @author Hendrik Braasch 
	 */
	public KitchenScale(Integer code, double price, String name, int year) throws IllegalCodeException {
		super(code, price);
		this.name = name;
		this.year = year;
	}
	
	/**
	 * Sets the products name
	 * @param name the product's name
	 * @author Hendrik Braasch 
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the product's name
	 * @return the products name
	 * @author Hendrik Braasch 
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the manufacturing year
	 * @param year year of manufactoring
	 * @author Hendrik Braasch 
	 */
	public void setYear(int year)
	{
		this.year = year;
	}
	
	/**
	 * Gets the year of manufactoring
	 * @return the year of manufacturing
	 * @author Hendrik Braasch 
	 */
	public int getYear()
	{
		return this.year;
	}
	
	@Override
	public String toString()
	{
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return this.name + " Code: " + super.getCode() + " Released: " + this.year + " Price: " + currencyFormat.format(super.getPrice());
	}
}
