package io.github.ryancarignan;

/*
// main game loop
Game
----------------------------------------
display: Display
gameOver: boolean
score: int
speed: int
time: int
active: Tetrimino
ghost: Tetronimo
next: Tetrimino
board: Block[BOARD_WIDTH][BOARD_HEIGHT]
----------------------------------------
startGame()
endGame()
getNext()
getGhost()
clearLines(from: int, to: int)
*/

public class Game {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 40;

    // private final Display display;
    private boolean gameOver;
    private int score;
    private int level;
    private int time;
    private Tetronimo active;
    private Tetronimo next;
    private Tetronimo ghost;
    private Block block[][];

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
