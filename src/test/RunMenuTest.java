package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import main.RunMenu;

class RunMenuTest {
    private RunMenu menu;
    @BeforeEach
    void setup() {
        menu = new RunMenu();
    }

    @Test
    void testYInput() {
        ByteArrayInputStream steamInput = new ByteArrayInputStream("y");
        System.setIn(streamInput);

        assertTrue(menu.getUserStringInputYesOrNo() == "y");
    }

    @Test
    void testNInput() {
        ByteArrayInputStream steamInput = new ByteArrayInputStream("y");
        System.setIn(streamInput);

        assertTrue(menu.getUserStringInputYesOrNo() == "n");
    }



}
