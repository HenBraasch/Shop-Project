package main.java;
/**
 * 
 */


/**
 * Defines the recommended item class.
 * Stores a product and the frequency with which it was bought.
 * @author Hendrik Braasch 
 *
 */
public class RecommendedItem
{
	private Product product;
	private int freq;
	
	/**
	 * Constructor that takes a product and the frequency with which the product was bought
	 * @param product a product object
	 * @param freq frequency with which the product was bought
	 * @author Hendrik Braasch 
	 */
	public RecommendedItem(Product product, int freq)
	{
		this.product = product;
		this.freq = freq;
	}
	
	/**
	 * Retrieves a recommended item
	 * @return a recommended item
	 * @author Hendrik Braasch 
	 */
	public Product getProduct()
	{
		return this.product;
	}
	
	/**
	 * Sets the recommended item
	 * @param product a recommended item
	 * @author Hendrik Braasch 
	 */
	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	/**
	 * Gets the frequency with which it was bought
	 * @return the frequency with which the product was bought
	 * @author Hendrik Braasch 
	 */
	public int getFreq()
	{
		return this.freq;
	}
	
	/**
	 * Sets the frequency with which it was bought
	 * @param frequency the frequency with which the product was bought
	 * @author Hendrik Braasch 
	 */
	public void setFreq(int frequency)
	{
		this.freq = frequency;
	}		
}
