package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stianstrom on 09.04.2017.
 * <p>
 * This is the board class. The class contains two methods for generating the empty board matrices.
 * The first method creates a 10X10 board, while the other function uses the first to create a boardlist of two
 * 10x10 boards.
 */
public class Board {

    public List<List<String>> createBoard() {
        int row = 10;
        int columns = 10;
        List<List<String>> matrix = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            List<String> line = new LinkedList<>();
            for (int j = 0; j < columns; j++) {
                line.add("  ");
            }
            matrix.add(line);
        }
        return matrix;
    }

    public List<List<List<String>>> createTwoBoards() {
        LinkedList<List<List<String>>> boardlist = new LinkedList<>();
        boardlist.add(createBoard()); // Board #1.
        boardlist.add(createBoard()); // Board #2.
        return boardlist;
    }
}
