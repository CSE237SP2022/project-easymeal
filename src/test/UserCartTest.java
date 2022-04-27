package test;

import menu.MenuItem;
import cart.UserCart;
import main.RunMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

class UserCartTest {
    private MenuItem item1, item2, item3;
    private UserCart cart;
    @BeforeEach
    void setUp() {
        item1 = new MenuItem(1, "tacos", 3.55, 156, 100);
        item2 = new MenuItem(2, "sushi", 9.99, 200, 1);
        item3 = new MenuItem(3, "pizza", 2.00, 389, 3);
        cart = new UserCart();
    }

    @Test
    void testGetTotalItems() {
        cart.addToCart(item1, 1);
        assertEquals(1, cart.getTotalItems(), 0.05);
    }

    @Test
    // Confirms item was not added, along with checking cart and item stock hasn't changed
    void testAddToCartInsufficientStock() {
        assertFalse(cart.addToCart(item2, 2));
        assertEquals(0, cart.getTotalItems(), 0.05);
        assertEquals(1, item2.getItemAmountInStock(), 0.05);
    }

    @Test
    void testAddToCartNewItem() {
        assertTrue(cart.addToCart(item3, 3));
        assertEquals(3, cart.getTotalItems(), 0.05);
        assertEquals(0, item3.getItemAmountInStock(), 0.05);
    }

    @Test
    void testAddToCartExistingItem() {
        cart.addToCart(item3, 1);
        assertTrue(cart.addToCart(item3, 1));
        assertEquals(2, cart.getTotalItems(), 0.05);
        assertEquals(1, item3.getItemAmountInStock(), 0.05);
    }

    @Test
    void testRemoveFromCartInvalidQuantity() {
        cart.addToCart(item1, 1);
        assertFalse(cart.removeFromCart(item1, 2));
        assertFalse(cart.removeFromCart(item1, -1));
    }

    @Test
    void testRemoveFromCartValidQuantity() {
        cart.addToCart(item1, 20);
        assertTrue(cart.removeFromCart(item1, 10));
        assertEquals(10, cart.getTotalItems(), 0.05);
        assertEquals(90, item1.getItemAmountInStock(), 0.05);
    }

    @Test
    void testGetTotalCartPrice() {
        cart.addToCart(item3, 3);
        cart.addToCart(item2, 1);
        assertEquals(15.99, cart.getTotalCartPrice(), 0.05);
    }

    @Test
    void testGetTotalCalories() {
        cart.addToCart(item3, 3);
        cart.addToCart(item2, 1);
        assertEquals(1367, cart.getTotalCalories(), 0.05);
    }
    
    @Test
    // Choose a 15% tip, otherwise will fail
    void getFinalCartPrice() {
        cart.addToCart(item3, 3);
        cart.addToCart(item2, 1);
        assertEquals(20.21, cart.getFinalCartPrice(), 0.05);
    }
}
