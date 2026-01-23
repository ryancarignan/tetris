package io.github.ryancarignan;

import com.googlecode.lanterna.TextColor;

public class Tetronimo {

    // -----------------------------------------------------------------
    // ------------------------ STANDARD PIECES ------------------------
    // -----------------------------------------------------------------

    // [][][P[]
    //
    private static final TextColor I_COLOR = TextColor.ANSI.BLUE;
    private static final Block I_PIVOT = new Block(2, 0, I_COLOR);
    public static final Tetronimo I = new Tetronimo(new Block[]{
        new Block(0, 0, I_COLOR),
        new Block(1, 0, I_COLOR),
        I_PIVOT,
        new Block(3, 0, I_COLOR)
    }, I_PIVOT);

    // [][P[]
    //     []
    private static final TextColor J_COLOR = TextColor.ANSI.RED;
    private static final Block J_PIVOT = new Block(1, 0, J_COLOR);
    public static final Tetronimo J = new Tetronimo(new Block[]{
        new Block(0, 0, J_COLOR),
        J_PIVOT,
        new Block(2, 0, J_COLOR),
        new Block(2, 1, J_COLOR)
    }, J_PIVOT);

    // [][P[]
    // []
    private static final TextColor L_COLOR = TextColor.ANSI.GREEN;
    private static final Block L_PIVOT = new Block(1, 0, L_COLOR);
    public static final Tetronimo L = new Tetronimo(new Block[]{
        new Block(0, 0, L_COLOR),
        L_PIVOT,
        new Block(2, 0, L_COLOR),
        new Block(0, 1, L_COLOR)
    }, L_PIVOT);

    // [][P
    // [][]
    private static final TextColor O_COLOR = TextColor.ANSI.MAGENTA;
    private static final Block O_PIVOT = new Block(1, 0, O_COLOR);
    public static final Tetronimo O = new Tetronimo(new Block[]{
        new Block(0, 0, O_COLOR),
        O_PIVOT,
        new Block(0, 1, O_COLOR),
        new Block(1, 1, O_COLOR)
    }, O_PIVOT);

    //   [][]
    // [][P
    private static final TextColor S_COLOR = TextColor.ANSI.CYAN;
    private static final Block S_PIVOT = new Block(1, 1, S_COLOR);
    public static final Tetronimo S = new Tetronimo(new Block[]{
        new Block(1, 0, S_COLOR),
        new Block(2, 0, S_COLOR),
        new Block(0, 1, S_COLOR),
        S_PIVOT
    }, S_PIVOT);

    // [][P[]
    //   []
    private static final TextColor T_COLOR = TextColor.ANSI.YELLOW;
    private static final Block T_PIVOT = new Block(1, 0, T_COLOR);
    public static final Tetronimo T = new Tetronimo(new Block[]{
        new Block(0, 0, T_COLOR),
        T_PIVOT,
        new Block(2, 0, T_COLOR),
        new Block(1, 1, T_COLOR)
    }, T_PIVOT);

    // [][]
    //   [P[]
    private static final TextColor Z_COLOR = TextColor.ANSI.WHITE;
    private static final Block Z_PIVOT = new Block(1, 1, Z_COLOR);
    public static final Tetronimo Z = new Tetronimo(new Block[]{
        new Block(0, 0, Z_COLOR),
        new Block(1, 0, Z_COLOR),
        Z_PIVOT,
        new Block(2, 1, Z_COLOR)
    }, Z_PIVOT);

    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------

    private Block blocks[];
    private Block pivot;
    
    public Tetronimo(Block blocks[], Block pivot) {
        this.blocks = blocks;
        this.pivot = pivot;
    }

    public void place(int x, int y) {
        int xDiff = x - blocks[0].x;
        int yDiff = y - blocks[0].y;

        for(Block block : blocks) {
            block.x += xDiff;
            block.y += yDiff;
        }
        pivot.x += xDiff;
        pivot.y += yDiff;
    }

    public void move(int x, int y) {
        for (Block block : blocks) {
            block.x += x;
            block.y += y;
        }
        pivot.x += x;
        pivot.y += y;
    }

    public void setColor(TextColor color) {
        for (Block block : blocks) {
            block.color = color;
        }
    }

    public Tetronimo getCopy() {
        Block copiedBlocks[] = getBlocks();
        Block copyPivot = getPivot();

        return new Tetronimo(copiedBlocks, copyPivot);
    }

    public Block[] getBlocks() {
        Block copiedBlocks[] = new Block[4];

        for (int i = 0; i < blocks.length; i++) {
            copiedBlocks[i] = blocks[i].getCopy();
        }

        return copiedBlocks;
    }

    public Block getPivot() {
        return new Block(pivot.x, pivot.y, pivot.color);
    }

    public void rotate(int direction) {
        if (direction != 1 && direction != -1) {
            System.out.println("i will explode");
            System.out.println("Direction is " + direction);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // relation to pivot
            int xDiff = blocks[i].x - pivot.x;
            int yDiff = blocks[i].y - pivot.y;

            // swap x and y
            int temp = xDiff;
            xDiff = yDiff;
            yDiff = temp;

            // reverse x or y based on direction
            if (direction > 0)
                xDiff *= -1;
            else
                yDiff *= -1;

            // update block positions
            blocks[i].x = pivot.x + xDiff;
            blocks[i].y = pivot.y + yDiff;
        }
    }
}
/*
// a group of four blocks that move together
Tetrimino
----------------------------------------
blocks: Block[4]
----------------------------------------
move(x: int, y: int)
rotate()
*/
