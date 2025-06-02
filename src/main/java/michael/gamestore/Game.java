package michael;
/**
 * Represents a game in the store
 */
public class Game {
    private String title;
    private double price;
    /**
     * Makes a game with a title and a price
     * 
     * @param title
     * @param price
     */
    public Game(String title, double price) {
        this.title = title;
        this.price = price;
    }
    /**
     * Gets a games title
     * @return
     */
    public String getTitle() { return title; }
    /**
     * Gets a games price
     * @return
     */
    public double getPrice() { return price;}
}