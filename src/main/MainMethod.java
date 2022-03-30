package main;

import java.util.Scanner;
//import menu.MenuItem;
//import cart.UserCart;

public class MainMethod {
  public static void main(String args[]) {
    System.out.println("Choose from the following menu items:");
    System.out.println("1. tacos");
    System.out.println("2. sushi");
    System.out.println("3. pizza");

Scanner mealChoice = new Scanner(System.in);
System.out.println();

int choice = 0;

    while(choice < 1 || choice > 3){

            System.out.println("Select \"1\", \"2\", \"3\"");
            if(mealChoice.hasNextInt())
            choice = mealChoice.nextInt();

    }



     switch(choice){
        case 1:
           System.out.println("tacos, $3.55, 156 calories. 1 unit added to cart.");
           System.out.println();
           break;
        case 2:
           System.out.println("sushi, $9.99, 200 calories. 1 unit added to cart.");
           System.out.println();
           break;
        case 3:
           System.out.println("pizza, $2.00, 389 calories. 1 unit added to cart.");
           System.out.println();
           break;
   }
  }
}
