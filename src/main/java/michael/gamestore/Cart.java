package michael;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * represents the cart where the user stores games they want to purchase
 * 
 * Allows adding, removing and totaling games
 */
public class Cart {
    private List<Game> items = new ArrayList<>();
    /**
     * Adds a game to the cart
     * @param game
     */
    public void addGame(Game game) {
        items.add(game);
    }
    /**
     * Removes a game from the cart
     * @param game
     * @return
     */
    public boolean removeGame(Game game) {
        return items.remove(game);
    }
    /**
     * Gets the total price of all games in the cart
     * @return
     */
    public double getTotal() {
        return items.stream().mapToDouble(Game::getPrice).sum();
    }
    /**
     * Clears all games from the cart
     * 
     */
    public void clear() {
        items.clear();
    }

    public List<Game> getItems() {
        return Collections.unmodifiableList(items);
    }
}
