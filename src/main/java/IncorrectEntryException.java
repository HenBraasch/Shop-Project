package main.java;
/**
 * 
 */


/**
 * Defines the IncorrectEntryException. Extends NumberFormatException
 * @author Hendrik Braasch 
 *
 */
public class IncorrectEntryException extends NumberFormatException
{
	/**
	 * Constructor that gets the name of the exception
	 * @param name the name of the exception
	 * @author Hendrik Braasch 
	 */
	public IncorrectEntryException(String name)
	{
		super(name);
	}
	
	/**
	 * Default constructor
	 * @author Hendrik Braasch 
	 */
	public IncorrectEntryException()
	{
		super();
	}
}
