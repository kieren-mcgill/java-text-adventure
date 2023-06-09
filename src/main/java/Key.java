public class Key extends Items{
    int workingRoom;
    String  doorUnlocked;

    public Key(String name, String description, int workingRoom, String doorUnlocked) {
        super(name, description);
        this.workingRoom = workingRoom;
        this.doorUnlocked = doorUnlocked;
    }

    public void useKey(Room currentRoom, int roomIndex) {
        if (roomIndex == workingRoom) {
            switch (doorUnlocked) {
            case "north":
                currentRoom.setNorth();
                break;
            case "east":
                currentRoom.setEast();
                break;
            case "south":
                currentRoom.setSouth();
                break;
            default:
                currentRoom.setWest();
                break;
        }
            System.out.println("The door to the " + doorUnlocked + " clicks.");
        } else {
            System.out.println("There are no doors in this room that this key fits.");
        }

    }
}
