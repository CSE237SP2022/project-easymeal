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
	private final Scanner mealChoice;
	private final UserCart cart;
	private final ArrayList<MenuItem> menu;
	private static int largestPossibleInput;
	private int menuChoice;
	public RunMenu() {
    	mealChoice = new Scanner(System.in);
    	cart = new UserCart();
    	menu = new ArrayList<>();
    	generateMenuItems();
	}
	public static void main(String[] args) {
		RunMenu foodItemMenu = new RunMenu();
		System.out.println("\nWelcome to EasyMeal!\n");
		foodItemMenu.printMenuItems();
		foodItemMenu.processOrder();
	}
	private void generateMenuItems(){
		MenuItem taco = new MenuItem(1, "Taco", 4.25, 153, 12);
		MenuItem pizza = new MenuItem(2, "Pizza", 5.25, 357, 6);
		MenuItem corn = new MenuItem(3, "Corn", 7.25, 97, 3);
		MenuItem salad = new MenuItem(4, "Salad", 5.71, 97, 3);
		menu.add(taco);
		menu.add(pizza);
		menu.add(corn);
		menu.add(salad);
	}
	private void printMenuItems(){
    	System.out.println("Menu: "); 
    	for (MenuItem item: menu) {
    		System.out.println(item.getItemKey() + ". " + item.getItemName() + " $" + item.getItemPrice());
    	}
    	System.out.println("Press 0 to exit the menu.");
	}
	private void processOrder() {
		String yesOrNo;
		// choose menu
		System.out.println("Select menu item number or 0 to exit:");
		largestPossibleInput = menu.size();
		menuChoice = this.getUserIntInput();

		// choose quantity
		System.out.println("Select its quantity or 0 to exit the menu: ");
		largestPossibleInput = menu.get(menuChoice-1).getItemAmountInStock();
		int quantityChoice = this.getUserIntInput();

		if (cart.addToCart(menu.get(menuChoice-1), quantityChoice)) {
			// print out order
			System.out.println(menu.get(menuChoice-1).getItemName() + ", " + "$" + menu.get(menuChoice-1).getItemPrice() + ", "
					+ (int) menu.get(menuChoice-1).getItemCalories() + " calories. " + quantityChoice + " unit(s) added to cart.");
		} else { System.out.println("Error adding to cart"); }
		
		
		System.out.println("Would you like to order more food? (y/n): ");
		yesOrNo = getUserStringInputYesOrNo();  // this function make user enter inputs again if input is not string. 
		if (yesOrNo.equals("y")) {
			processOrder();
		} else if (yesOrNo.equals("n")) {
			System.out.println("Order total: $" + String.format("%.2f", cart.getFinalCartPrice()));
			System.out.println("Your order is processed.");
		}
	}
	private String getUserStringInputYesOrNo() {
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
