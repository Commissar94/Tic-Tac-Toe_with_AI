package tictactoe;

public class Grid {

    private char[][] grid = new char[3][3];

    public void generateGrid() {  //заполняем пустыми значениями
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.grid[i][j] = ' ';
            }
        }
    }

    public void showGrid() {
        System.out.println("---------");
        System.out.println("| " + this.grid[0][0] + " " + this.grid[0][1] + " " + this.grid[0][2] + " |");
        System.out.println("| " + this.grid[1][0] + " " + this.grid[1][1] + " " + this.grid[1][2] + " |");
        System.out.println("| " + this.grid[2][0] + " " + this.grid[2][1] + " " + this.grid[2][2] + " |");
        System.out.println("---------");
    }

    public int findSpacesInGrid() {
        int spaces = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.grid[i][j] == ' ') {
                    spaces++;
                }
            }
        }
        return spaces;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }
}
