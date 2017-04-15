package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.*;

/**
 * Created by stianstrom on 14.04.2017.
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
        List matrix=createMatrix();
        List boards = arrangements.placeBoats();
        Assert.assertNotNull(boards);
    }


}
