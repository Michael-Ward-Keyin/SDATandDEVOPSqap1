package michael;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    void testAddGame() {
        Cart cart = new Cart();
        Game game = new Game("Test Game", 19.99);
        cart.addGame(game);
        assertEquals(1, cart.getItems().size());
        assertTrue(cart.getItems().contains(game));
    }

    @Test
    void testRemoveGame() {
        Cart cart = new Cart();
        Game game = new Game("Remove Me", 9.99);
        cart.addGame(game);
        boolean removed = cart.removeGame(game);
        assertTrue(removed);
        assertEquals(0, cart.getItems().size());
    }

    @Test
    void testCartTotal() {
        Cart cart = new Cart();
        cart.addGame(new Game("Game A", 10.0));
        cart.addGame(new Game("Game B", 5.5));
        assertEquals(15.5, cart.getTotal(), 0.001);
    }

    @Test
    void testRemoveGameThatDoesNotExist() {
        Cart cart = new Cart();
        Game game = new Game("Nonexistent", 10.0);
        assertFalse(cart.removeGame(game)); // Negative scenario
    }
}
