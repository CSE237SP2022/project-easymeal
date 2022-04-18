package menu;


public class MenuItem {
	private int itemKey; 
	private String itemName; 
	private double itemPrice;
	private int itemCalories;
	private int itemAmountInStock; 
	
	
	
	public MenuItem() {
		itemKey = -1;
		itemName = ""; 
		itemPrice = 0.0; 
		itemCalories = 0;
		itemAmountInStock = 0; 
	}
	public MenuItem(int itemKey, String itemName, double itemPrice, int itemCalories, int itemAmountInStock) {
		this.itemKey = itemKey; 
		this.itemName = itemName;
		this.itemPrice = itemPrice; 
		this.itemCalories = itemCalories; 
		this.itemAmountInStock = itemAmountInStock; // quantity of items currently in stock
	}
	// things that can be added later:  wholeSalePrice, retailPrice, foodDescription... 
	
	public int getItemKey() {
		return itemKey;
	}
	
	public String getItemName() {
		return itemName; 
	}
	
	public double getItemPrice() {
		return itemPrice; 
	}
	
	public double getItemCalories() {
		return itemCalories; 
	}
	
	public int getItemAmountInStock() {
		return itemAmountInStock; 
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemCalories(int itemCalories) {
		this.itemCalories = itemCalories;
	}

	public void setItemAmountInStock(int itemAmountInStock) {
		this.itemAmountInStock = itemAmountInStock;
	}
	
	
	
}
