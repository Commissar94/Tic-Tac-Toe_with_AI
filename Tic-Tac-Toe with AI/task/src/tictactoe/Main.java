package tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rules rules = new Rules();
        Grid grid = new Grid();
        grid.generateGrid();
        grid.showGrid();
        Player player = new Player();
        AI ai = new AI();
        do {
            try {
                System.out.print("Enter the coordinates:");
                player.playerMove(scanner.nextInt(), scanner.nextInt(), grid);
                grid.showGrid();
                if (rules.checkWinX(grid)) {
                    break;
                }
                ai.aiEasyMove(grid);
                grid.showGrid();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates:");
                scanner.next();
            }
        } while (((!rules.checkWinO(grid)) && (!rules.checkWinX(grid))) && (grid.findSpacesInGrid() != 0));

        if (grid.findSpacesInGrid() == 0 && !rules.checkWinO(grid) && !rules.checkWinX(grid)) {
            System.out.println("Draw");
        }
    }
}