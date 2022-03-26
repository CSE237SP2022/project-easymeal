package menu;


public class MenuItem {
	private String itemName; 
	private double itemPrice;
	private int itemCalories;
	private int itemAmountInStock; 
	
	public MenuItem(String itemName, double itemPrice, int itemCalories, int itemAmountInStock) {
		this.itemName = itemName;
		this.itemPrice = itemPrice; 
		this.itemCalories = itemCalories; 
		this.itemAmountInStock = itemAmountInStock; // quantity of items currently in stock
	}
	// things that can be added later:  wholeSalePrice, retailPrice, foodDescription... 
	
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

//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}

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
