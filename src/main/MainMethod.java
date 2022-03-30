package main;

import java.util.Scanner;
//import menu.MenuItem;
//import cart.UserCart;

public class MainMethod {
  public static void main(String args[]) {
    System.out.println("Choose from the following menu items:");
    System.out.println("1. tacos");
    System.out.println("2. burrito");
    System.out.println("3. quesadilla");

Scanner scanchoice = new Scanner(System.in);
System.out.println();

int choice = 0;

    while(choice < 1 || choice > 3){

            System.out.println("Select \"1\", \"2\", \"3\"");
            if(scanchoice.hasNextInt())
            choice = scanchoice.nextInt();

    }

     switch(choice){
        case 1:
           System.out.println("tacos, $3.55, 156 calories. Would you like to place order?");

           break;
        case 2:
           System.out.println("burrito, $4.20, 206 calories. Would you like to place order?");
           break;
        case 3:
           System.out.println("quesadilla, $2.95, 170 calories. Would you like to place order?");
           break;
   }
  }
}
