package com.company;

/**
 * Created by erikjakubowski on 1/18/17.
 */
public class Room {
    int row;
    int col;
    boolean wasVisited = false;
    boolean hasBottom = true;
    boolean hasRight = true;

    String strt;
    String end;
    boolean O = false;
    boolean X = false;

    public Room(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Room(boolean wasVisited, boolean hasBottom, boolean hasRight, String strt, String end, boolean o, boolean x, int row, int col) {
        this.wasVisited = wasVisited;
        this.hasBottom = hasBottom;
        this.hasRight = hasRight;
        this.strt = strt;
        this.end = end;
        O = o;
        X = x;
        this.row = row;
        this.col = col;
    }

    public Room() {

    }
}
