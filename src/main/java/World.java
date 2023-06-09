import java.util.ArrayList;
import java.util.List;

public class World {

    ArrayList<Room> map;

    Character player;

    public World() {
        String room0 = "   _                _    ___           \n" +
                " | |   _____ _____| |  / _ \\ _ _  ___ \n" +
                " | |__/ -_) V / -_) | | (_) | ' \\/ -_)\n" +
                " |____\\___|\\_/\\___|_|  \\___/|_||_\\___|\n" +
                "                                     \n ######                                                                    #####                                             \n" +
                " #     # ######   ##   #      # #    #  ####     #    # # ##### #    #    #     # #    # #   # #    # # #####  ######   ##   \n" +
                " #     # #       #  #  #      # ##   # #    #    #    # #   #   #    #    #       #    #  # #  ##  ## # #    # #       #  #  \n" +
                " #     # #####  #    # #      # # #  # #         #    # #   #   ######    #       ######   #   # ## # # #    # #####  #    # \n" +
                " #     # #      ###### #      # #  # # #  ###    # ## # #   #   #    #    #       #    #   #   #    # # #    # #      ###### \n" +
                " #     # #      #    # #      # #   ## #    #    ##  ## #   #   #    #    #     # #    #   #   #    # # #    # #      #    # \n" +
                " ######  ###### #    # ###### # #    #  ####     #    # #   #   #    #     #####  #    #   #   #    # # #####  ###### #    # \n" +
                "                                                                                                                            \n " +
                "It was late one night when Thomas , our hero , received a somewhat garbled message from his old boss Chymidea. Something about losing a vital artifact deep \n in the basement  of their old offices. She demanded he come immediately and use his skills to retrieve the item , somethings about previous failed attempts \n and something about her favourite Pizza place 'The Crust Station' being unable to supply her favourite seafood pizza due to the lack of a vital ingredient.  \n You immediately don your trusty sowester and wellies, grab your satchel and headed to the offices. The first room as you descend the stairs is dank \n and cold and more than a little uncomfortable. ";

        String room7 = "As you realised earlier the further you go into these rooms the older and wetter the walls get. This must be the oldest part of this labyrinth. Moss hangs from \n the upper walls and the bare stone has turned to rock. In counterpoint to this however on one wall are the steel doors of a modern lift. The lift seems to be \n only able to go further down. Standing in front of the lift is your old boss Chymidea. \n 'So you got here at last, what took you so long ? I have been waiting hours.' \n 'I hope you have managed to find the Antikythera cog and the replacement seafood for my pizza.' \n 'Come on hand them over! I'm in a hurry damn you!' ";

        String room8 ="  _                _   _____            \n" +
                " | |   _____ _____| | |_   _|_ __ _____ \n" +
                " | |__/ -_) V / -_) |   | | \\ V  V / _ \\\n" +
                " |____\\___|\\_/\\___|_|   |_|  \\_/\\_/\\___/\n" +
                "                                        " +
                " \n ######                                                                                                                          \n" +
                " #     # ###### ###### #####  ###### #####     ##### #    #   ##   #    #    #   #  ####  #    #    ##### #    # # #    # #    # \n" +
                " #     # #      #      #    # #      #    #      #   #    #  #  #  ##   #     # #  #    # #    #      #   #    # # ##   # #   #  \n" +
                " #     # #####  #####  #    # #####  #    #      #   ###### #    # # #  #      #   #    # #    #      #   ###### # # #  # ####   \n" +
                " #     # #      #      #####  #      #####       #   #    # ###### #  # #      #   #    # #    #      #   #    # # #  # # #  #   \n" +
                " #     # #      #      #      #      #   #       #   #    # #    # #   ##      #   #    # #    #      #   #    # # #   ## #   #  \n" +
                " ######  ###### ###### #      ###### #    #      #   #    # #    # #    #      #    ####   ####       #   #    # # #    # #    # \n" +
                "                                                                                                                                 \n +" +
                "You come round on the floor of an even wetter room. The lift doors behind you are completely inoperative. The floor is an inch deep in water. \n You have a large egg sized lump on the back of your head. The only exit , to the south , has a lock with a green escutcheon.";


        String room14 = "As the ancient stone door swings back and you enter the room is almost completely dark. In the gloom in one corner you see a dishevelled figure. You call out \n quietly and the figure stirs. When they look up you realise it is your old mentor Brian the Blessed. His face has a look of disbelief. \n 'Is that really you Thomas my boy ?' \n His eyes begin to tear up. He stands slowly and uncertainly. \n 'I never thought I would see anothr living soul again after Chymidea locked me in here.' \n 'We need to get out of here immediately. I dont suppose you found my trusty Marshalltown on your way down here have you ? Its out only hope. ";

        String room1 = "The maintenance team obviously haven't been down here for a while . The walls are damp and the carpet squelches, the ceiling looks like it is about to collapse and parts of it hang down and drips \n  ";

        String room2 = "The dilapidation continues. The number of different forms of mold on the walls would be a mycologists dream.";

        String room3 = "The carpet in this room has large holes where the material appears to have been eaten. The ceiling tiles are almost completely gone and those that remain are dark and swollen";

        String room4 = "There are slugs and snails gathering in one corner of this room where a pile of something rotting appears to be disassembling as you watch. The carpet seems to have given way to a rough stone floor and the walls show rough stone blocks behind the crumbling plaster. ";

        String room5 = "The air is getting decidedly chilly now and yes still seems wet. The stone walls are green and in places the floor is slippery. There is a patch of some form of lquid in the centre you really should avoid. ";

        String room6 = "This room looks like it was used for storage as there is only one way in and out and the walls are lined with rotting wooden shelves. some of which have collapsed. The ait feels unhealthy. ";

        String room9 = "The water logged floor continues in this room. There is a dark green algae floating in some places.";

        String room10 = "As you enter this room you are shocked to find the wall to the north and west are not there. or rather they are there but they are made from water. Outside of this bubble you see fishes swimming and the sea bed disappearing \n into the dim distance. There is not much light indicating that you are at some depth.";

        String room11 = "The aquarium theme continues in this room where the west and south walls are water. You see some sort of large predatory fish peering in and giving you quite a lot of attention  that makes you feel uncomfortable. ";

        String room12 = "The walls here return to solid rock much to your relief. However the water on the floor is at least an inch deeper. There are small stalactites on the ceiling that are all dripping. ";

        String room13 = "Another closed off room where water is visibly seeping through the rock walls and running down. The running water sound is all pervasive now. It makes you feel quite desperate. ";

        this.map = new ArrayList<Room>();

        Inventory shoppingList = new Inventory();
        //Level 1
        map.add(new Room("Zero", room0, 1, -100, -100, -100, shoppingList.getItems(List.of()), 5, 5));
        map.add(new Room("One", room1, -3, 0, -100, 2, shoppingList.getItems(List.of()), 4, 5));
        map.add(new Room("Two", room2, -100, -100, 1, -100, shoppingList.getItems(List.of("greenkey", "crabs")), 4, 4));
        map.add(new Room("Three", room3, -100, 1, 4, -100, shoppingList.getItems(List.of("cog")), 3, 5));
        map.add(new Room("Four", room4, -100, -100, 5, 3, shoppingList.getItems(List.of("nothing")), 3, 6));
        map.add(new Room("Five", room5, 6, -7, -100, 4, shoppingList.getItems(List.of("red-herring", "towel", "nothing")), 3, 7));
        map.add(new Room("Six", room6, -100, 5, -100, -100, shoppingList.getItems(List.of("bluekey")), 2, 7));
        map.add(new Room("Seven", room7, 5, -100, -100, -100, shoppingList.getItems(List.of("nothing")), 4, 7));

        //Level 2
        map.add(new Room("Eight", room8, -100, 9, -100, -100, shoppingList.getItems(List.of("fish", "towel", "nothing")), 6, 7));
        map.add(new Room("Nine", room9, 8, -100, -14, 10, shoppingList.getItems(List.of("nothing")), 7, 7));
        map.add(new Room("Ten", room10, -100, 11, 9, -100, shoppingList.getItems(List.of("nothing")), 7, 6));
        map.add(new Room("Eleven", room11, 10, -100, 12, -100, shoppingList.getItems(List.of("redkey")), 8, 6));
        map.add(new Room("Twelve", room12, 9, -13, -100, 11, shoppingList.getItems(List.of("nothing")), 2, 7));
        map.add(new Room("Thirteen", room13, 12, -100, -100, -100, shoppingList.getItems(List.of("blackkey", "trowel")), 9, 7));
        map.add(new Room("Fourteen", room14, -100, -100, -100, -9, shoppingList.getItems(List.of("nothing")), 7, 8));

        //Player
        player = new Character("Thomas", "a less than loveable archaeologist", shoppingList.getItems(List.of("rope", "oil", "spike")), Role.PLAYER);


    }

    public ArrayList<Room> getMap() {
        return map;
    }

}
