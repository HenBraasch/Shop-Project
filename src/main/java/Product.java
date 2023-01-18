package main.java;
/**
 * 
 */


/**
 * Defines the Product class.
 * It stores the product code as an integer and the price as a double.
 * It implements the Comparable interface
 * @author Hendrik Braasch 
 *
 */
public abstract class Product implements Comparable<Product>
{
	private Double _price;
	private Integer _code;
	
	/**
	 * Constructor that takes the product's code and the price
	 * @param code the product's code
	 * @param price the product's price
	 * @throws IllegalCodeException
	 * @author Hendrik Braasch 
	 */
	public Product(Integer code, double price) throws IllegalCodeException
	{
		setPrice(price);
		setCode(code);
	}
	
	/**
	 * Constructor that only takes the product's code
	 * @param code the product's code
	 * @throws IllegalCodeException
	 * @author Hendrik Braasch 
	 */
	public Product(Integer code) throws IllegalCodeException
	{
		this(code, 0.00);
	}
	
	/**
	 * Sets the price for a product
	 * @param price the product's price
	 * @throws IllegalPriceException
	 * @author Hendrik Braasch 
	 */
	public void setPrice(double price) throws IllegalPriceException
	{
		if(price <= 0.00)
			throw new IllegalPriceException("Price cannot be negative.");
		else
			_price = price;
	}
	
	/**
	 * Gets the product price
	 * @return the product's price
	 * @author Hendrik Braasch 
	 */
	public double getPrice()
	{
		return this._price;
	}
	
	/**
	 * Gets the product code
	 * @return the product's code
	 * @author Hendrik Braasch
	 */
	public Integer getCode()
	{
		return this._code;
	}
	
	/**
	 * Sets the product's code
	 * Note: This is public because of the specification, however this poses a risk of creating data inconsistencies.
	 * This should be private so that it can only be set once.
	 * @param code the product's code
	 * @throws IllegalCodeException
	 * @author Hendrik Braasch 
	 */
	public void setCode(Integer code) throws IllegalCodeException
	{
		if(code <= 0)
			throw new IllegalCodeException("Codes cannot be negative");
		else
			this._code = code;
	}
	
	@Override
	public int compareTo(Product aProduct)
	{		
		return this._price.compareTo(aProduct._price);
	}	
}
