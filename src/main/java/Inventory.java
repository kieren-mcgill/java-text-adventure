import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private Map<String, Items> items;

    public Inventory() {
        this.items = getItemsMap();
    }

    public ArrayList<Items> getItems(List<String> itemKeys) {
        ArrayList<Items> itemsList = new ArrayList<>();
        itemKeys.forEach(key -> itemsList.add(items.get(key)));
        return itemsList;
    }

    public static Map<String, Items> getItemsMap() {
        Map<String, Items> items = new HashMap<>();
        items.put("rope", new Items("rope", "a length of rope (rope)"));
        items.put("oil", new Items("oil", "a flask of oil (oil)"));
        items.put("spike", new Items("spike", "an iron spike (spike)"));
        items.put("trowel", new Items("trowel", "a beautiful Marshalltown trowel (trowel)"));
        items.put("cog", new Items("cog", "a mysterious corroded cog of unknown origin (cog)"));
        items.put("ruby", new Items("ruby", "a precious uncut ruby (ruby)"));
        items.put("greenkey", new Key("green-key","a key made of some precious green stone (green-key)",1,"north"));
        items.put("bluekey", new Key("blue-key","a key made of some precious blue stone (blue-key)",5,"south"));
        items.put("redkey", new Key("red-key","a key made of some precious red stone (red-key)",12,"south"));
        items.put("blackkey", new Key("black-key","a key made of some precious black stone (black-key)",9,"east"));
        items.put("fish", new Items("fish","a small golden fish (fish)"));
        items.put("towel", new Items("towel","an old, well worn towel (towel)"));
        items.put("crabs", new Items("crabs","a box of crustaceans (crabs)"));
        items.put("red-herring", new Items("red-herring","a deep red fish (red-herring)"));
        items.put("nothing", new Items("nothing", "there is nothing in this room"));
        return items;
    }



}
