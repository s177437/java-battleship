package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stianstrom on 13.04.2017.
 */
public class Scorestat {
    HashMap<String, ArrayList<String>> scorestat;
    public Scorestat(){
        scorestat=new HashMap<>();
    }

    public void setScorestat(HashMap s) {
        this.scorestat= s;
    }
    public HashMap getScorestat(){
        return scorestat;
    }

    public HashMap<String, ArrayList<String>> updateScorestats(String boardnumber, String boardlocationid, HashMap<String,ArrayList<String>> scores){
        if(scores.get(boardnumber)==null){
            ArrayList<String> scorelist= new ArrayList<String>();
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
    public HashMap<String, ArrayList<String>> checkForWinner(ArrayList<String> playerlist, HashMap<String,ArrayList<String>> scores){
        String player="";
        for(HashMap.Entry<String,ArrayList<String>> entry : scores.entrySet()){
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
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