package main.java;


/**
 * Defines the ProductNotFoundException
 * Extends Exception
 * @author Hendrik Braasch 
 */

public class ProductNotFoundException extends Exception
{
	/**
	 * Constructor that takes a name
	 * @param name the name of the error
	 * @author Hendrik Braasch 
	 */
	public ProductNotFoundException(String name)
	{
		super(name);
	}
	
	/**
	 * Constructor
	 * @author Hendrik Braasch 
	 */
	public ProductNotFoundException()
	{
		super();
	}
}
