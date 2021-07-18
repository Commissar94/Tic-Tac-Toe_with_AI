package tictactoe.players;

import tictactoe.Grid;

public class HumanPlayer extends Player {

    public HumanPlayer(boolean isHePlayingForX) {
        this.isHePlayingForX = isHePlayingForX;
    }

    public void humanPlayerMove(int x, int y, Grid ourGrid) {
        char[][] grid = ourGrid.getGrid();

        if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
            if (grid[x - 1][y - 1] == ' ') {
                grid[x - 1][y - 1] = this.isHePlayingForX ? 'X' : 'O';
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
        }
    }
}