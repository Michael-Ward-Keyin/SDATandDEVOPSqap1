package michael.gamestore;

import java.util.List;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GameStore store = new GameStore();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println( "Game Store" );

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Browse Games");
            System.out.println("2. Add Game to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out .print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: 
                    List<Game> games = store.browseGames();
                    System.out.println("Games: ");
                    for (int i = 0; i < games.size(); i++) {
                        System.out.printf("%d. %s - $%.2f%n",i + 1, games.get(i).getTitle(), games.get(i).getPrice());
                    }
                    break;

                case 2:
                    List<Game> catalog = store.browseGames();
                    System.out.println("Enter the number of games to add to cart: ");
                    for (int i = 0; i < catalog.size(); i++) {
                        System.out.printf("%d. %s - $%.2f%n", i + 1, games.get(i).getTitle(), games.get(i).getPrice());
                    }
                    int gameChoice = Integer.parseInt(scanner.nextLine());
                    if (gameChoice > 0 && gameChoice <= catalog.size()) {
                        cart.addGame(catalog.get(gameChoice-1));
                        System.out.println("Game added to cart");
                    } else {
                        System.out.println("Invalid selection");
                    }
                    break;
                
                case 3:
                    List<Game> cartItems = cart.getItems();
                    if (cartItems.isEmpty()) {
                        System.out.println("Cart is empty");
                    } else {
                        System.out.println("Your cart: ");
                        for (Game game : cartItems) {
                            System.out.printf("- %s ($%.2f)%n", game.getTitle(), game.getPrice());
                        }
                        System.out.printf("Total: $%.2f%n", cart.getTotal());
                    }
                    break;
                
                case 4:
                    if (store.purchase(cart)) {
                        System.out.println("Purchase successful");
                    } else {
                        System.out.println("Cart is empty");
                    }
                    break;
                
                case 5: 
                    System.out.println("Store closing");
                    running = false;
                    break;
                
                default:
                    System.out.println("invalid option");

            }
        }

        scanner.close();
    }
}
