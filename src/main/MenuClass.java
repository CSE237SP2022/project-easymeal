package main;

import cart.UserCart;
import menu.MenuItem;

import java.util.ArrayList;

public class MenuClass {

    private UserCart cart = null;
    private ArrayList<MenuItem> menu = null;

    public MenuClass() {
        cart = new UserCart();
        menu = new ArrayList<MenuItem>();
        generateMenuItems();
    }

    private void generateMenuItems(){
        MenuItem taco = new MenuItem("Taco", 4.25, 153, 12);
        MenuItem pizza = new MenuItem("Pizza", 5.25, 357, 6);
        MenuItem corn = new MenuItem("Corn", 7.25, 97, 3);
        menu.add(taco);
        menu.add(pizza);
        menu.add(corn);
    }

    public void printMenu(){
        for (MenuItem item : menu){
            System.out.println(item.getItemName() + " " + item.getItemPrice() + " " + item.getItemAmountInStock());
        }
    } // TODO: make this not long and ugly

    //    private MenuItem selectMenuItem(){
//
//    }
//
//    private int selectQuantity(MenuItem item){
//
//    }
}
