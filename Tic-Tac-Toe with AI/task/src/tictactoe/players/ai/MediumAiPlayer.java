package tictactoe.players.ai;

import tictactoe.Grid;

import java.util.List;

public class MediumAiPlayer extends AiPlayer {

    public MediumAiPlayer(boolean isHePlayingForX) {
        super(isHePlayingForX);
    }

    @Override
    public void makeMoveNotify() {
        System.out.println("Making move level \"medium\"");
    }

    EasyAiPlayer easyAiPlayer = new EasyAiPlayer(isHePlayingForX);

    public void aiMediumMove(Grid ourGrid) {
        char[][] grid = ourGrid.getGrid();

        if (isHePlayingForX) {  //Логика при игре за Х
            List<Character> winCoordinatesForX = oneMoveForWinCheck(ourGrid, 'X');
            List<Character> winCoordinatesForO = oneMoveForWinCheck(ourGrid, 'O');

            if (winCoordinatesForX.isEmpty() && winCoordinatesForO.isEmpty()) {
                easyAiPlayer.aiEasyMove(ourGrid);
            } else if (!winCoordinatesForX.isEmpty()) { //умный мув
                grid[winCoordinatesForX.get(0)][winCoordinatesForX.get(1)] = 'X';
            } else if (!winCoordinatesForO.isEmpty()) { //защитный мув
                grid[winCoordinatesForO.get(0)][winCoordinatesForO.get(1)] = 'X';
            }

        } else { // Логика при игре за O
            List<Character> winCoordinatesForO = oneMoveForWinCheck(ourGrid, 'O');
            List<Character> winCoordinatesForX = oneMoveForWinCheck(ourGrid, 'X');

            if (winCoordinatesForO.isEmpty() && winCoordinatesForX.isEmpty()) {
                easyAiPlayer.aiEasyMove(ourGrid);
            } else if (!winCoordinatesForO.isEmpty()) { //умный мув
                grid[winCoordinatesForO.get(0)][winCoordinatesForO.get(1)] = 'O';
            } else if (!winCoordinatesForX.isEmpty()) { //защитный мув
                grid[winCoordinatesForX.get(0)][winCoordinatesForX.get(1)] = 'O';
            }
        }
    }
}
