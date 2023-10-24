/*
 * Camila Ramirez (cramirezmendoza1@toromail.csudh.edu)
 */
package assignment3;
import java.util.*;

	class Item 
	{
	    String name;
	    String vendor;
	    double price;
	    double cost;
	    double weight;
	    double taxRate;

	    public Item(String name, String vendor, double price, double cost, double weight, double taxRate) {
	        this.name = name;
	        this.vendor = vendor;
	        this.price = price;
	        this.cost = cost;
	        this.weight = weight;
	        this.taxRate = taxRate;
	    }

	    public double getPriceWTax() {
	        return price + (price * taxRate / 100);
	    }
	    
	    public String toString() {
	        return "Name: " + name + ", Price: " + price + ", Tax: " + (price * taxRate / 100) + ", Total: " + getPriceWTax();
	    }
	}

	
	class Pub extends Item 
	{
	    String author;
	    String pMonth;
	    int numOfPages;

	    public Pub(String name, String vendor, double price, double cost, double weight, double taxRate, String author, String pubMonth, int numberOfPages) 
	    {
	        super(name, vendor, price, cost, weight, taxRate);
	        this.author = author;
	        this.pMonth = pubMonth;
	        this.numOfPages = numberOfPages;
	    }
	}


	class Food extends Item 
	{
	    Date sellBy;
	    Date useBy;

	    public Food(String name, String vendor, double price, double cost, double weight, double taxRate, Date sellBy, Date useBy) 
	    {
	        super(name, vendor, price, cost, weight, taxRate);
	        this.sellBy = sellBy;
	        this.useBy = useBy;
	    }
	}

	
	class ShoppingCartContainer 
	{
	    List<Item> items = new ArrayList<>();

	    public void addItem(Item item) 
	    {
	        items.add(item);
	    }

	    public int getNumberOfItems() 
	    {
	        return items.size();
	    }

	    public double getTotalCost() 
	    {
	        double total = 0;
	        for (Item item : items) 
	        {
	            total += item.getPriceWTax();
	        }
	        return total;
	    }

	    public void printItems() 
	    {
	        for (Item item : items) 
	        {
	            System.out.println(item); 
	        }
	    }
	}

	
	public class ShoppingCart 
	{
	    public static void main(String[] args) 
	    {
	    	ShoppingCartContainer cart = new ShoppingCartContainer();

	       
	        cart.addItem(new Pub("MyMemoir", "Publication", 15, 10, 1.5, 5, "Camila", "October", 500));
	        cart.addItem(new Food("Pineapple", "Food", 1.25, 0.2, 0.1, 2, new Date(), new Date()));
	        cart.addItem(new Item("Sunscreen", "Selfcare", 5, 1, 0.3, 2));  

	        
	        System.out.println("Items in the cart: ");
	        cart.printItems();

	        System.out.println("Total items: " + cart.getNumberOfItems());
	        System.out.println("Total cost: " + String.format("$%.2f", cart.getTotalCost()));

	    }
	

}
