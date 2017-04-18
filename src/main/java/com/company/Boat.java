package com.company;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stianstrom on 09.04.2017.
 * <p>
 * This is the boatclass.
 * The first method creates a boatlist containing a given amount if boats with a certain length.
 * The second method generates a set of boatlists based on instruction given for the battleship game.
 */
public class Boat {
    public List createBoat(int number, int length, String symbolToRepresentBoat) {
        List boatlist = new ArrayList();
        for (int i = 0; i < number; i++) {
            ArrayList<String> boat = new ArrayList<>();
            String boatIdToAppend = symbolToRepresentBoat + Integer.toString(i);
            for (int j = 0; j < length; j++) {
                boat.add(boatIdToAppend);
            }
            boatlist.add(boat);
        }
        return boatlist;
    }

    public List createFullBoatList() {
        List listOfBoats = new ArrayList();
        List boatlist1 = createBoat(1, 6, "A");
        List boatlist2 = createBoat(2, 4, "B");
        List boatlist3 = createBoat(3, 3, "C");
        List boatlist4 = createBoat(3, 2, "D");
        listOfBoats.add(boatlist1);
        listOfBoats.add(boatlist2);
        listOfBoats.add(boatlist3);
        listOfBoats.add(boatlist4);
        return listOfBoats;
    }
}
