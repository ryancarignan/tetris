package io.github.ryancarignan;

import com.googlecode.lanterna.TextColor;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

/**
 * Unit tests for Block class.
 */
public class BlockTest {
    /**
     * Test format:
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }    

    @Test
    public void makeOne() {
        Block b1 = new Block(1, 2, TextColor.ANSI.BLUE);

        assertEquals(b1.x, 1);
        assertEquals(b1.y, 2);
        assertTrue(b1.color.equals(TextColor.ANSI.BLUE));
    }

    @Test
    public void changeOne() {
        Block b1 = new Block(1, 2, TextColor.ANSI.BLUE);
        b1.x = 3;
        b1.color = TextColor.ANSI.RED;

        assertEquals(b1.x, 3);
        assertEquals(b1.y, 2);
        assertTrue(b1.color.equals(TextColor.ANSI.RED));
    }

    @Test
    public void makeOneCopy() {
        Block b1 = new Block(1, 2, TextColor.ANSI.BLUE);

        Block b2 = b1.getCopy();

        assertNotNull(b2);
        assertNotSame(b1, b2);
    }

    @Test
    public void changeOneCopy() {
        Block b1 = new Block(1, 2, TextColor.ANSI.BLUE);

        Block b2 = b1.getCopy();

        b1.x = 3;
        b1.color = TextColor.ANSI.RED;

        assertNotEquals(b2.x, 3);
        assertEquals(b2.y, 2);
        assertFalse(b2.color.equals(TextColor.ANSI.RED));
    }
}
