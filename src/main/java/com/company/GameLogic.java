package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by stianstrom on 13.04.2017.
 *
 * This is the Gamelogic class. In this class, battleship is being played. The player has four alternatives:
 * *The fist alternative is to hit a blank field. If a blank field is hit, it is the next players turn
 * * If the player hits part of a boat. The player gets one more try.
 * * When a boat blown up, it is signalised by the program
 * * The players might hit fields that already have been hit, since it uses a random algorithm to generate the location
 * coordinates to hit. If the coordinates have been hit before. The player gets another try.
 * * The symbol -- is used to indicate that the player hit part of a boat.
 * * The symbol ** is used to indicate that the player hit a blank field.
 */
public class GameLogic {
    Map<String, List<String>> scores = new HashMap<>();

    public void play(List<ArrayList<String>> board, List playerlist, int boardid, long speed, String player) throws InterruptedException {
        TimeUnit.SECONDS.sleep(speed);
        Scorestat scorestat = new Scorestat();
        ArrangeBoardAndBoats arrangementsforboardandboats = new ArrangeBoardAndBoats();
        System.out.println("____________________________________________________________");

        scores = scorestat.checkForWinner(playerlist, scores);
        System.out.println("It is " + player + "'s turn to hit board" + boardid);
        for (ArrayList line : board) {
            System.out.println(line);
        }
        int row = ThreadLocalRandom.current().nextInt(1, 10 + 1) - 1;
        int column = ThreadLocalRandom.current().nextInt(1, 10 + 1) - 1;
        if (board.get(row).get(column) == "  ") {
            board.get(row).set(column, "**");
            System.out.println("HIT blank field " + board.get(row).get(column) + " at location " + row + " , " + column + " no boat in sight");
        } else if (board.get(row).get(column) == "**" || board.get(row).get(column) == "--") {
            System.out.println("HIT the following field which is already hit " + board.get(row).get(column) + " trying again");
            play(board, playerlist, boardid, speed, player);
        } else {
            String oldvalue = board.get(row).get(column);
            board.get(row).set(column, "--");
            Boolean boatIsGone = arrangementsforboardandboats.checkIfBoatIsBlownUp(oldvalue, board);
            if (boatIsGone == true) {
                System.out.println("BOOM boat is gone " + oldvalue);
                String boardplayer = "board" + boardid;
                scores = scorestat.updateScorestats(boardplayer, oldvalue, scores);
            } else {
                System.out.println("Hit part of boat " + oldvalue);
            }
            play(board, playerlist, boardid, speed, player);
        }


    }
}
