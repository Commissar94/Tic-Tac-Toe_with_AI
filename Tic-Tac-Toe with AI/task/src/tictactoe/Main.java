package tictactoe;

import tictactoe.players.HumanPlayer;
import tictactoe.players.Player;
import tictactoe.players.ai.EasyAiPlayer;
import tictactoe.players.ai.HardAiPlayer;
import tictactoe.players.ai.MediumAiPlayer;

import java.util.List;
import java.util.Scanner;

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
                if (players.get(0).equals("user") ||
                        players.get(0).equals("easy") || players.get(0).equals("medium") || players.get(0).equals("hard") &&
                        players.get(1).equals("user") ||
                        players.get(1).equals("easy") || players.get(1).equals("medium") || players.get(1).equals("hard")) {
                    Player player1;
                    Player player2;
                /*
                Определяем кем будут являться игроки и их очередность хода
                 */
                    //TODO перенести в GameMode
                    //первый игрок
                    switch (players.get(0)) {
                        case "user":
                            player1 = new HumanPlayer(true);
                            break;
                        case "easy":
                            player1 = new EasyAiPlayer(true);
                            break;
                        case "medium":
                            player1 = new MediumAiPlayer(true);
                            break;
                        default:
                            player1 = new HardAiPlayer(true); //hard
                            break;
                    }
                    //второй игрок
                    switch (players.get(1)) {
                        case "user":
                            player2 = new HumanPlayer(false);
                            break;
                        case "easy":
                            player2 = new EasyAiPlayer(false);
                            break;
                        case "medium":
                            player2 = new MediumAiPlayer(false);
                            break;
                        default:
                            player2 = new HardAiPlayer(false); //hard
                            break;
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
                            System.out.println(e.getMessage());
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

    //TODO Поправить и перенести в абстрактного игрока через его интерфейс
    private static boolean playerMove(Scanner scanner, Rules rules, Player player, Grid grid) {
        if (player instanceof HumanPlayer) {
            System.out.print("Enter the coordinates:");
            ((HumanPlayer) player).humanPlayerMove(scanner.nextInt(), scanner.nextInt(), grid);
        } else if (player instanceof EasyAiPlayer) {
            ((EasyAiPlayer) player).makeMoveNotify();
            ((EasyAiPlayer) player).aiEasyMove(grid);
        } else if (player instanceof MediumAiPlayer) {
            ((MediumAiPlayer) player).makeMoveNotify();
            ((MediumAiPlayer) player).aiMediumMove(grid);
        } else if (player instanceof  HardAiPlayer) {
            ((HardAiPlayer) player).makeMoveNotify();
            ((HardAiPlayer) player).aiHardMove(grid);
        }


        grid.showGrid();
        if (grid.findSpacesInGrid() == 0 && !rules.checkWinO(grid) && !rules.checkWinX(grid)) {
            System.out.println("Draw");
            return true;
        }
        if (rules.checkWinX(grid)) {
            System.out.println("X wins");
        } else if (rules.checkWinO(grid)) {
            System.out.println("O wins");
        }
        return rules.checkWinX(grid) || rules.checkWinO(grid);
    }
}