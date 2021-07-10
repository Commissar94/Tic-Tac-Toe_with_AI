package tictactoe;

public class Rules {
    public boolean checkWinX(Grid ourGrid) {
        char[][] grid = ourGrid.getGrid();
        for (int i = 0; i < 3; i++) {
            //проверяем на ситуацию победы по горизонталям и вертикалям
            if (grid[i][0] == 'X' && grid[i][1] == 'X' && grid[i][2] == 'X') {
                System.out.println("X wins");
                return true;
            } else if (grid[0][i] == 'X' && grid[1][i] == 'X' && grid[2][i] == 'X') {
                System.out.println("X wins");
                return true;
            }
        }
        //если победы на прямых линиях не произошло, то смотрим диагонали
        if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
            System.out.println("X wins");
            return true;
        } else if (grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == 'X') {
            System.out.println("X wins");
            return true;
        }
        return false;
    }

    public boolean checkWinO(Grid ourGrid) {
        char[][] grid = ourGrid.getGrid();
        for (int i = 0; i < 3; i++) {
            //проверяем на ситуацию победы по горизонталям и вертикалям
            if (grid[i][0] == 'O' && grid[i][1] == 'O' && grid[i][2] == 'O') {
                System.out.println("O wins");
                return true;
            } else if (grid[0][i] == 'O' && grid[1][i] == 'O' && grid[2][i] == 'O') {
                System.out.println("O wins");
                return true;
            }
        }
        //если победы на прямых линиях не произошло, то смотрим диагонали
        if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
            System.out.println("O wins");
            return true;
        } else if (grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == 'O') {
            System.out.println("O wins");
            return true;
        }
        return false;
    }
}