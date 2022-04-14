package main;

import java.util.ArrayList;
import java.util.Scanner;

import cart.UserCart;
import menu.MenuItem;

public class LaunchMenu {
	private final Scanner mealChoice;
    private final UserCart cart;
    private final ArrayList<MenuItem> menu;
	private int quantity = 0;
	private int choice;
	private String yesOrNo;
    
    public LaunchMenu() {
    	mealChoice = new Scanner(System.in);
    	cart = new UserCart();
    	menu = new ArrayList<MenuItem>();
    	generateMenuItems();
    }

	public static void main(String[] args) {
		LaunchMenu foodItemMenu = new LaunchMenu();
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
		selectValidChoice();
		selectValidQuantity();

		System.out.println(menu.get(choice).getItemName()+", "
				+ "$" + menu.get(choice).getItemPrice() + ", "
				+ (int) menu.get(choice).getItemCalories() + " calories. "
				+ quantity + " unit(s) added to cart.");
		cart.addToCart(menu.get(choice), quantity);

		selectYesNo();

		if (yesOrNo.equals("y")) { processOrder(); }
		else {
			System.out.println("Order total: $" + String.format("%.2f", cart.getFinalCartPrice()));
			//processTip();
			System.out.println("Your order is processed.");
		}
	}

	private void processTip() {
		String yesOrNoTip; 
		yesOrNoTip = mealChoice.nextLine(); 
		System.out.println("Would you like to add a tip? (y/n)"); 
		if(yesOrNoTip.equals("y")) {
			System.out.println("How much would you like to tip? [Ex. type '15' as 15%]");
			processOrder();
			System.out.println("Would you like to order more food? (y/n): "); 
			yesOrNoTip = mealChoice.nextLine(); 
		}
		else if (yesOrNoTip.equals("n")) {
			// tip function goes here.
			System.out.println("Your order is processed."); 
			
		}
		else {
			System.out.println("Please enter a valid input."); 
		}
	}

	private void promptValidInt() {
		while (!mealChoice.hasNextInt()) {
			System.out.println("Please enter an integer");
			mealChoice.next();
		}
	}

	// choose menu
	private void selectValidChoice() {
		System.out.println("Select menu item number:");
		promptValidInt();
		choice = mealChoice.nextInt();
		while (choice < 1 || choice > menu.size()) {
			System.out.println("Please enter a valid menu item number or 0 to exit the menu");
			promptValidInt();
			choice = mealChoice.nextInt();
			if (choice == 0) {
				System.out.println("Leaving menu successful");
				System.exit(0);
			}
		}
		choice -= 1;
	}

	// choose quantity
	private void selectValidQuantity() {
		System.out.println("Select its quantity: ");
		promptValidInt();
		quantity = mealChoice.nextInt();
		while (quantity < 1) {
			System.out.println("Invalid quantity\nPlease try again");
			promptValidInt();
			quantity = mealChoice.nextInt();
		}
		while (quantity > menu.get(choice).getItemAmountInStock()) {
			System.out.println("There is not enough item left in stock\nPlease choose a lower quantity");
			promptValidInt();
			quantity = mealChoice.nextInt();
		}
	}

	private void selectYesNo() {
		System.out.println("Would you like to order more food? (y/n): ");
		yesOrNo = mealChoice.next();
		while (!yesOrNo.equals("y") && !yesOrNo.equals("n")) {
			System.out.println("Please enter y or n");
			yesOrNo = mealChoice.next();
		}
	}
}
