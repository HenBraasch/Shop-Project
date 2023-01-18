package main.java;
/**
 * 
 */

import java.util.*;

/**
 * Defines the Product Database class. It stores the products offered in the shop.
 * @author Hendrik Braasch 
 *
 */
public class ProductDatabase 
{
	private ArrayList<Product> database;
	
	/**
	 * Default constructor
	 * @author Hendrik Braasch 
	 */
	public ProductDatabase()
	{
		database =  new ArrayList<Product>();
	}
	
	/**
	 * Adds a product to the database
	 * @param product the product to add to the database
	 * @author Hendrik Braasch 
	 */
	public void put(Product product)
	{
		database.add(product);
	}
	
	/**
	 * Retrieves the product with the matching product code from the database
	 * @param number the product's code
	 * @return the product with the requested product code
	 * @author Hendrik Braasch 
	 */
	public Product get(Integer number) throws ProductNotFoundException
	{	
		int index = -1;
		
		for(int i = 0; i < database.size(); ++i)
		{
			int prod = database.get(i).getCode();
			if(prod == number)
			{
				index = i;
			}
		}	
		
		if(index == -1)
		{
			throw new ProductNotFoundException();
		}
		
		return database.get(index);
	}
	
	/**
	 * Retrieves all products from the database
	 * @return all products in the database
	 * @author Hendrik Braasch 
	 */
	public ArrayList<Product> getProducts()
	{
		ArrayList<Product> result = new ArrayList<Product>();
		
		for(Product product : database)
		{
			if(!result.contains(product))
			{
				result.add(product);
			}
		}
		
		return result;		
	}	
}
