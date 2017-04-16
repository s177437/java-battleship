package com.company;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by stianstrom on 13.04.2017.
 * <p>
 * This is the main class for the battleship game. This class contains a main method that executes the battleship game.
 * It adds two players to a playerlist, and uses the underlying Board/Boat classes to generate boards. By adjusting the
 * speed paramater, it is possible to slow down the game speed.
 */
public class Main {

    public static void main(String[] args) {
        ArrangeBoardAndBoats arrangeboardandboats = new ArrangeBoardAndBoats();
        List<ArrayList> boards = arrangeboardandboats.placeBoats();
        GameLogic gameLogic = new GameLogic();
        long speed = 0;
        List<String> players = new ArrayList();
        String player;
        while (true) {
            players.add("Stian");
            players.add("Bot");
            for (int i = 0; i < boards.size(); i++) {
                if (i == 0) {
                    player = players.get(0);
                } else {
                    player = players.get(1);
                }
                try {
                    gameLogic.play(boards.get(i), players, i, speed, player);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

            }

        }
    }
}
