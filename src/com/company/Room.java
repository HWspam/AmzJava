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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public boolean isHasBottom() {
        return hasBottom;
    }

    public void setHasBottom(boolean hasBottom) {
        this.hasBottom = hasBottom;
    }

    public boolean isHasRight() {
        return hasRight;
    }

    public void setHasRight(boolean hasRight) {
        this.hasRight = hasRight;
    }

    public String getStrt() {
        return strt;
    }

    public void setStrt(String strt) {
        this.strt = strt;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean isO() {
        return O;
    }

    public void setO(boolean o) {
        O = o;
    }

    public boolean isX() {
        return X;
    }

    public void setX(boolean x) {
        X = x;
    }
}
