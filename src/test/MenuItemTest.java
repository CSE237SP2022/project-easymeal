package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import menu.MenuItem;

class MenuItemTest {
	private MenuItem item;
	@BeforeEach
	void setup() {  // put first line in each test in setup. 
		item = new MenuItem("tacos", 3.55, 156, 100); // name, price, calories, amount in stock 
	}
	
	// getter tests
	@Test
	void testGetItemName() {
		String itemName = item.getItemName();
		assertTrue("tacos".equals(itemName)); 
	}
	@Test 
	void testGetItemPrice() {
		double itemPrice = item.getItemPrice(); 
		assertEquals(3.55, itemPrice, 0.05); 
	}
	@Test 
	void testGetItemCalories() {
		double itemCalories = item.getItemCalories(); 
		assertEquals(156, itemCalories, 0.05); 
	}
	@Test
	void testGetItemAmountInStock() {
		int itemAmountInStock = item.getItemAmountInStock(); 
		assertTrue(100 == itemAmountInStock); 
	}
	
	// setter tests
	@Test
	void testSetItemPrice() {
	    item.setItemPrice(5.00);
	    assertEquals(5.00, item.getItemPrice());
	}
	@Test
	void testSetItemCalories() {
		item.setItemCalories(162);
		assertEquals(162, item.getItemCalories());
	}
	@Test
	void testSetItemAmountInStock() {
		item.setItemAmountInStock(99);
		assertEquals(99, item.getItemAmountInStock()); 
	}

}
