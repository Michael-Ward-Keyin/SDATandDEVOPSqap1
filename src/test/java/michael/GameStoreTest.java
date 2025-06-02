package michael;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {

    @Test
    void testPurchaseSuccess() {
        GameStore store = new GameStore();
        Cart cart = new Cart();
        cart.addGame(new Game("Elder Quest", 59.99));
        boolean result = store.purchase(cart);
        assertTrue(result);
        assertEquals(0, cart.getItems().size()); // Cart should be cleared
    }

    @Test
    void testPurchaseFailsOnEmptyCart() {
        GameStore store = new GameStore();
        Cart cart = new Cart();
        boolean result = store.purchase(cart);
        assertFalse(result); // Negative scenario
    }

    @Test
    void testBrowseGamesReturnsDefaultCatalog() {
        GameStore store = new GameStore();
        assertEquals(3, store.browseGames().size()); // Elder Quest, Galaxy War, Mystic Lands
    }
}
