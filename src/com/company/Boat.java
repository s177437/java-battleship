package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by stianstrom on 09.04.2017.
 */
public class Boat {
    public Boat() {
    }

    public ArrayList createBoat(int number, int length, String symbolToRepresentBoat) {
        ArrayList<ArrayList> boatlist = new ArrayList<ArrayList>();
        for (int i = 0; i < number; i++) {
            ArrayList<String> boat = new ArrayList<String>();
            String boatIdToAppend = symbolToRepresentBoat + Integer.toString(i);
            for (int j = 0; j < length; j++) {
                boat.add(boatIdToAppend);
            }
            boatlist.add(boat);
        }
        return boatlist;
    }

    public ArrayList createFullBoatList() {
        ArrayList<ArrayList> listOfBoats = new ArrayList<ArrayList>();
        ArrayList<ArrayList> boatlist1 = createBoat(1, 6, "A");
        ArrayList<ArrayList> boatlist2 = createBoat(2, 4, "B");
        ArrayList<ArrayList> boatlist3 = createBoat(3, 3, "C");
        ArrayList<ArrayList> boatlist4 = createBoat(3, 2, "D");
        listOfBoats.add(boatlist1);
        listOfBoats.add(boatlist2);
        listOfBoats.add(boatlist3);
        listOfBoats.add(boatlist4);
        return listOfBoats;
    }
}
