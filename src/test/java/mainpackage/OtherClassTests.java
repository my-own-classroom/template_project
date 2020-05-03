package mainpackage;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for otherClass.
 *
 */

public class OtherClassTests {

    @Test
    public void testOK() {
        OtherClass otherClass = new OtherClass();
        assertEquals(otherClass.substring("abcde", 1, 2), "b");
    }

    @Test
    public void testreverse() {
        OtherClass otherClass = new OtherClass();
        assertEquals(otherClass.substring("abcde", 2, 1), "b");
    }

    @Test
    public void testnull() {
        OtherClass otherClass = new OtherClass();
        assertEquals(otherClass.substring("abcde", -1, 1), "");
    }

    @Test
    public void testempty() {
        OtherClass otherClass = new OtherClass();
        assertEquals(otherClass.substring("", 0, 1), "");
    }
}
