package tictactoe;

public class Player {

    public void playerMove(int x, int y, Grid oureGrid) { //добавить чар на ввод, чтобы понять кем играет игрок
        char[][] grid = oureGrid.getGrid();

        if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
            if (grid[x - 1][y - 1] == ' ') {
                grid[x - 1][y - 1] = 'X';
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
        }
    }
}
