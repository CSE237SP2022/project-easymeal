package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cart.UserCart;
import menu.MenuItem;

/**
 * Creates and runs the menu
 */
public class RunMenu {
	protected final Scanner mealChoice;
	private final UserCart cart;
	private final ArrayList<MenuItem> menu;
	private static int largestPossibleInput;
	private int menuChoice;
	private int menuQuantity;
	public RunMenu() {
    	mealChoice = new Scanner(System.in);
    	cart = new UserCart();
    	menu = new ArrayList<>();
    	generateMenuItems();
	}

	public RunMenu(Scanner scannerVar, UserCart cartVal, ArrayList<MenuItem> menuVal) {
		mealChoice = scannerVar;
		cart = cartVal;
		menu = menuVal;
		generateMenuItems();
	}
	public static void main(String[] args) {
		RunMenu foodItemMenu = new RunMenu();
		System.out.println("\nWelcome to EasyMeal!\n");
		foodItemMenu.printMenuItems();
		foodItemMenu.processOrder();
	}
	private void generateMenuItems(){
		MenuItem classicBurger = new MenuItem(1, "Classic Burger", 9.99, 1120, 25);
		MenuItem cheeseburger = new MenuItem(2, "Cheeseburger", 10.99, 1220, 20);
		MenuItem baconCheeseburger = new MenuItem(3, "Bacon Cheeseburger", 11.49, 1310, 12);
		MenuItem bonelessWings = new MenuItem(4, "Boneless Wings (10 pcs)", 9.49, 660, 14);
		MenuItem mozzarellaSticks = new MenuItem(5, "Mozzarella Sticks (10 pcs)", 8.29, 880, 10);
		MenuItem caesarSalad = new MenuItem(6, "Caesar Salad", 4.79, 220, 30);
		MenuItem soda = new MenuItem(7, "Soda (Coca-Cola)", 1.99, 150, 18);
		MenuItem beer = new MenuItem(8, "Beer (Coors Light)", 2.99, 100, 8);
		
		menu.add(classicBurger);
		menu.add(cheeseburger);
		menu.add(baconCheeseburger);
		menu.add(bonelessWings);
		menu.add(mozzarellaSticks);
		menu.add(caesarSalad);
		menu.add(soda);
		menu.add(beer);
	}
	private void printMenuItems(){
    	System.out.println("Menu: "); 
    	for (MenuItem item: menu) {
    		System.out.println(item.getItemKey() + ". " + item.getItemName() + " $" + item.getItemPrice());
    	}
    	System.out.println("Press 0 to exit the menu.");
    }
    
	private void processOrder() {
		chooseItem();
		chooseQuantity(); 
		printItemAndQuantity(); 
	}
	
	private void chooseItem() {
		String yesOrNo;
		System.out.println("Select menu item number or 0 to exit:");
		largestPossibleInput = menu.size();
		menuChoice = this.getUserIntInput();
	}
	
	private void chooseQuantity() {
		System.out.println("Select its quantity or 0 to exit the menu: ");
		largestPossibleInput = menu.get(menuChoice - 1).getItemAmountInStock();
		menuQuantity= this.getUserIntInput();
	}
	
	private void printItemAndQuantity() {
		if (cart.addToCart(menu.get(menuChoice-1), menuQuantity)) {
			System.out.println(menu.get(menuChoice-1).getItemName() + ", " + "$" + menu.get(menuChoice-1).getItemPrice() + ", "
					+ (int) menu.get(menuChoice-1).getItemCalories() + " calories. " + menuQuantity + " unit(s) added to cart.");
			System.out.println("Would you like to order more food? (y/n): ");
			String yesOrNo = getUserStringInputYesOrNo();  
			if (yesOrNo.equals("y")) {
				chooseItem();
				chooseQuantity(); 
				printItemAndQuantity(); 
			} 
			else if (yesOrNo.equals("n")) {
				printOrder(); 
			}
		} 
		else { 
			System.out.println("Error adding to cart"); 
		}
	}
	
	private void printOrder() {
		System.out.println("Order total: $" + String.format("%.2f", cart.getFinalCartPrice()));
		System.out.println("Your order is processed.");
	}
	
	
	
	public String getUserStringInputYesOrNo() {
		if (mealChoice.hasNextLine()) {
			String choice = mealChoice.next(); 
			if (!choice.equals("y") && !choice.equals("n")) {
				System.out.println("Please enter y or n");
				return getUserStringInputYesOrNo(); 
			}
			else {
				return choice; 
			}
		}
		else {
			System.out.println("Please enter a valid input");
			return getUserStringInputYesOrNo(); 
		}
	}

	/**
	 * @return User's menu option number
	 */

	private int getUserIntInput() {
		try {
			int choice = mealChoice.nextInt();
			if (choice == 0) {
				System.out.println("Leaving menu successful!");
				System.exit(0);
				return -1;
			} else if (choice > 0 && choice <= largestPossibleInput) { return choice; }
			if (menuChoice == 0) { System.out.println("Please enter valid input!"); }
			else if (choice > menu.get(menuChoice-1).getItemAmountInStock()) {
				System.out.println("Not enough in stock, try again!");
			}
			else { System.out.println("Please enter valid input"); }
			return getUserIntInput();
		}
		catch (InputMismatchException e) {
			System.out.println("Please enter an integer");
			mealChoice.next();
			return getUserIntInput(); 
		}
	}
}
