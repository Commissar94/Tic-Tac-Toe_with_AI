package tictactoe;

import java.util.*;

class ticTacToe {

    private char[][] grid = new char[3][3];

    public void setGrid() {  //заполняем пустыми значениями
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

    public void playerMove(int x, int y) {
        if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
            if (this.grid[x - 1][y - 1] == ' ') {
                this.grid[x - 1][y - 1] = 'X';
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
        }
    }

    public boolean checkWinX() {
        for (int i = 0; i < 3; i++) {
            //проверяем на ситуацию победы по горизонталям и вертикалям
            if (this.grid[i][0] == 'X' && this.grid[i][1] == 'X' && this.grid[i][2] == 'X') {
                System.out.println("X wins");
                return true;
            } else if (this.grid[0][i] == 'X' && this.grid[1][i] == 'X' && this.grid[2][i] == 'X') {
                System.out.println("X wins");
                return true;
            }
        }
        //если победы на прямых линиях не произошло, то смотрим диагонали
        if (this.grid[0][0] == 'X' && this.grid[1][1] == 'X' && this.grid[2][2] == 'X') {
            System.out.println("X wins");
            return true;
        } else if (this.grid[2][0] == 'X' && this.grid[1][1] == 'X' && this.grid[0][2] == 'X') {
            System.out.println("X wins");
            return true;
        }
        return false;
    }

    public boolean checkWinO() {
        for (int i = 0; i < 3; i++) {
            //проверяем на ситуацию победы по горизонталям и вертикалям
            if (this.grid[i][0] == 'O' && this.grid[i][1] == 'O' && this.grid[i][2] == 'O') {
                System.out.println("O wins");
                return true;
            } else if (this.grid[0][i] == 'O' && this.grid[1][i] == 'O' && this.grid[2][i] == 'O') {
                System.out.println("O wins");
                return true;
            }
        }
        //если победы на прямых линиях не произошло, то смотрим диагонали
        if (this.grid[0][0] == 'O' && this.grid[1][1] == 'O' && this.grid[2][2] == 'O') {
            System.out.println("O wins");
            return true;
        } else if (this.grid[2][0] == 'O' && this.grid[1][1] == 'O' && this.grid[0][2] == 'O') {
            System.out.println("O wins");
            return true;
        }
        return false;
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

    public void aiEasyMove() {

        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int x = random.nextInt(3) + 1;
        int y = random.nextInt(3) + 1;
        boolean moveSet = false;

        while (!moveSet) {
            if (this.grid[x - 1][y - 1] == ' ' && this.grid[x - 1][y - 1] != 'X') {
                this.grid[x - 1][y - 1] = 'O';
                moveSet = true;
            } else if (this.grid[x - 1][y - 1] == 'X') {
                x = random.nextInt(3) + 1;
                y = random.nextInt(3) + 1;
            }
        }

    }
    
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ticTacToe t1 = new ticTacToe();
        t1.setGrid();
        t1.showGrid();
        do {
            try {
                System.out.print("Enter the coordinates:");
                t1.playerMove(scanner.nextInt(), scanner.nextInt());
                t1.showGrid();
                if (t1.checkWinX()) {
                    break;
                }
                t1.aiEasyMove();
                t1.showGrid();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates:");
                scanner.next();
            }
        } while (((!t1.checkWinO()) && (!t1.checkWinX())) && (t1.findSpacesInGrid() != 0));

        if (t1.findSpacesInGrid() == 0) {
            System.out.println("Draw");
        }
    }
}