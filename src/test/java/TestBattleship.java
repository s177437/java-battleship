import com.company.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by stianstrom on 14.04.2017.
 * <p>
 * This is the testclass for the battleship game. The different game methods are tested here to make sure they are
 * compliant to the requirements for the game.
 */
public class TestBattleship {

    @Test
    public void testEmptyBoardCreation() {
        List<List<String>> matrix = createMatrix();
        Board boardclass = new Board();
        List<List<String>> board = boardclass.createBoard();
        Assert.assertEquals(board, matrix);
    }

    @Test
    public void testBoardLength() {
        Board boardclass = new Board();
        List matrix = createMatrix();
        List<List<String>> board = boardclass.createBoard();
        Assert.assertEquals(matrix.size(), board.size());
    }

    @Test
    public void testLengthBoats() {
        Map<Integer, Integer> boatlist = new HashMap<>();
        Map<Integer, Integer> expectedboatlist = new HashMap<>();
        expectedboatlist.put(1, 6);
        expectedboatlist.put(2, 4);
        expectedboatlist.put(3, 3);
        expectedboatlist.put(3, 2);

        List<List<List<String>>> gameboatlist = new Boat().createFullBoatList();

        for (List<List<String>> boats : gameboatlist) {
            for (List<String> boat : boats) {
                boatlist.put(boats.size(), boat.size());
            }
        }
        Assert.assertEquals(expectedboatlist, boatlist);
    }

    @Test
    public void testValidationFailsForToLongColumn() {
        List<List<String>> matrix = createMatrix();
        ArrangeBoardAndBoats arragements = new ArrangeBoardAndBoats();
        Boat boatclass = new Boat();
        List<List<String>> boatlist = boatclass.createBoat(1, 6, "A");
        List<String> boat = boatlist.get(0);
        arragements.validate(matrix, boat, 1, 2, 9);
        Assert.assertFalse(arragements.getPlacementOK());
    }

    @Test
    public void testValidationFailsForToLongRow() {
        List<List<String>> matrix = createMatrix();
        ArrangeBoardAndBoats arragements = new ArrangeBoardAndBoats();
        Boat boatclass = new Boat();
        List<List<String>> boatlist = boatclass.createBoat(1, 6, "A");
        List<String> boat = boatlist.get(0);
        arragements.validate(matrix, boat, 0, 9, 5);
        Assert.assertFalse(arragements.getPlacementOK());
    }

    @Test
    public void testValidationIsOK() {
        List<List<String>> matrix = createMatrix();
        ArrangeBoardAndBoats arragements = new ArrangeBoardAndBoats();
        Boat boatclass = new Boat();
        List<List<String>> boatlist = boatclass.createBoat(1, 6, "A");
        List<String> boat = boatlist.get(0);
        arragements.validate(matrix, boat, 0, 2, 3);
        Assert.assertTrue(arragements.getPlacementOK());
    }

    @Test
    public void testBoardIsNotNull() {
        ArrangeBoardAndBoats arrangements = new ArrangeBoardAndBoats();
        List boards = arrangements.placeBoats();
        Assert.assertNotNull(boards);
    }

    @Test
    public void testCheckForWinnerIsFalse() {
        Scorestat scorestat = new Scorestat();
        String board0 = "board0";
        String board1 = "board1";
        List<String> winnerlist0 = new LinkedList<>(Arrays.asList("A0", "B0", "B1", "C0", "C1", "C2", "D0", "D1"));
        List<String> winnerlist1 = new LinkedList<>(Arrays.asList("A1", "B1", "B0", "C0", "C1", "C2", "D0"));
        List<String> playerlist = new ArrayList<>();
        playerlist.add("Stian");
        playerlist.add("Bot");
        Map<String, List<String>> winnermap = new HashMap<>();
        winnermap.put(board0, winnerlist0);
        winnermap.put(board1, winnerlist1);
        Assert.assertNotNull(scorestat.checkForWinner(playerlist, winnermap));
    }

    // Helper method for tests to setup-up
    private List<List<String>> createMatrix() {
        List<String> line = new ArrayList<>(Arrays.asList("  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "));
        List<List<String>> matrix = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            matrix.add(line);
        }
        return matrix;
    }
}
