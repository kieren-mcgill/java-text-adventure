import java.util.*;
import java.util.concurrent.TimeUnit;


public class Game {


    public Game() {
        Map.createMap1();
    }

    public List<String> getWordList(String input) {
        String delims = " \t,.:;?!\"'";
        List<String> words = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        while (tokenizer.hasMoreTokens()) {
            words.add(tokenizer.nextToken());
        }
        return words;
    }

    public void parseCommand(List<String> words) {
        String verb;
        String noun;
        List<String> commands = new ArrayList<>(Arrays.asList("inspect", "take", "drop", "move", "search", "open", "use", "give","cheat"));
        List<String> nouns = new ArrayList<>(Arrays.asList("north", "south", "east", "west", "room", "rope", "oil", "cog", "spike", "ruby", "satchel", "trowel", "green-key", "blue-key","red-key","black-key","red-herring","crabs","idkfa","idclev14"));
        if (words.size() > 2) {
            System.out.println("Commands should just be 2 words");
        } else {
            verb = words.get(0);
            if (!commands.contains(verb)) {
                System.out.println(verb + " is not a known verb");
            }
            noun = words.get(1);
            if (!nouns.contains(noun)) {
                System.out.println(noun + " is not a known thing");
            }
        }
    }

    public String runCommand(String input) {
        List<String> wordList;
        String output = "";
        String lowerCaseTrimmed = input.trim().toLowerCase();
        if (lowerCaseTrimmed.isBlank()) {
            output = "...Well?";
        } else {
            wordList = getWordList(lowerCaseTrimmed);
            parseCommand(wordList);

            processVerb(wordList.get(0), wordList.get(1));
        }

        return output;
    }

    static World world = new World();
    public static int roomIndex = 0;
    public static Room currentRoom = world.map.get(roomIndex);

    public void changeRoom(int oldRoomIndex, int newRoomIndex) {
        Map.removeCurrentMap(world.map.get(oldRoomIndex));
        Map.addNewMap(world.map.get(newRoomIndex));
        roomIndex = newRoomIndex;
        currentRoom = world.map.get(roomIndex);
    }


