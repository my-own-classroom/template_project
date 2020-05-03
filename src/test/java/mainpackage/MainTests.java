package mainpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests for Main.
 *
 */

public class MainTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testOK() {
        Main.main("abcd 1 2".split(" "));
        assertEquals("b\n", outContent.toString());
    }

    @Test
    public void testnull() {
        Main.main("abcd -1 2".split(" "));
        assertEquals("\n", outContent.toString());
    }
}
