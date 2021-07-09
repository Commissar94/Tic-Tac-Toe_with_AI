package tictactoe;

import java.util.Random;

public class AI {

    public void aiEasyMove(Grid ourGrid) {
        char[][] grid = ourGrid.getGrid();

        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int x = random.nextInt(3) + 1;
        int y = random.nextInt(3) + 1;
        boolean moveSet = false;

        while (!moveSet) {

            if (grid[x - 1][y - 1] == ' ' && grid[x - 1][y - 1] != 'X' && grid[x - 1][y - 1] != 'O') {
                grid[x - 1][y - 1] = 'O';
                moveSet = true;
            } else if (grid[x - 1][y - 1] == 'X' || grid[x - 1][y - 1] == 'O') {
                x = random.nextInt(3) + 1;
                y = random.nextInt(3) + 1;
            }
        }
    }
}
