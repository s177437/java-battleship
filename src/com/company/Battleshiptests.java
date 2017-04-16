package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.*;

/**
 * Created by stianstrom on 14.04.2017.
 *
 * This is the testclass for the battleship game. The different game methods are tested here to make sure they are
 * compliant to the requirements for the game.
 */
public class Battleshiptests {


    public List createMatrix(){
        ArrayList<String> line = new ArrayList<>(Arrays.asList("  ","  ","  ","  ","  ","  ","  ","  ","  ","  "));
        List<ArrayList> matrix = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            matrix.add(line);
        }
        return matrix;
    }

    @Test
    public void testEmptyBoardCreation(){
        List<ArrayList> matrix =createMatrix();
        Board boardclass = new Board();
        List<ArrayList> board= boardclass.createBoard();
        Assert.assertEquals(board,matrix);
    }

    @Test
    public void testBoardLength(){
        Board boardclass = new Board();
        List matrix = createMatrix();
        List<ArrayList> board = boardclass.createBoard();
        Assert.assertEquals(matrix.size(), board.size());
    }
    @Test
    public void testLengthBoats(){
        Map<Integer,Integer> boatlist= new HashMap<>();
        Map<Integer,Integer> expectedboatlist = new HashMap<>();
        expectedboatlist.put(1, 6);
        expectedboatlist.put(2, 4);
        expectedboatlist.put(3, 3);
        expectedboatlist.put(3, 2);
        Boat boatclass = new Boat();
        List<ArrayList> gameboatlist=boatclass.createFullBoatList();
        for (ArrayList<ArrayList> boats : gameboatlist){
            for(ArrayList boat : boats){
                boatlist.put(boats.size(),boat.size());
            }
        }
        Assert.assertEquals(expectedboatlist,boatlist);
    }

    @Test
    public void testValidationFailsForToLongColumn(){
        List matrix=createMatrix();
        ArrangeBoardAndBoats arragements = new ArrangeBoardAndBoats();
        Boat boatclass =new Boat();
        List<ArrayList> boatlist=boatclass.createBoat(1,6,"A");
        ArrayList boat=boatlist.get(0);
        arragements.validate(matrix,boat,1,2,9);
        Assert.assertFalse(arragements.getPlacementOK());
    }
    @Test
    public void testValidationFailsForToLongRow(){
        List matrix=createMatrix();
        ArrangeBoardAndBoats arragements = new ArrangeBoardAndBoats();
        Boat boatclass =new Boat();
        List<ArrayList> boatlist=boatclass.createBoat(1,6,"A");
        ArrayList boat=boatlist.get(0);
        arragements.validate(matrix,boat,0,9,5);
        Assert.assertFalse(arragements.getPlacementOK());
    }
    @Test
    public void testValidationIsOK(){
        List matrix=createMatrix();
        ArrangeBoardAndBoats arragements = new ArrangeBoardAndBoats();
        Boat boatclass =new Boat();
        List<ArrayList> boatlist=boatclass.createBoat(1,6,"A");
        ArrayList boat=boatlist.get(0);
        arragements.validate(matrix,boat,0,2,3);
        Assert.assertTrue(arragements.getPlacementOK());
    }
    @Test
    public void testBoardIsNotNull(){
        ArrangeBoardAndBoats arrangements=new ArrangeBoardAndBoats();
        List boards = arrangements.placeBoats();
        Assert.assertNotNull(boards);
    }
    @Test
    public void testCheckForWinnerIsFalse(){
        Scorestat scorestat = new Scorestat();
        String board0="board0";
        String board1="board1";
        List winnerlist0 = new ArrayList<>(Arrays.asList("A0","B0","B1","C0","C1","C2","D0","D1"));
        List winnerlist1 = new ArrayList<>(Arrays.asList("A1","B1","B0","C0","C1","C2","D0"));
        List playerlist=new ArrayList<>();
        playerlist.add("Stian");
        playerlist.add("Bot");
        Map<String,List<String>> winnermap=new HashMap<>();
        winnermap.put(board0,winnerlist0);
        winnermap.put(board1,winnerlist1);
        Assert.assertNotNull(scorestat.checkForWinner(playerlist,winnermap));
    }

}
