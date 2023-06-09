import java.util.ArrayList;

public class Character {

    String name;
    String description;
    ArrayList<Items> characterInventory;

    Role role;

    public Character(String name, String description, ArrayList<Items> characterInventory,Role role) {
        //       super(aName, aDescription);
        this.name = name;
        this.description = description;
        this.characterInventory = characterInventory;
        this.role = role;
}}
