package michael;

import java.util.List;
import java.util.Scanner;
/**
 * The main class containing the cli for the game store application
 * 
 */
public class Main {
    public static void main(String[] args) {
        GameStore store = new GameStore();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println(" Welcome to the Game Store!");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Browse Games");
            System.out.println("2. Add Game to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    List<Game> games = store.browseGames();
                    System.out.println("\nAvailable Games:");
                    for (int i = 0; i < games.size(); i++) {
                        System.out.printf("%d. %s - $%.2f%n", i + 1, games.get(i).getTitle(), games.get(i).getPrice());
                    }
                    break;

                case 2:
                    List<Game> catalog = store.browseGames();
                    System.out.println("\nEnter the number of the game to add to cart:");
                    for (int i = 0; i < catalog.size(); i++) {
                        System.out.printf("%d. %s - $%.2f%n", i + 1, catalog.get(i).getTitle(), catalog.get(i).getPrice());
                    }

                    try {
                        int gameChoice = Integer.parseInt(scanner.nextLine());
                        if (gameChoice > 0 && gameChoice <= catalog.size()) {
                            cart.addGame(catalog.get(gameChoice - 1));
                            System.out.println(" Game added to cart!");
                        } else {
                            System.out.println(" Invalid selection.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(" Please enter a number.");
                    }
                    break;

                case 3:
                    List<Game> cartItems = cart.getItems();
                    if (cartItems.isEmpty()) {
                        System.out.println(" Your cart is empty.");
                    } else {
                        System.out.println(" Your Cart:");
                        for (Game game : cartItems) {
                            System.out.printf("- %s ($%.2f)%n", game.getTitle(), game.getPrice());
                        }
                        System.out.printf("Total: $%.2f%n", cart.getTotal());
                    }
                    break;

                case 4:
                    if (store.purchase(cart)) {
                        System.out.println(" Purchase successful.");
                    } else {
                        System.out.println(" Your cart is empty.");
                    }
                    break;

                case 5:
                    System.out.println(" Goodbye");
                    running = false;
                    break;

                default:
                    System.out.println(" Invalid option. Try 1-5.");
            }
        }

        scanner.close();
    }
}
