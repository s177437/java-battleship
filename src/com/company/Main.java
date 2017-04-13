package com.company;


import javax.xml.transform.Source;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrangeBoardAndBoats arrangeboardandboats = new ArrangeBoardAndBoats();
        ArrayList<ArrayList> boards = arrangeboardandboats.placeBoats();
        GameLogic gameLogic = new GameLogic();
        long speed = 0;
        ArrayList<String> players = new ArrayList();
        String player = "";
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
