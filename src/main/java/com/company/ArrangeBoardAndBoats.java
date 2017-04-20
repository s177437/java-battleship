package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by stianstrom on 09.04.2017.
 * <p>
 * This is the logic to generate boards and place out boats.
 * The first method tries to place out boats to the boards. In order to be able to place out the boats, a validation
 * check must be passed. This evaluation check aims performs a check to make sure that the generated location does not
 * exceed the boards column or row number. It also makes sure that a boat will not overwrite an already places boat on
 * the board.
 * <p>
 * The last function performs a check to see if a boat is blown up from the board during gameplay.
 */
public class ArrangeBoardAndBoats {
    private boolean placementOK;

    public ArrangeBoardAndBoats() {
        placementOK = false;
    }

    public List<List<List<String>>> placeBoats() {
        Boat boatclass = new Boat();
        Board boardclass = new Board();
        List<List<List<String>>> boardlist = boardclass.createTwoBoards();
        List<List<List<String>>> fullboatlist = boatclass.createFullBoatList();
        List<List<List<String>>> newBoardList = new LinkedList<>();

        for (List<List<String>> board : boardlist) {
            List<List<String>> newboard = new LinkedList<>();
            for (List<List<String>> boatlist : fullboatlist) {
                for (List<String> boat : boatlist) {
                    setPlacementOk(false);
                    int direction = ThreadLocalRandom.current().nextInt(0, 1 + 1);
                    int a = 0;
                    int b = 0;
                    while (!placementOK) {
                        a = ThreadLocalRandom.current().nextInt(1, 10 + 1) - 1;
                        b = ThreadLocalRandom.current().nextInt(1, 10 + 1) - 1;
                        validate(board, boat, direction, a, b);
                        placementOK = getPlacementOK();
                    }
                    newboard = placeOutBoats(board, boat, direction, a, b);
                }
            }
            newBoardList.add(newboard);
        }
        return newBoardList;
    }

    public void validate(List<List<String>> board, List boat, int direction, int row, int column) {
        setPlacementOk(true);
        if (direction == 1 && boat.size() + column > 10 || direction == 0 && boat.size() + row > 10) {
            setPlacementOk(false);
        } else if (direction == 1) {
            for (int i = 0; i < boat.size(); i++) {
                if (!board.get(row).get(column + i).equals("  ")) {
                    setPlacementOk(false);
                }
            }
        } else {
            for (int i = 0; i < boat.size(); i++) {
                if (!board.get(row + i).get(column).equals("  ")) {
                    setPlacementOk(false);
                }
            }
        }
    }

    private List<List<String>> placeOutBoats(List<List<String>> board, List<String> boat, int direction, int row, int column) {
        setPlacementOk(true);
        if (direction == 1) {
            for (int i = 0; i < boat.size(); i++) {
                if (!board.get(row).get(column + i).equals("  ")) {
                    setPlacementOk(false);
                    return board;
                } else {
                    board.get(row).set(column + i, boat.get(i));
                }
            }
        } else {
            for (int i = 0; i < boat.size(); i++) {
                if (!board.get(row + i).get(column).equals("  ")) {
                    setPlacementOk(false);
                    return board;
                } else {
                    board.get(row + i).set(column, boat.get(i));

                }
            }
        }
        return board;
    }

    Boolean checkIfBoatIsBlownUp(String boatid, List<List<String>> board) {
        for (List<String> line : board) {
            for (String element : line) {
                if (element.equals(boatid)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean getPlacementOK() {
        return placementOK;
    }

    private void setPlacementOk(Boolean value) {
        this.placementOK = value;
    }
}

