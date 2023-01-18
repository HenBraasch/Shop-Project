package main.java;


/**
 * Defines the NotImplementedException that extends the IllegalStateException
 * @author Hendrik Braasch
 *
 */
public class NotImplementedException extends IllegalStateException
{
	/**
	 * Constructor that takes a name
	 * @param name the name of the exception
	 * @author Hendrik Braasch 
	 */
	public NotImplementedException(String name)
	{
		super(name);
	}
	
	/**
	 * Default constructor
	 * @author Hendrik Braasch 
	 */
	public NotImplementedException()
	{
		super();
	}
}
