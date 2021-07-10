package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameMode {

    public GameMode() {
        System.out.println("Input command:");
    }

    public List<String> getPlayersFromInput(String input) {

        String[] inputs = input.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(inputs));


        if (list.get(0).equals("start")) {
            list.remove(0);
            return list;
        }
        return list;
    }
    public boolean gameExit(String input) {
        String[] inputs = input.split(" ");
        return inputs[0].equals("exit") && inputs.length == 1;
    }
}