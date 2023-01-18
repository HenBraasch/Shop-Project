package main.java;
/**
 * 
 */

import java.util.ArrayList;

/**
 * Defines the online shop class.
 * contains a product database and a recommenderSysem, it also contains a shopping cart
 * and list of historical purchases
 * @author Hendrik Braasch 
 *
 */
public class OnlineShop implements PaymentSystem
{
	private ProductDatabase productDB;
	private ArrayList<Product> cart;
	private RecommenderSystem recommender;
	private ArrayList<PurchaseHistory> history;
	
	/**
	 * Initialises the OnlineShop
	 * @param database list of product available at the shop
	 * @param history a list of all historical purchases
	 * @author Hendrik Braasch 
	 */
	public OnlineShop(ProductDatabase database, ArrayList<PurchaseHistory> history)
	{
		this.productDB = database;
		cart = new ArrayList<Product>();
		this.history = history;
	}
	
	/**
	 * Get recommended products
	 * @return a list of recommend items that have a frequency of 2 or more
	 * @author Hendrik Braasch 
	 */
	public ArrayList<Product> getRecommendedProducts()
	{
		recommender = new RecommenderSystem(history,productDB);		
		ArrayList<Product> recommendedItems = recommender.productRecommenderAlgorithm(cart, 2);

		return recommendedItems;
	}
	
	/**
	 * Add a product to the cart
	 * @param product - The product that is to be added
	 * @return true if successfully added, false if the product was not added.
	 * @author Hendrik Braasch 
	 */
	public boolean addToCart(Product product)
	{
		boolean result;
		
			if(!cart.contains(product))
			{
				cart.add(product);
				result = true;
			}
			else
				result = true;
			
		return result;		
	}
	
	/**
	 * Returns the list of products available in the store
	 * @return a list of all product available in the store
	 * @author Hendrik Braasch 
	 */
	public ArrayList<Product> getProductListing()
	{
		return this.productDB.getProducts();
	}
	
	/**
	 * Returns the content of the cart
	 * @return content of the cart
	 * @author Hendrik Braasch 
	 */
	public ArrayList<Product> getShoppingCart()
	{
		return this.cart;
	}

	@Override
	public Double amountOwing()
	{
		double result = 0.00;
		for(Product product : cart)
		{
			result += product.getPrice();
		}
		
		return result;
	}

	@Override
	public void completeTransaction()
	{
		System.out.println("Thank you for your business.");
		System.out.println("Customers also bought:");
		ArrayList<Product> recomItems = getRecommendedProducts();
		System.out.println(recomItems.toString());
		System.out.println("---------------------");
		cart.clear();
	}	
}
