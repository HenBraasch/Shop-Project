package main.java;
/**
 * 
 */


import java.text.NumberFormat;

/**
 * Defines the Sausage class.
 * Stores the name of the product and the used meat.
 * @author Hendrik Braasch 
 *
 */
public class Sausage extends Product
{
	private String name;
	private String meat;
	
	/**
	 * @param code the product's code
	 * @param price the product's price
	 * @param name the product's name
	 * @param meat the type of meat used for the product
	 * @throws IllegalCodeException
	 * @author Hendrik Braasch 
	 */
	public Sausage(Integer code, double price, String name, String meat) throws IllegalCodeException
	{
		super(code, price);
		this.name = name;
		this.meat = meat;
	}
	
	/**
	 * Sets the name
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
	 * Sets the type of meat that was used
	 * @param meat the type of meat
	 * @author Hendrik Braasch 
	 */
	public void setMeat(String meat)
	{
		this.meat = meat;
	}
	
	/**
	 * Retrieves the type of meat used for the product
	 * @return the type of meat used for the product
	 * @author Hendrik Braasch 
	 */
	public String getMeat()
	{
		return this.meat;
	}
	
	@Override
	public String toString()
	{
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return this.name + " Code: " + super.getCode() + " contains " + this.meat + " meat " + "Price: " + currencyFormat.format(super.getPrice());
	}
}
