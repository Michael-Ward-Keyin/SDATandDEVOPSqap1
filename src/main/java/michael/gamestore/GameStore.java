package michael.gamestore;

public class GameStore {
    private List<Game> catalog;

    public GameStore() {
        catalog = new ArrayList<>();
        catalog.add(new Game("italian plumber simulator", "129.99"));
        catalog.add(new Game("fast blue hedgehog", "39.99"));
        catalog.add(new Game("italian plumber driving simulator", "129.99"));
    }

    public List<Game> browseGames() {
        return Collections.unmodifiableList(catalog);
    }

    public boolean purchase(Cart cart) {
        if (cart.getItems().isEmpty()) return false;
        cart.clear();
        return true;
    }
}