package michael;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Represents the store holding games and can do purchases
 * 
 */
public class GameStore {
    private List<Game> catalog;
    /**
     * Constructs the store and a few games
     * 
     */
    public GameStore() {
        catalog = new ArrayList<>();
        catalog.add(new Game("Elder Quest", 59.99));
        catalog.add(new Game("Galaxy War", 39.99));
        catalog.add(new Game("Mystic Lands", 49.99));
    }
    /**
     * Returns available games
     * 
     * @return
     */
    public List<Game> browseGames() {
        return Collections.unmodifiableList(catalog);
    }
    /**
     * Makes a purchase happen and clears the cart
     * 
     * @param cart
     * @return
     */
    public boolean purchase(Cart cart) {
        if (cart.getItems().isEmpty()) return false;
        cart.clear();
        return true;
    }
}