    public void processVerb(String verb, String noun) {
        try {
            switch (verb) {
                case "move":
                    move(noun);
                    break;
                case "search":
                    search();
                    break;
                case "take":
                    take(noun);
                    break;
                case "open":
                    open(noun);
                    break;
                case "drop":
                    drop(noun);
                    break;
                case "use":
                    use(noun);
                    break;
                case "give":
                    give(roomIndex, noun);
                    break;
                case "cheat":
                    cheat(noun);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + verb);
            }
        } catch (Exception e) {
            System.out.println("What on earth are you talking about ? Please try again");
        }

    }

    public void search() {
        ArrayList<String> itemDescriptions = new ArrayList<>();
        for (Items roomItems : currentRoom.inventory) {
            itemDescriptions.add(roomItems.description);
        } if (itemDescriptions.size() > 0){
        String items = String.join(", ", itemDescriptions);
        System.out.println("You search the room and find " + items + ".");
    } else {
            System.out.println("You search the room and find nothing.");
        }
    }

    public void move(String direction) {
        int directionIndex = currentRoom.getDirection(direction);
        if (directionIndex >= 0) {
            if (roomIndex == 12 && direction.equals("north")) {
                System.out.println("A secret panel slides away.The water logged floor continues in this room. There is a dark green algae floating in some places." );
                changeRoom(roomIndex, directionIndex);
            } else {
                changeRoom(roomIndex, directionIndex);
                enterRoom(currentRoom);
            }
        } else if (directionIndex == -100) {
            System.out.println("You cannot move in that direction!");
        } else {
            System.out.println("This door seems to be locked.");
        }
    }

    public void take(String item) {
        boolean itemPresent = false;
        for (int i = 0; i < currentRoom.inventory.size(); i++) {
            if (item.equals(currentRoom.inventory.get(i).name)) {
                world.player.characterInventory.add(currentRoom.inventory.get(i));
                currentRoom.inventory.remove(i);
                itemPresent = true;
                System.out.println("The " + item + " is now in your satchel");
                break;
            }
        }
        if (!itemPresent) {
            System.out.println("There is no " + item + " in this room.");
            itemPresent = false;
        }
    }

    public void cheat(String verb) {
        switch (verb) {
            case "idkfa":
                List.of("redkey", "greenkey", "bluekey", "blackkey").forEach(key -> world.player.characterInventory.add(Inventory.getItemsMap().get(key)));
                System.out.println("You now have all of the keys, you dirty cheater!");
                break;
            case "idclev14":
                List.of("trowel").forEach(key -> world.player.characterInventory.add(Inventory.getItemsMap().get(key)));
                changeRoom(roomIndex, 14);
                System.out.println("You are magically transported to the very last room in the game. Brian is here and you have the trowel. You dirty cheater!");
                break;
            default:
                System.out.println("That is not a option.");
                break;
        }
    }
    public void use(String item) {
        boolean itemPresent = false;
        ArrayList<Items> satchel = world.player.characterInventory;
        for (Items items : satchel) {
            if (item.equals(items.name)) {
                if (items instanceof Key) {
                    ((Key) items).useKey(currentRoom, roomIndex);
                }
                itemPresent = true;
                break;
            }
        }
        if (!itemPresent) {
            System.out.println("There is no " + item + " in your satchel.");
            itemPresent = false;
        }
    }

    public void drop(String item) {
        boolean itemPresent = false;
        for (int i = 0; i < world.player.characterInventory.size(); i++) {
            if (item.equals(world.player.characterInventory.get(i).name)) {
                currentRoom.inventory.add(world.player.characterInventory.get(i));
                world.player.characterInventory.remove(i);
                itemPresent = true;
                System.out.println("The " + item + " is now on the floor in front of you.");
                break;
            }
        }
        if (!itemPresent) {
            System.out.println("There is no " + item + " in your satchel.");
            itemPresent = false;
        }
    }

    public void open(String thing) {
        if (thing.equals("satchel")) {
            ArrayList<String> satchelContents = new ArrayList<>();
            for (Items satchelItems : world.player.characterInventory) {
                satchelContents.add(satchelItems.description);
            } if (satchelContents.size() > 0) {
                String items = String.join(", ", satchelContents);
                System.out.println("Your satchel contains " + items + ".");
            } else {
                System.out.println("Your satchel is empty.");
            }
        }
    }

    public static void enterRoom(Room currentRoom) {
        System.out.println(currentRoom.getDescription());
    }



    public void give(int roomIndex, String noun) throws InterruptedException {
        switch (roomIndex) {
            case 7:
                endLevelOne(noun);
                break;
            case 14:
                endLevelTwo(noun);
                break;
            default:
                System.out.println("There is nobody here to give that to.");
        }
    }

    public void endLevelOne(String thing) throws InterruptedException {
        if (thing.equals("crabs")) {
            String endLevelOne = "Chymidea complains bitterly that this is the worst case of crabs she has ever had but grins with glee at the rusty cog. She steps to one side and the lift doors open. However as you step forward you feel a sharp blow \n to the back of your head. You fall to the floor and fade to black.";

            if (world.player.characterInventory.size() > 0) {
                world.player.characterInventory.subList(0, world.player.characterInventory.size()).clear();
            }
            roomIndex = 8;
            changeRoom(7, 8);
            System.out.println(endLevelOne);
            enterRoom(currentRoom);
            world.player.characterInventory.add(currentRoom.inventory.get(0));
            world.player.characterInventory.add(currentRoom.inventory.get(1));
            currentRoom.inventory.remove(1);
            currentRoom.inventory.remove(0);
        }
    }

    public static void endLevelTwo(String thing) {
        String endLevelTwo = "Brian scrapes around a large block in the wall at the back of his cell and the block falls away. Behind it you see a tunnel leading up to the surface. " +
                " Brain and Thomas skip hand in hand into the sunset. Reunited at last. \n \n" +
                " #     #                                                                                                              ###     #####                                                                                             ### \n" +
                " #     # #    # #####  #####    ##   #   #    #   #  ####  #    #    ######  ####   ####    ##   #####  ###### #####  ###    #     #  ####  #    #  ####  #####    ##   ##### #    # #        ##   ##### #  ####  #    #  ####  ### \n" +
                " #     # #    # #    # #    #  #  #   # #      # #  #    # #    #    #      #      #    #  #  #  #    # #      #    # ###    #       #    # ##   # #    # #    #  #  #    #   #    # #       #  #    #   # #    # ##   # #      ### \n" +
                " ####### #    # #    # #    # #    #   #        #   #    # #    #    #####   ####  #      #    # #    # #####  #    #  #     #       #    # # #  # #      #    # #    #   #   #    # #      #    #   #   # #    # # #  #  ####   #  \n" +
                " #     # #    # #####  #####  ######   #        #   #    # #    #    #           # #      ###### #####  #      #    #        #       #    # #  # # #  ### #####  ######   #   #    # #      ######   #   # #    # #  # #      #     \n" +
                " #     # #    # #   #  #   #  #    #   #        #   #    # #    #    #      #    # #    # #    # #      #      #    # ###    #     # #    # #   ## #    # #   #  #    #   #   #    # #      #    #   #   # #    # #   ## #    # ### \n" +
                " #     #  ####  #    # #    # #    #   #        #    ####   ####     ######  ####   ####  #    # #      ###### #####  ###     #####   ####  #    #  ####  #    # #    #   #    ####  ###### #    #   #   #  ####  #    #  ####  ### \n \n \n" +
                " \n \n Thank you for playing. Brian and Thomas will return in 'The pointy thing of Destiny' very soon";

        if (thing.equals("trowel")) {
            System.out.println(endLevelTwo);
        }
    }
}

