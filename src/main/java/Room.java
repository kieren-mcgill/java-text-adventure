import java.util.ArrayList;

public class Room {
    String name;
    String description;

    int row;
    int column;
    ArrayList<Items> inventory;

int north, south, east, west;

    public void  setInventory(ArrayList<Items> inventory) {
        this.inventory = inventory;
    }

    public Room(String name, String description, int north, int south, int east, int west, ArrayList<Items> inventory, int row, int column) {
        this.name = name;
        this.description = description;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.inventory = inventory;
        this.row = row;
        this.column= column;
    };

    public int getDirection(String directionString) {
        int directionInt = -1;
        switch (directionString) {
            case "north":
                directionInt = this.north;
                break;
            case "east":
                directionInt = this.east;
                break;
            case "south":
                directionInt = this.south;
                break;
            default:
                directionInt = this.west;
        }
        return directionInt;
    }

    public void setSouth() {
        this.south = south * -1;
    }

    public void setEast() {
        this.east = east * -1;
    }


    public void setWest() {
        this.west = west * -1;
    }


    public void setNorth() {
        this.north = north * -1;
    }

    public String getDescription() {
        return description;
    }


}
