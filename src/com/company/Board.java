package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Created by stianstrom on 09.04.2017.
 */
public class Board {
    public Board(){}

    public ArrayList createBoard(){
        int row = 10;
        int columns=10;
        ArrayList<ArrayList> matrix = new ArrayList<ArrayList>();

        for (int i = 0; i <row ; i++) {
            ArrayList<String> line = new ArrayList<String>();
            for (int j = 0; j <columns ; j++) {
                line.add("  ");
            }
            matrix.add(line);
        }
        return matrix;
    }
    public ArrayList createTwoBoards(){
        ArrayList board1=createBoard();
        ArrayList board2=createBoard();
        ArrayList<ArrayList> boardlist= new ArrayList<ArrayList>();
        boardlist.add(board1);
        boardlist.add(board2);
        return boardlist;
    }
}
