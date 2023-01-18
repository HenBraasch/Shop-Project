package main.java;
/**
 * 
 */


import java.util.ArrayList;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;

/**
 * Defines the online shop class.
 * Contains function to create a product database, read and write data from a file
 * and helpermethods to make printing menuitems and product listings easier
 * @author Hendrik Braasch 
 *
 */
public class OnlineShopApp
{
	/**
	 * Generates a database for the shop
	 * @return a database of products available in the shop
	 * @author Hendrik Braasch 
	 */
	public static ProductDatabase generateSampleDatabase()
	{
		Smartphone aSmartphone = new Smartphone(123, 550.49,"Cheap and Smart Phone", 16, "Cheap as Chips Telco");
		Sausage aSausage = new Sausage(187, 9.99, "Pork Sausage","Beef");
		RiceCooker aCooker = new RiceCooker(199, 99.95,"Cooker of Rice",2017);
		KitchenScale aScale = new KitchenScale(200, 33.36, "HeavyDuty Scale", 2018);
		BabyBook aBook = new BabyBook(865, 12.49, "Peek-A-Boo Sky - The Book",25);
		
		ProductDatabase db = new ProductDatabase();
		
		db.put(aBook);
		db.put(aScale);
		db.put(aCooker);
		db.put(aSausage);
		db.put(aSmartphone);

		
		return db;
	}
	
	/**
	 * Reads historical purchase histories from a text file
	 * @param db the list of all products in the shop
	 * @param fileName the name of the file to be read
	 * @return a ProductDatabase with all products that are available in the shop
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws ProductNotFoundException
	 * @author Hendrik Braasch 
	 */
	public static ArrayList<PurchaseHistory> readPurchaseHistoryData(ProductDatabase db,String fileName) throws IOException, NumberFormatException, ProductNotFoundException
	{
		ArrayList<PurchaseHistory> pHistories = new ArrayList<PurchaseHistory>();

			Scanner scanner = new Scanner(new FileReader(fileName));			
		
			do
			{
				ArrayList<Product> products = new ArrayList<Product>();
				int productCount = scanner.nextInt();
				
				int[] numbers = new int[productCount];
				
				for(int i = 0; i < productCount; ++i)
				{
					numbers[i] = scanner.nextInt();
				}
				
				for(Integer number : numbers)
				{
					products.add(db.get(number));						
				}
				
				PurchaseHistory history = new PurchaseHistory(products);
				pHistories.add(history);
			}
			while(scanner.hasNext());
		
			scanner.close();
		
		return pHistories;				
	}
	
	/**
	 * Appends the purchase history to a text file.
	 * @param cart list of products in the user's cart
	 * @param fileName name of the file to be written to
	 * @author Hendrik Braasch 
	 */
	public static void writePurchaseHistoryData(ArrayList<Product> cart, String fileName)
	{		
		int purchaseCount = cart.size();
		
		try
		{
			PrintWriter writer = new PrintWriter(new FileWriter(fileName,true));
			writer.println(purchaseCount);
			for(int i = 0; i < purchaseCount; ++i)
			{
				writer.println(cart.get(i).getCode());
			}
			
			writer.close();
		}
		catch(IOException e)
		{
			System.err.println("File can't be openend");
		}		
	}
	
