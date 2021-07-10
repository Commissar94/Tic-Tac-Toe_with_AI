package tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rules rules = new Rules();

        while (true) {

            GameMode gameMode = new GameMode();
            String input = scanner.nextLine(); //ввод команды с указанием режима
            if (gameMode.gameExit(input)) {  // если пользователь решил выйти, то завершаем программу
                break;
            }
            List<String> players = gameMode.getPlayersFromInput(input);
            /*
            Проверяем правильность введения команды
            И ловим неправильные вводы
             */
            try {
                if ((players.get(0).equals("user") || players.get(0).equals("easy")) &&
                        (players.get(1).equals("easy")) || players.get(1).equals("user")) {
                    Player player1;
                    Player player2;
                /*
                Определяем кем будут являться игроки и их очередность хода
                 */
                    if (players.get(0).equals("user")) {
                        player1 = new HumanPlayer(true);
                    } else {
                        player1 = new AiPlayer(true);
                    }
                    if (players.get(1).equals("user")) {
                        player2 = new HumanPlayer(false);
                    } else {
                        player2 = new AiPlayer(false);
                    }
                    Grid grid = new Grid(); // создаем сетку, попутно вызывая генерацию пустых полей и последующий вывод в консоль

                /*
                Начинаем игру, проверяем правила, делаем ходы и все такое
                 */

                    while (((!rules.checkWinO(grid)) && (!rules.checkWinX(grid))) && (grid.findSpacesInGrid() != 0)) {
                        try {
                            if (playerMove(scanner, rules, player1, grid)) break;
                            if (playerMove(scanner, rules, player2, grid)) break;

                        } catch (Exception e) {
                            System.out.println("You should enter numbers!");
                            System.out.print("Enter the coordinates:");
                            scanner.next();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Bad parameters!\n");
            }
        }
    }

    private static boolean playerMove(Scanner scanner, Rules rules, Player player, Grid grid) {
        if (player instanceof HumanPlayer) {
            System.out.print("Enter the coordinates:");
            ((HumanPlayer) player).humanPlayerMove(scanner.nextInt(), scanner.nextInt(), grid);
        } else {
            ((AiPlayer) player).aiEasyMove(grid);
        }
        grid.showGrid();
        if (grid.findSpacesInGrid() == 0 && !rules.checkWinO(grid) && !rules.checkWinX(grid)) {
            System.out.println("Draw");
            return true;
        }
        return rules.checkWinX(grid) || rules.checkWinO(grid);
    }
}