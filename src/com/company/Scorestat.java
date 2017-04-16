package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by stianstrom on 13.04.2017.
 *
 * This class is the scorestat class. It contains two methods: The first method updates the score stats for a player.
 * This is done by adding a boat Id to an arraylist inside a Hashmap.
 *
 * The second method performs a check to see if we have a winner. When the length of the Arraylist for a board in the
 * Hashmap is equal to 9. It would mean that all boats have been blown up from the board. This means that we have a winner,
 * and the program exits with exit code 0.
 */

public class Scorestat {

    public Map<String, List<String>> updateScorestats(String boardnumber, String boardlocationid, Map<String,List<String>> scores){
        if(scores.get(boardnumber)==null){
            ArrayList<String> scorelist= new ArrayList<>();
            scorelist.add(boardlocationid);
            scores.put(boardnumber, scorelist);
            return scores;
        }
        else {
            scores.get(boardnumber).add(boardlocationid);
            System.out.println(scores);
            return scores;
        }
        }
    public Map<String, List<String>> checkForWinner(List<String> playerlist, Map<String,List<String>> scores){
        String player="";
        for(Map.Entry<String,List<String>> entry : scores.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.size()==9){
                if(key.equals("board0")){
                    player=playerlist.get(0);
                }
                else{
                    player=playerlist.get(1);
                }
                System.out.println("We have a winner " + player.toUpperCase() + "  who took out the following boats: " + value);
                System.exit(0);
            }
        }
        return scores;
    }
    }