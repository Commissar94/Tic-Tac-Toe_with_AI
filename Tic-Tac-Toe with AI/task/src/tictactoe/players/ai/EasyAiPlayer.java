package tictactoe.players.ai;

import tictactoe.Grid;

import java.util.Random;

public class EasyAiPlayer extends AiPlayer {

    public EasyAiPlayer(boolean isHePlayingForX) {
        super(isHePlayingForX);
    }

    @Override
    public void makeMoveNotify() {
        System.out.println("Making move level \"easy\"");
    }

    public void aiEasyMove(Grid ourGrid) {
        char[][] grid = ourGrid.getGrid();

        Random random = new Random();
        int x = random.nextInt(3) + 1;
        int y = random.nextInt(3) + 1;
        boolean moveSet = false;
        if (!this.isHePlayingForX) {
            while (!moveSet) {

                if (grid[x - 1][y - 1] == ' ' && grid[x - 1][y - 1] != 'X' && grid[x - 1][y - 1] != 'O') {
                    grid[x - 1][y - 1] = 'O';
                    moveSet = true;
                } else if (grid[x - 1][y - 1] == 'X' || grid[x - 1][y - 1] == 'O') {
                    x = random.nextInt(3) + 1;
                    y = random.nextInt(3) + 1;
                }
            }
        } else {
            while (!moveSet) {

                if (grid[x - 1][y - 1] == ' ' && grid[x - 1][y - 1] != 'X' && grid[x - 1][y - 1] != 'O') {
                    grid[x - 1][y - 1] = 'X';
                    moveSet = true;
                } else if (grid[x - 1][y - 1] == 'X' || grid[x - 1][y - 1] == 'O') {
                    x = random.nextInt(3) + 1;
                    y = random.nextInt(3) + 1;
                }
            }
        }
    }

}
