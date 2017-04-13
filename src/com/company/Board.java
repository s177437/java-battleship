package com.company;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stianstrom on 09.04.2017.
 */
public class Board {
    public List createBoard(){
        int row = 10;
        int columns=10;
        List matrix = new ArrayList<>();

        for (int i = 0; i <row ; i++) {
            List line = new ArrayList();
            for (int j = 0; j <columns ; j++) {
                line.add("  ");
            }
            matrix.add(line);
        }
        return matrix;
    }
    public List createTwoBoards(){
        List board1=createBoard();
        List board2=createBoard();
        List boardlist= new ArrayList<>();
        boardlist.add(board1);
        boardlist.add(board2);
        return boardlist;
    }
}
