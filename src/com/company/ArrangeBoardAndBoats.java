package com.company;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.text.StyledEditorKit;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by stianstrom on 09.04.2017.
 */
public class ArrangeBoardAndBoats {
    public boolean placementOK;

    public ArrangeBoardAndBoats() {
        placementOK = false;
    }

    public ArrayList<ArrayList> placeBoats() {
        Boat boatclass = new Boat();
        Board boardclass = new Board();
        ArrayList<ArrayList> boardlist = boardclass.createTwoBoards();
        ArrayList<ArrayList<ArrayList<String>>> fullboatlist = boatclass.createFullBoatList();
        ArrayList<ArrayList> newBoardList = new ArrayList<>();

        for (ArrayList board : boardlist) {
            ArrayList<ArrayList> newboard = new ArrayList<>();
            for (ArrayList<ArrayList<String>> boatlist : fullboatlist) {
                for (ArrayList<String> boat : boatlist){
                    setPlacementOk(false);
                    int vertical_or_horizontal = ThreadLocalRandom.current().nextInt(0, 1 + 1);
                    int a = 0;
                    int b = 0;
                    while (placementOK!=true) {
                        a = ThreadLocalRandom.current().nextInt(1, 10 + 1) - 1;
                        b = ThreadLocalRandom.current().nextInt(1, 10 + 1) - 1;
                        //System.out.println("Direction: "+ vertical_or_horizontal + " A: "+ a + " B: " + b + " length boat: "+ boat.size()+ " Placement status: " + placementOK);
                        validate(board,boat,vertical_or_horizontal,a,b);
                        placementOK = getPlacementOK();
                        //System.out.println(placementOK);
                    }
                    ;
                    newboard = placeOutBoats(board, boat, vertical_or_horizontal, a, b);
                 }
            }
            newBoardList.add(newboard);
        }
        return newBoardList;

    }

    public void validate(ArrayList<ArrayList> board, ArrayList boat, int direction, int row, int column) {
        setPlacementOk(true);
        if (direction==1 && boat.size() + column > 10 || direction==0 && boat.size()+row >10){
            setPlacementOk(false);
            //System.out.println("Direction: "+ direction + " A: "+ row + " B: " + column + " length boat: "+ boat.size()+ " status: " + placementOK);
        }
        else if (direction == 1) {
            for (int i = 0; i < boat.size(); i++) {
                if (board.get(row).get(column + i) != "  ") {
                    setPlacementOk(false);
                }
            }
        } else {
            for (int i = 0; i < boat.size(); i++) {
                if (board.get(row + i).get(column) != "  ") {
                    setPlacementOk(false);
                }
            }
        }
    }

    public ArrayList placeOutBoats(ArrayList<ArrayList<String>> board, ArrayList<String> boat, int direction, int row, int column) {
        //System.out.println("Direction: "+ direction + " A: "+ row + " B: " + column + " length boat: "+ boat.size()+ " status: " + placementOK + " " + boat);
        ArrayList<ArrayList<String>> oldboard = board;
        setPlacementOk(true);
        if(direction==1) {
            for (int i = 0; i < boat.size(); i++) {
                if (board.get(row).get(column + i) != "  " && board.get(row+i).get(column)!="  ") {
                    setPlacementOk(false);
                    return oldboard;
                } else {
                    board.get(row).set(column + i, boat.get(i));
                }
            }
        }
        else{
                for (int i = 0; i <boat.size() ; i++) {
                    if(board.get(row+i).get(column)!="  " && board.get(row).get(column+i)!="  "){
                        setPlacementOk(false);
                        return oldboard;
                    }
                    else{
                        board.get(row+i).set(column,boat.get(i));

                    }

                }
            }
        return board;
    }

    public Boolean checkIfBoatIsBlownUp(String boatid, ArrayList<ArrayList<String>> board){
        for(ArrayList<String> line:board ){
            for(String element : line){
                if(element==boatid){
                    return false;
                }
            }
        }
        return true;
    }


    public Boolean getPlacementOK() {
        return placementOK;
    }

    public void setPlacementOk(Boolean value) {
        this.placementOK = value;
    }
}

