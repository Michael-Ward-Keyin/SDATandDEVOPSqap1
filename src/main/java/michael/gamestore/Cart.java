package michael.gamestore;

public class Cart {
    private List<Game> items = new ArreyList<>();

    public void addGame(Game game) {
        items.add(game);
    }

    public boolean removeGame(Game game) {
        items.add(game);
    }

    public double getTotal() {
        return items.stream().mapToDouble(Game::getPrice).sum();
    }

    public void clear() {
        items.clear();
    }

    public List<Game> getItems() {
        return Collections.unmodifiableList(items);
    }
}