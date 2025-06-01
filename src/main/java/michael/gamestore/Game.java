package michael.gamestore;

public class Game {
    private String title;
    private double price;

    public Game(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price;}
}