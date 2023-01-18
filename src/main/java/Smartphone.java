package main.java;
/**
 * 
 */


import java.text.NumberFormat;

/**
 * Defines the Smartphone class;
 * Stores the name of the product, the storage capacity and the supported carrier.
 * @author Hendrik Braasch 
 *
 */
public class Smartphone extends Product
{
	private String name;
	private int storage;
	private String carrier;

	/**
	 * @param code the product's code
	 * @param price the product's price
	 * @param name the product's name
	 * @param storage the product's storage capacity
	 * @param carrier the carrier the phone is locked on
	 * @throws IllegalCodeException
	 * @author Hendrik Braasch 
	 */
	public Smartphone(Integer code, double price, String name, int storage, String carrier) throws IllegalCodeException
	{
		super(code, price);
		this.name = name;
		this.carrier = carrier;
		this.storage = storage;
	}
	
	/**
	 * Sets the name of the product
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
	 * Sets the storage capacity
	 * @param storage the storage capacity of the product
	 * @author Hendrik Braasch 
	 */
	public void setStorageCapacity(int storage)
	{
		this.storage = storage;
	}
	
	/**
	 * Retrieves the storage capacity of the product
	 * @return the storage capacity of the product
	 * @author Hendrik Braasch 
	 */
	public int getStorageCapacity()
	{
		return this.storage;
	}
	
	/**
	 * Sets the carrier the phone is locked on
	 * @param carrier the carrier the phone is locked on
	 * @author Hendrik Braasch 
	 */
	public void setCarrier(String carrier)
	{
		this.carrier = carrier;
	}
	
	/**
	 * Retrieves the carrier the phone is locked on
	 * @return the carrier the phone is locked on
	 * @author Hendrik Braasch 
	 */
	public String getCarrier()
	{
		return this.carrier;
	}
	
	@Override
	public String toString()
	{
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return this.name + " Code: " + super.getCode() + " " + this.storage + "GB " + "Carrier: " + this.carrier + " Price: " + currencyFormat.format(super.getPrice());
	}
}