	/**
	 * The main method
	 * @param args
	 * @author Hendrik Braasch 
	 */
	public static void main(String[] args)
	{		
		ArrayList<PurchaseHistory> pHistory = new ArrayList<PurchaseHistory>();
		String fileName = "purchase-history.txt";
		ProductDatabase database = generateSampleDatabase();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Reading purchase transcript: purchase-history.txt");
		System.out.println("---------------------");
		try
		{
			pHistory = readPurchaseHistoryData(database, fileName);
		}
		catch(IOException e)
		{
			System.err.println("File not found");
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			System.err.println("Incorrect number format");
		} 
		catch (ProductNotFoundException e)
		{
			System.err.println("Product not found");
		}
		
		OnlineShop shop = new OnlineShop(database,pHistory);
		boolean isContinue = true;
		ArrayList<Product> listings;
		
		do
		{
			printMenuItems();
			
			int userChoice;
			
			try
			{
				userChoice = getMenuItemChoice(scanner, 4);
				
				switch(userChoice)
				{
				//User can add an item to their cart
				case 1:					
					{
						listings = shop.getProductListing();
						printListingOverview(listings);
						
						try
						{
							int menuItem = getProductChoice(scanner);
							Product product = database.get(listings.get(menuItem).getCode());
							shop.addToCart(product);
							System.out.println("Adding ... " + product);
						}
						catch(ProductNotFoundException e)
						{
							System.err.println("Item not found.");
						}
					}
					
					break;
				//User can view their cart
				case 2:
				{
					if(shop.getShoppingCart().size() < 1)
					{
						System.out.println("\nThe cart is empty. Find something you like and add it.\n");
					}
					else
					{
						Collections.sort(shop.getShoppingCart());
						printCart(shop.getShoppingCart());
					}
					
					break;					
				}
				//User can complete the purchase
				case 3:
				{
					printCart(shop.getShoppingCart());
					NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
					System.out.println("Total amount owing " + currencyFormat.format(shop.amountOwing()));
					if(shop.amountOwing() == 0.0)
					{
						System.out.println("\nYour cart is empty. Taking you back to the main menu.\n");
						break;
					}
					else
					{					
						System.out.println("Do you pay in full?");
						System.out.println("1) Yes");
						System.out.println("2) No (Go back to main menu)");
						int completeTransaction;
						
						completeTransaction = getMenuItemChoice(scanner, 2);
						
						switch(completeTransaction)
						{
						//Completes the purchase, recommends items and writes the cart to the file as
						//an additional purchase history
						case 1:
						{
							System.out.println("");
							writePurchaseHistoryData(shop.getShoppingCart(),fileName);
							shop.completeTransaction();							
							break;
						}
						//Takes the user back to the main menu
						case 2:
							break;
						}
						break;
					}
				}
				//User can quit the program
				case 4:
				{
					isContinue = false;
					break;
				}
				default:
					System.out.println("This not not an option.");
					break;
				}
			}
			catch(IncorrectEntryException e)
			{
				System.err.println("Entered number is not within then required range.");
				userChoice = 0;
			}
			catch(InputMismatchException e)
			{
				System.err.println("The entered value is not an integer.");
			}
		}while(isContinue);
		
		scanner.close();
		System.out.println("Thanks for your business. See you next time.");				
	}
	
	/**
	 * Prints the content of the user's cart
	 * @param cart the user's cart
	 * @author Hendrik Braasch 
	 */
	private static void printCart(ArrayList<Product> cart)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Content of your cart. (Sorted by price - ascending)");
		sb.append("\n");
		for(Product product : cart)
		{
			sb.append(product.toString());
			sb.append("\n");
		}
		sb.append("---------------------");
		
		System.out.println(sb.toString());
	}
	
	/**
	 * Gets the item the user selected.
	 * @return the users input - 1 to account for the 0 based array
	 * @author Hendrik Braasch 
	 */
	private static int getProductChoice(Scanner scanner)
	{
		int productChoice = scanner.nextInt();
		scanner.nextLine();
		
		if(productChoice < 1 || productChoice > 5)
			throw new IncorrectEntryException("Invalid option");
		
		return productChoice - 1;		
	}
	
	/**
	 * Prints a list of the shop functions
	 */
	private static void printMenuItems()
	{
		System.out.println("Functions");
		System.out.println("1. Add product to cart");
		System.out.println("2. View your cart");
		System.out.println("3. Complete purchase");
		System.out.println("4. Quit");
		System.out.println("Please choose a menu item: (1-4)");
	}
	
	/**
	 * Gets user input between 1 and 4
	 * @return user input after checking it is between 1 and four
	 * @param scanner an instance of a scanner object
	 * @param menuItems the number of menuitems to print
	 * @throws InputMismatchException
	 * @throws IncorrectEntryException
	 * @author Hendrik Braasch 
	 */
	private static int getMenuItemChoice(Scanner scanner, int menuItems) throws IncorrectEntryException, InputMismatchException
	{		
		int usersChoice = scanner.nextInt();
		scanner.nextLine();
		
		if(usersChoice < 1 || usersChoice > menuItems)
			throw new IncorrectEntryException("Invalid option");
		
		return usersChoice;
	}
	
	/**
	 * Prints all listings
	 * @param listings a list of products available in the store
	 * @author Hendrik Braasch 
	 */
	private static void printListingOverview(ArrayList<Product> listings)
	{
		int index = 0;
		System.out.println("Select one of the available products.");
		for(Product product : listings)
		{
			System.out.println(++index + ") " + product.toString());
		}
		System.out.println("---------------------");
	}
}
