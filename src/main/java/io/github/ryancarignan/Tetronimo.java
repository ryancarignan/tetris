package io.github.ryancarignan;

import com.googlecode.lanterna.TextColor;

public class Tetronimo {
    public static final Tetronimo I = new Tetronimo(new Block[]{
        new Block(0, 0, TextColor.ANSI.BLUE),                 //
        new Block(1, 0, TextColor.ANSI.BLUE),                 // [][][][]
        new Block(2, 0, TextColor.ANSI.BLUE),                 //
        new Block(3, 0, TextColor.ANSI.BLUE)                  //
    });
    public static final Tetronimo J = new Tetronimo(new Block[]{
        new Block(0, 0, TextColor.ANSI.RED),                 //
        new Block(1, 0, TextColor.ANSI.RED),                 // [][][]
        new Block(2, 0, TextColor.ANSI.RED),                 //     []
        new Block(2, 1, TextColor.ANSI.RED)                  //
    });
    public static final Tetronimo L = new Tetronimo(new Block[]{
        new Block(0, 0, TextColor.ANSI.GREEN),                 //
        new Block(1, 0, TextColor.ANSI.GREEN),                 // [][][]
        new Block(2, 0, TextColor.ANSI.GREEN),                 // []
        new Block(0, 1, TextColor.ANSI.GREEN)                  //
    });
    public static final Tetronimo O = new Tetronimo(new Block[]{
        new Block(0, 0, TextColor.ANSI.MAGENTA),                 //
        new Block(1, 0, TextColor.ANSI.MAGENTA),                 // [][]
        new Block(0, 1, TextColor.ANSI.MAGENTA),                 // [][]
        new Block(1, 1, TextColor.ANSI.MAGENTA)                  //
    });
    public static final Tetronimo S = new Tetronimo(new Block[]{
        new Block(1, 0, TextColor.ANSI.CYAN),                 //
        new Block(2, 0, TextColor.ANSI.CYAN),                 //   [][]
        new Block(0, 1, TextColor.ANSI.CYAN),                 // [][]
        new Block(1, 1, TextColor.ANSI.CYAN)                  //
    });
    public static final Tetronimo T = new Tetronimo(new Block[]{
        new Block(0, 0, TextColor.ANSI.YELLOW),                 //
        new Block(1, 0, TextColor.ANSI.YELLOW),                 // [][][]
        new Block(2, 0, TextColor.ANSI.YELLOW),                 //   []
        new Block(1, 1, TextColor.ANSI.YELLOW)                  //
    });
    public static final Tetronimo Z = new Tetronimo(new Block[]{
        new Block(0, 0, TextColor.ANSI.WHITE),                 //
        new Block(1, 0, TextColor.ANSI.WHITE),                 // [][]
        new Block(1, 1, TextColor.ANSI.WHITE),                 //   [][]
        new Block(2, 1, TextColor.ANSI.WHITE)                  //
    });

    private Block blocks[];
    
    public Tetronimo(Block blocks[]) {
        this.blocks = blocks;
    }

    public void place(int x, int y) {
        int xDiff = x - blocks[0].x;
        int yDiff = y - blocks[0].y;

        for(Block block : blocks) {
            block.x += xDiff;
            block.y += yDiff;
        }
    }

    public void move(int x, int y) {
        for (Block block : blocks) {
            block.x += x;
            block.y += y;
        }
    }

    public void setColor(TextColor color) {
        for (Block block : blocks) {
            block.color = color;
        }
    }

    public Tetronimo getCopy() {
        Block copiedBlocks[] = getBlocks();

        return new Tetronimo(copiedBlocks);
    }

    public Block[] getBlocks() {
        Block copiedBlocks[] = new Block[4];

        for (int i = 0; i < blocks.length; i++) {
            copiedBlocks[i] = blocks[i].getCopy();
        }

        return copiedBlocks;
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
