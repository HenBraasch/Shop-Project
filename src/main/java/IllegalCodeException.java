package main.java;
/**
 * 
 */


/**
 * Defines the IllegalCodeException. Extends IllegalArgumentException
 * @author Hendrik Braasch
 *
 */
public class IllegalCodeException extends IllegalArgumentException
{
	/**
	 * Constructor that gets the name of the exception
	 * @param name the name of the exception
	 * @author Hendrik Braasch 
	 */
	public IllegalCodeException(String name)
	{
		super(name);
	}
	
	/**
	 * Default constructor
	 * @author Hendrik Braasch 
	 */
	public IllegalCodeException()
	{
		super();
	}	
}
