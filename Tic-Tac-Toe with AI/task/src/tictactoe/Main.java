package tictactoe;
import java.util.*;

class ticTacToe {

    private char[][] grid = new char[3][3];

    public void setGrid(String grid) {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.charAt(index) == '_') {
                    this.grid[i][j] = ' ';
                } else {
                    this.grid[i][j] = grid.charAt(index);
                }
                index++;
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

    public boolean fillGrid(int x, int y) {
        if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
            if (this.grid[x - 1][y - 1] == ' ') {
                int countX = 0;
                int countO = 0;
                for (int i = 0; i < 3; i++) { //считаем крестики и нолики
                    for (int j = 0; j < 3; j++) {
                        if (this.grid[i][j] == 'X') {
                            countX++;
                        } else if (this.grid[i][j] == 'O') {
                            countO++;
                        }
                    }
                }
                if (countX == countO) { //если одинаково, то ходит Х
                    this.grid[x - 1][y - 1] = 'X';
                } else if (countX > countO) {
                    this.grid[x - 1][y - 1] = 'O'; //если Х больше, то ходит 0
                }
                return false; //ход завершен
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                return true; //возвращаем правду, чтобы продолжать цикл в мейне
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        }
    }
    public void checkState() {
        boolean isComplete = true;
        boolean isWin = false;
        for (int i = 0; i < 3; i++) {  //проверяем на ситуацию победы по горизонталям и вертикалям
            if (this.grid[i][0] == 'X' && this.grid[i][1] == 'X' && this.grid[i][2] == 'X') {
                System.out.println("X wins");
                isWin = true;
                break;
            } else if (this.grid[i][0] == 'O' && this.grid[i][1] == 'O' && this.grid[i][2] == 'O') {
                System.out.println("O wins");
                isWin = true;
                break;
            } else if (this.grid[0][i] == 'X' && this.grid[1][i] == 'X' && this.grid[2][i] == 'X') {
                System.out.println("X wins");
                isWin = true;
                break;
            } else if (this.grid[0][i] == 'O' && this.grid[1][i] == 'O' && this.grid[2][i] == 'O') {
                System.out.println("O wins");
                isWin = true;
                break;
            }
        }
        if (!isWin) {  //если победы на прямых линиях не произошло, то смотрим диагонали
            if (this.grid[0][0] == 'X' && this.grid[1][1] == 'X' && this.grid[2][2] == 'X') {
                System.out.println("X wins");
            } else if (this.grid[0][0] == 'O' && this.grid[1][1] == 'O' && this.grid[2][2] == 'O') {
                System.out.println("O wins");
            } else if (this.grid[2][0] == 'X' && this.grid[1][1] == 'X' && this.grid[0][2] == 'X') {
                System.out.println("X wins");
            } else if (this.grid[2][0] == 'O' && this.grid[1][1] == 'O' && this.grid[0][2] == 'O') {
                System.out.println("O wins");
            } else {  //если и диагонали не выиграли, то проверяем есть ли еще пустые поля
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (this.grid[k][l] == ' ') {
                            isComplete = false; //если есть, то выходит и говорим что игра не завершена
                            break;
                        }
                    }
                }
                if (isComplete) { //если нет побед и пустых полей, то это ничья
                    System.out.println("Draw");
                } else { //ну а если нет побед, но есть пустые поля, то это незаконченная игра
                    System.out.println("Game not finished");
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ticTacToe t1 = new ticTacToe();
        System.out.print("Enter the cells: ");
        t1.setGrid(scanner.nextLine());
        t1.showGrid();
        System.out.print("Enter the coordinates:");
        boolean reRun = true;
        do {
            try {
                reRun = t1.fillGrid(scanner.nextInt(), scanner.nextInt());
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates:");
                scanner.next();
            }
        } while (reRun);
        t1.showGrid();
        t1.checkState();
    }
}