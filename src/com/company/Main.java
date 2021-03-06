package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static Random r = new Random();
    static final int SIZE = 10; //final cant change from ANYWHERE
    public static boolean first = true;
    public static boolean ending = true;
    public static int begin = r.nextInt(SIZE);
    public static int begin2 =r.nextInt(SIZE);



    static ArrayList<ArrayList<Room>> createRooms() {
        ArrayList<ArrayList<Room>> rooms = new ArrayList<>();
        for (int row = 0; row < SIZE; row++) {
            ArrayList<Room> roomRow = new ArrayList<>();
            for (int col = 0; col < SIZE; col++) {
                roomRow.add(new Room(row, col));
            }
            rooms.add(roomRow);
        }
        return rooms;
    }

    static ArrayList<Room> possibleNeighbors(ArrayList<ArrayList<Room>> rooms, int row, int col) {
        ArrayList<Room> neighbors = new ArrayList<>();

        if (row > 0) neighbors.add(rooms.get(row-1).get(col));
        if (row < SIZE-1) neighbors.add(rooms.get(row+1).get(col));
        if (col > 0) neighbors.add(rooms.get(row).get(col-1));
        if (col < SIZE-1) neighbors.add(rooms.get(row).get(col+1));

        neighbors = neighbors.stream()
                .filter(room -> {
                    return !room.wasVisited;
                })
                .collect(Collectors.toCollection(ArrayList<Room>::new));

        return neighbors;
    }

    static Room randomNeighbor(ArrayList<ArrayList<Room>> rooms, int row, int col) {
        ArrayList<Room> neighbors = possibleNeighbors(rooms,row, col);

        if (neighbors.size() > 0) {
            Random r = new Random();
            int index = r.nextInt(neighbors.size());
            return neighbors.get(index);
        } else{
            if(ending == true){
                rooms.get(col).get(row).setX(true);
                ending = false;

            }
        }
        return null;
    }
    static void tearDownWall(Room oldRoom, Room newRoom) {
        if (newRoom.row < oldRoom.row) {
            newRoom.hasBottom = false;
        }
        else if (newRoom.row > oldRoom.row) {
            oldRoom.hasBottom = false;
        }
        else if (newRoom.col < oldRoom.col) {
            newRoom.hasRight = false;
        }
        else if (newRoom.col > oldRoom.col) {
            oldRoom.hasRight = false;
        }
    }
    static boolean creaeMaze(ArrayList<ArrayList<Room>> rooms, Room room) {
        room.wasVisited = true;
        Room nextRoom = randomNeighbor(rooms, room.row, room.col);
        if (nextRoom == null) {
            return false;
        }
        tearDownWall(room, nextRoom);

        while (creaeMaze(rooms, nextRoom)){

        }

        return true;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Room>> rooms = createRooms();
        rooms.get(0).get(0).setO(true);
        creaeMaze(rooms, rooms.get(0).get(0));
        for (ArrayList<Room> row : rooms) {
            System.out.print(" _");
        }
        System.out.println();
        for (ArrayList<Room> row : rooms) {
            System.out.print("|");


            for(Room room : row) {
                if (room.isO()) {
                    System.out.print(room.O ? "O" : "");
                    System.out.print(room.hasRight ? "|" : " ");
                } else if (room.isX()) {
                    System.out.print(room.X ? "X" : "");
                    System.out.print(room.hasRight ? "|" : " ");

                } else {
                    System.out.print(room.hasBottom ? "_" : " ");
                    System.out.print(room.hasRight ? "|" : " ");

                }
            }
            System.out.println();
        }

    }
}
