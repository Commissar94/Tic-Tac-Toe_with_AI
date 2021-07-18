package tictactoe.players.ai;

import tictactoe.Grid;
import tictactoe.Rules;

import java.util.ArrayList;
import java.util.List;

public class HardAiPlayer extends AiPlayer {


    public HardAiPlayer(boolean isHePlayingForX) {
        super(isHePlayingForX);
    }

    Rules rules = new Rules();

    @Override
    public void makeMoveNotify() {
        System.out.println("Making move level \"hard\"");
    }


    public List<Integer> move(Grid ourGrid) {

        char[][] grid = ourGrid.getGrid();
        int score;
        //это просто цифра, которую легко побить
        int bestScore = -1000;
        List<Integer> bestMove = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {


                if (grid[i][j] == ' ') {
                    //проверяем за какую мы сторону
                    grid[i][j] = isHePlayingForX ? 'X' : 'O';
                    //смотрим сколько очков вернется
                    score = minimax(ourGrid, 0, false);
                    //затираем наш ход
                    grid[i][j] = ' ';
                    //если наши очки превосходят лучший результат, то пишем их в лист
                    if (score > bestScore) {
                        bestScore = score;
                        //затираем старый результат, который мы превзошли
                        bestMove.clear();
                        bestMove.add(i);
                        bestMove.add(j);
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(Grid ourGrid, int depth, boolean isMaximizing) {

        char[][] grid = ourGrid.getGrid();

        //сколько очков возвращать при конечных состояних

        if (rules.checkWinX(ourGrid)){
            return isHePlayingForX ? 1 : -1;
        } else if (rules.checkWinO(ourGrid)){
            return isHePlayingForX ? -1 : 1;
        } else if (ourGrid.findSpacesInGrid() == 0){
            return 0;
        }

//ход самого игрока, так же бегаем по всему полю и рекурсивно вызываемся,
        //важно что при вызове мы меняем isMaximizing, потому что это уже будет ход второго игрока
        if (isMaximizing) {
            int bestScore = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (grid[i][j] == ' ') {
                        grid[i][j] = isHePlayingForX ? 'X' : 'O';
                        //вот тут рекурсия, которой мы сообщаем, что следующий ход не наш
                        int score = minimax(ourGrid, depth + 1, false);
                        grid[i][j] = ' ';
                        if (score > bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
            //а вот и ход второго игрока тут мы уже ищем минимум
        } else {
            int bestScore = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (grid[i][j] == ' ') {
                        grid[i][j] = isHePlayingForX ? 'O' : 'X';
                        //и снова рекурсия, возвращаем ход максимайзеру
                        int score = minimax(ourGrid, depth + 1, true);
                        grid[i][j] = ' ';
                        if (score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }

    public void aiHardMove(Grid ourGrid) {
        List<Integer> move = move(ourGrid);
        char[][] grid = ourGrid.getGrid();
        grid[move.get(0)][move.get(1)] = isHePlayingForX ? 'X' : 'O';
    }
}
