package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stianstrom on 09.04.2017.
 * <p>
 * This is the boatclass.
 * The first method creates a boatlist containing a given amount if boats with a certain length.
 * The second method generates a set of boatlists based on instruction given for the battleship game.
 */
public class Boat {

    public List<List<String>> createBoat(int number, int length, String symbolToRepresentBoat) {
        List<List<String>> boatlist = new LinkedList<>();

        for (int i = 0; i < number; i++) {
            List<String> boat = new LinkedList<>();
            String boatIdToAppend = symbolToRepresentBoat + Integer.toString(i);
            for (int j = 0; j < length; j++) {
                boat.add(boatIdToAppend);
            }
            boatlist.add(boat);
        }
        return boatlist;
    }

    public List<List<List<String>>> createFullBoatList() {
        List<List<List<String>>> listOfBoats = new LinkedList<>();
        listOfBoats.add(createBoat(1, 6, "A")); // Boat A.
        listOfBoats.add(createBoat(2, 4, "B")); // Boat B.
        listOfBoats.add(createBoat(3, 3, "C")); // Boat C.
        listOfBoats.add(createBoat(3, 2, "D")); // Boat D.
        return listOfBoats;
    }
}
