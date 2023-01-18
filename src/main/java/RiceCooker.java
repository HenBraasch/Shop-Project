package main.java;
/**
 * 
 */


import java.text.NumberFormat;

/**
 * Defines the KitchenScale class.
 * Stores the name of the product and the year of first release.
 * @author Hendrik Braasch 
 */
public class RiceCooker extends Product
{
	private String name;
	private int year;
	
	/**
	 * Constructor
	 * @param code the product's code
	 * @param price the product's price
	 * @param name the product's name
	 * @param year the year of manufactoring
	 * @throws IllegalCodeException
	 * @author Hendrik Braasch 
	 */
	public RiceCooker(Integer code, double price, String name, int year) throws IllegalCodeException 
	{
		super(code, price);
		this.name = name;
		this.year = year;
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
	 * Retrieves the product's name
	 * @return the product's name
	 * @author Hendrik Braasch 
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the date of manufacturing
	 * @param year the year of manufacturing
	 * @author Hendrik Braasch 
	 */
	public void setYear(int year)
	{
		this.year = year;
	}
	
	/**
	 * Retrieves the year of manufacturing
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
