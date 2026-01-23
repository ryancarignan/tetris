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
 * Unit tests for Tetronimo class.
 */
public class TetronimoTest {
    /**
     * Test format:
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }    

    @Test
    public void makeOne() {
        Block b1 = new Block(0, 0, TextColor.ANSI.BLUE);
        Block b2 = new Block(1, 0, TextColor.ANSI.RED);
        Block b3 = new Block(1, 1, TextColor.ANSI.YELLOW);
        Block b4 = new Block(2, 1, TextColor.ANSI.GREEN);

        Block bArr1[] = new Block[]{b1, b2, b3, b4};

        Tetronimo t1 = new Tetronimo(bArr1, b3);

        assertNotNull(t1);

        Block t1Blocks[] = t1.getBlocks();
        for (int i = 0; i < bArr1.length; i++) {
            assertEquals(bArr1[i].x, t1Blocks[i].x);
            assertEquals(bArr1[i].y, t1Blocks[i].y);
            assertEquals(bArr1[i].color, t1Blocks[i].color);
        }

        Block t1Blocks2[] = t1.getBlocks();
        t1Blocks[0].x = 400;
        assertNotEquals(t1Blocks[0].x, t1Blocks2[0].x);

        t1Blocks[0].color = TextColor.ANSI.CYAN;
        assertFalse(t1Blocks[0].color.equals(t1Blocks2[0].color));
    }

    @Test
    public void makeOneCopy() {
        Tetronimo t1 = Tetronimo.L.getCopy();

        assertNotSame(Tetronimo.L, t1);
    }

    @Test
    public void makeTwoCopies() {
        Tetronimo t1 = Tetronimo.J.getCopy();
        Tetronimo t2 = Tetronimo.J.getCopy();

        assertNotSame(t1, t2);
    }

    @Test
    public void place() {
        Tetronimo t1 = Tetronimo.Z.getCopy();
        t1.place(3, 4);
        Block t1Blocks[] = t1.getBlocks();
        Block t1Pivot = t1.getPivot();
        
        assertEquals(t1Blocks[0].x, 3);
        assertEquals(t1Blocks[0].y, 4);

        assertEquals(t1Blocks[1].x, 4);
        assertEquals(t1Blocks[1].y, 4);

        assertEquals(t1Blocks[2].x, 4);
        assertEquals(t1Blocks[2].y, 5);

        assertEquals(t1Blocks[3].x, 5);
        assertEquals(t1Blocks[3].y, 5);

        assertEquals(t1Pivot.x, 4);
        assertEquals(t1Pivot.y, 5);
    }

    @Test
    public void move() {
        Tetronimo t1 = Tetronimo.Z.getCopy();
        t1.place(3, 4);
        t1.move(1, -2);
        Block t1Blocks[] = t1.getBlocks();
        Block t1Pivot = t1.getPivot();
        
        assertEquals(t1Blocks[0].x, 4);
        assertEquals(t1Blocks[0].y, 2);

        assertEquals(t1Blocks[1].x, 5);
        assertEquals(t1Blocks[1].y, 2);

        assertEquals(t1Blocks[2].x, 5);
        assertEquals(t1Blocks[2].y, 3);

        assertEquals(t1Blocks[3].x, 6);
        assertEquals(t1Blocks[3].y, 3);

        assertEquals(t1Pivot.x, 5);
        assertEquals(t1Pivot.y, 3);
    }

    @Test
    public void setColor() {
        Tetronimo t1 = Tetronimo.O.getCopy();
        Block t1ColorBlocks[] = t1.getBlocks();
        TextColor ogColor = t1ColorBlocks[0].color;
        t1.setColor(TextColor.ANSI.MAGENTA);
        Block t1Blocks[] = t1.getBlocks();
        Block t1Pivot = t1.getPivot();

        for (Block block : t1Blocks) {
            assertTrue(block.color.equals(ogColor));
        }
        assertTrue(t1Pivot.color.equals(ogColor));
    }

    @Test
    public void rotateClockwise() {
        Tetronimo t1 = Tetronimo.L.getCopy();
        t1.rotate(1);
        Block t1Blocks[] = t1.getBlocks();
        Block t1Pivot = t1.getPivot();

        assertEquals(t1Blocks[0].x, 1);
        assertEquals(t1Blocks[0].y, -1);

        assertEquals(t1Blocks[1].x, 1);
        assertEquals(t1Blocks[1].y, 0);

        assertEquals(t1Blocks[2].x, 1);
        assertEquals(t1Blocks[2].y, 1);

        assertEquals(t1Blocks[3].x, 0);
        assertEquals(t1Blocks[3].y, -1);

        assertEquals(t1Pivot.x, 1);
        assertEquals(t1Pivot.y, 0);
    }
    
    @Test
    public void rotateCounterClockwise() {
        Tetronimo t1 = Tetronimo.L.getCopy();
        t1.rotate(-1);
        Block t1Blocks[] = t1.getBlocks();
        Block t1Pivot = t1.getPivot();

        assertEquals(t1Blocks[0].x, 1);
        assertEquals(t1Blocks[0].y, 1);

        assertEquals(t1Blocks[1].x, 1);
        assertEquals(t1Blocks[1].y, 0);

        assertEquals(t1Blocks[2].x, 1);
        assertEquals(t1Blocks[2].y, -1);

        assertEquals(t1Blocks[3].x, 2);
        assertEquals(t1Blocks[3].y, 1);

        assertEquals(t1Pivot.x, 1);
        assertEquals(t1Pivot.y, 0);
    }
}
