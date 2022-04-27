package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import main.RunMenu;

class RunMenuTest {
    private RunMenu menu;
    @Test
    void testYInput() {
        InputStream steamInput = new ByteArrayInputStream("y".getBytes(StandardCharsets.UTF_8));
        Scanner mealChoice = new Scanner(steamInput);
        menu = new RunMenu(mealChoice, new cart.UserCart(), new ArrayList<menu.MenuItem>());
        assertEquals("y", this.menu.getUserStringInputYesOrNo());
    }

    @Test
    void testNInput() {
        InputStream steamInput = new ByteArrayInputStream("n".getBytes(StandardCharsets.UTF_8));
        Scanner mealChoice = new Scanner(steamInput);
        menu = new RunMenu(mealChoice, new cart.UserCart(), new ArrayList<menu.MenuItem>());
        assertEquals("n", this.menu.getUserStringInputYesOrNo());
    }

    @Test
    void testWrongThenCorrect(){
        InputStream steamInput = new ByteArrayInputStream("c\nn".getBytes(StandardCharsets.UTF_8));
        Scanner mealChoice = new Scanner(steamInput);
        menu = new RunMenu(mealChoice, new cart.UserCart(), new ArrayList<menu.MenuItem>());
        assertEquals("n", this.menu.getUserStringInputYesOrNo());
    }
}
