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
        MenuItem taco = new MenuItem(1, "Taco", 4.25, 153, 12);
        MenuItem pizza = new MenuItem(2, "Pizza", 5.25, 357, 6);
        MenuItem corn = new MenuItem(3, "Corn", 7.25, 97, 3);
        MenuItem salad = new MenuItem(4, "Salad", 5.71, 97, 3); 
        menu.add(taco);
        menu.add(pizza);
        menu.add(corn);
        menu.add(salad);
    }

    
    
    
    
    
    
    
    // getter 
   
    public int getMenuLength() {
    	return menu.size(); 
    }
    public ArrayList <MenuItem> getMenuArrayList() {
    	return menu; 
    }

    // TODO: make this not long and ugly

    //    private MenuItem selectMenuItem(){
//
//    }
//
//    private int selectQuantity(MenuItem item){
//
//    }
}
