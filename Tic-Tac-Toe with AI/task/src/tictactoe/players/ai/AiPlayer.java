package tictactoe.players.ai;

import tictactoe.Grid;
import tictactoe.players.Player;

import java.util.ArrayList;
import java.util.List;

public class AiPlayer extends Player {

    public AiPlayer(boolean isHePlayingForX) {
        this.isHePlayingForX = isHePlayingForX;
    }

    public void makeMoveNotify() {

    }

    public List<Character> oneMoveForWinCheck(Grid ourGrid, Character whoIsOneMoveForWin) {
        char[][] grid = ourGrid.getGrid();

        List<Character> winMove = new ArrayList<>(); // sout []
        for (int i = 0; i < 3; i++) {
            //проверяем на ситуацию предшествующую победе по горизонталям
            if (grid[i][0] == whoIsOneMoveForWin && grid[i][1] == whoIsOneMoveForWin && grid[i][2] == ' ') {
                winMove.add((char) i);
                winMove.add((char) 2);

            } else if (grid[i][0] == whoIsOneMoveForWin && grid[i][1] == ' ' && grid[i][2] == whoIsOneMoveForWin) {
                winMove.add((char) i);
                winMove.add((char) 1);

            } else if (grid[i][0] == ' ' && grid[i][1] == whoIsOneMoveForWin && grid[i][2] == whoIsOneMoveForWin) {
                winMove.add((char) i);
                winMove.add((char) 0);


                //проверяем на ситуацию предшествующую победе по вертикалям
            } else if (grid[0][i] == ' ' && grid[1][i] == whoIsOneMoveForWin && grid[2][i] == whoIsOneMoveForWin) {
                winMove.add((char) 0);
                winMove.add((char) i);

            } else if (grid[0][i] == whoIsOneMoveForWin && grid[1][i] == ' ' && grid[2][i] == whoIsOneMoveForWin) {
                winMove.add((char) 1);
                winMove.add((char) i);

            } else if (grid[0][i] == whoIsOneMoveForWin && grid[1][i] == whoIsOneMoveForWin && grid[2][i] == ' ') {
                winMove.add((char) 2);
                winMove.add((char) i);

            }
        }
        //если победы на прямых линиях не произошло, то смотрим диагонали
        if (grid[0][0] == ' ' && grid[1][1] == whoIsOneMoveForWin && grid[2][2] == whoIsOneMoveForWin) {
            winMove.add((char) 0);
            winMove.add((char) 0);
        } else if (grid[0][0] == whoIsOneMoveForWin && grid[1][1] == ' ' && grid[2][2] == whoIsOneMoveForWin) {
            winMove.add((char) 1);
            winMove.add((char) 1);
        } else if (grid[0][0] == whoIsOneMoveForWin && grid[1][1] == whoIsOneMoveForWin && grid[2][2] == ' ') {
            winMove.add((char) 2);
            winMove.add((char) 2);
        }
        //смотрим вторую диагональ
        else if (grid[2][0] == ' ' && grid[1][1] == whoIsOneMoveForWin && grid[0][2] == whoIsOneMoveForWin) {
            winMove.add((char) 2);
            winMove.add((char) 0);
        } else if (grid[2][0] == whoIsOneMoveForWin && grid[1][1] == ' ' && grid[0][2] == whoIsOneMoveForWin) {
            winMove.add((char) 1);
            winMove.add((char) 1);
        } else if (grid[2][0] == whoIsOneMoveForWin && grid[1][1] == whoIsOneMoveForWin && grid[0][2] == ' ') {
            winMove.add((char) 0);
            winMove.add((char) 2);
        }
        return winMove;
    }







}