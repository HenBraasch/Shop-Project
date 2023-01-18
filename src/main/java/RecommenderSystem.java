package main.java;
/**
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Defines the recommender system class.
 * Contains a list of historic purchases, a list of the available products in the shop
 * and a list of recommendItems
 * @author Hendrik Braasch 
 *
 */
public class RecommenderSystem
{
	private ArrayList<PurchaseHistory> purchaseHistories;
	private ProductDatabase productDB;
	private ArrayList<RecommendedItem> recommend;
		
	/**
	 * Defines the constructor
	 * @param purchaseHistory list of historical purchases
	 * @param productDB list of product available in the shop
	 * @author Hendrik Braasch 
	 */
	public RecommenderSystem(ArrayList<PurchaseHistory>purchaseHistory, ProductDatabase productDB)
	{
		this.purchaseHistories = purchaseHistory;
		this.productDB = productDB;
		this.recommend = new ArrayList<RecommendedItem>();
		
		for(Product product : productDB.getProducts())
		{
			int freq = 0;
			for(PurchaseHistory history : purchaseHistories)
			{
				for(Product purchase : history.getPurchases())
				{		
					if(purchase.equals(product))
						{
							freq++;
						}
				}
			}
			recommend.add(new RecommendedItem(product,freq));		
		}
	}
	
	/**
	 * Returns the frequency with which a product was bought
	 * @param product an instance of a product object
	 * @return frequency with which the product was bought
	 * @throws ProductNotFoundException 
	 * @author Hendrik Braasch 
	 */
	public int getProductFreq(Product product) throws ProductNotFoundException
	{
		int result = 0;
		
			for(RecommendedItem item : recommend)
			{
				if(item.getProduct().equals(product))
				{
					result = item.getFreq();
				}
				else
					throw new ProductNotFoundException();
			}
			
			return result;
	}
	
	/**
	 * Retrieves the frequency of a product. Same as getProductFreq
	 * @param product an instance of a product object
	 * @throws ProductNotFoundException
	 * @author Hendrik Braasch 
	 */
	public void updateProductFreq(Product product) throws ProductNotFoundException
	{
		getProductFreq(product);
	}
	
	/**
	 * Returns a list of products often bought together
	 * @param cart the cart containing all items the user wants to buy
	 * @param freq the frequency threshold for the recommendations
	 * @return returns a list of products that are often bought together
	 * @author Hendrik Braasch 
	 */
	public ArrayList<Product> productRecommenderAlgorithm(ArrayList<Product> cart, int freq)
	{
		HashMap<Product,Integer>freqMap = new HashMap<Product,Integer>();
		
		//populates hashmap
		for(RecommendedItem rItem : recommend)
		{
			if(!freqMap.containsKey(rItem.getProduct()))
			{
				freqMap.put(rItem.getProduct(), 0);
			}
		}
		
		//each element in cart
		for(Product element : cart)
		{
			//each historic purchase in the list of historical purchases
			for(PurchaseHistory history : purchaseHistories)
			{
				//if current historical list contains the element in cart
				if(history.getPurchases().contains(element))
				{
					//get each item from that list and add to hashmap
					for(Product item : history.getPurchases())
					{
						if(freqMap.containsKey(item) && !item.equals(element))
						{
							try
							{
								freqMap.put(item, freqMap.get(item)+1);					
							}
							catch(NullPointerException e)
							{
								System.err.println(e.getMessage());
							}
						}									
					}					
				}
			}
		}
		
		ArrayList<Product> recommendItems = new ArrayList<Product>();
		
		//add product to the recommendedProducts if their frequency is higher than the limit
		for(Map.Entry<Product,Integer> entry : freqMap.entrySet())
		{
			if(entry.getValue() > freq)
			recommendItems.add(entry.getKey());
		}
		
		return recommendItems;
	}
}
