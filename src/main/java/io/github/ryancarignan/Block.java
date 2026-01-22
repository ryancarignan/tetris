package io.github.ryancarignan;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.Factory;

public class Block {
    public int x;
    public int y;
    public TextColor color;

    public Block(int x, int y, TextColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Block getCopy() {
        return new Block(x, y, color);
    }
}
