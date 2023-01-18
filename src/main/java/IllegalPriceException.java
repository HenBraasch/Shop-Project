package main.java;


/**
 * Defines the IllegalPriceException. Extends IllegalArgumentException
 * @author Hendrik Braasch
 *
 */
public class IllegalPriceException extends IllegalArgumentException
{
	/**
	 * Constructor that gets the name of the exception
	 * @param name the name of the exception
	 * @author Hendrik Braasch 
	 */
	public IllegalPriceException(String name)
	{
		super(name);
	}
	
	/**
	 * Default constructor
	 * @author Hendrik Braasch 
	 */
	public IllegalPriceException()
	{
		super();
	}
}
