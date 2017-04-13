package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by stianstrom on 09.04.2017.
 */
public class ArrangeBoardAndBoats {
    private boolean placementOK;

    public ArrangeBoardAndBoats() {
        placementOK = false;
    }

    public List placeBoats() {
        Boat boatclass = new Boat();
        Board boardclass = new Board();
        List<ArrayList> boardlist = boardclass.createTwoBoards();
        List<ArrayList> fullboatlist = boatclass.createFullBoatList();
        List<List> newBoardList = new ArrayList<>();

        for (ArrayList board : boardlist) {
            List newboard = new ArrayList<>();
            for (List<ArrayList> boatlist : fullboatlist) {
                for (ArrayList boat : boatlist){
                    setPlacementOk(false);
                    int direction = ThreadLocalRandom.current().nextInt(0, 1 + 1);
                    int a = 0;
                    int b = 0;
                    while (!placementOK) {
                        a = ThreadLocalRandom.current().nextInt(1, 10 + 1) - 1;
                        b = ThreadLocalRandom.current().nextInt(1, 10 + 1) - 1;
                        validate(board,boat,direction,a,b);
                        placementOK = getPlacementOK();
                    }
                    newboard = placeOutBoats(board, boat, direction, a, b);
                 }
            }
            newBoardList.add(newboard);
        }
        return newBoardList;

    }

    public void validate(List<ArrayList> board, List boat, int direction, int row, int column) {
        setPlacementOk(true);
        if (direction==1 && boat.size() + column > 10 || direction==0 && boat.size()+row >10){
            setPlacementOk(false);
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

    public List placeOutBoats(List<ArrayList> board, List boat, int direction, int row, int column) {
        List oldboard = board;
        setPlacementOk(true);
        if(direction==1) {
            for (int i = 0; i < boat.size(); i++) {
                if (board.get(row).get(column + i) != "  ") {
                    setPlacementOk(false);
                    return oldboard;
                } else {
                    board.get(row).set(column + i, boat.get(i));
                }
            }
        }
        else{
                for (int i = 0; i <boat.size() ; i++) {
                    if(board.get(row+i).get(column)!="  "){
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

    public Boolean checkIfBoatIsBlownUp(String boatid, List<ArrayList<String>> board){
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

