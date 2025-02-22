import java.util.*;

class Card {
    String symbol;
    int number;
    Card(String symbol, int number) { this.symbol = symbol; this.number = number; }
    public String toString() { return symbol + "-" + number; }
}

public class CardCollectionSystem {
    static List<Card> cards = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Card 2. Search 3. Display 4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> {
                    System.out.print("Symbol: ");
                    String symbol = scanner.nextLine();
                    System.out.print("Number: ");
                    int number = scanner.nextInt();
                    cards.add(new Card(symbol, number));
                }
                case 2 -> {
                    System.out.print("Symbol: ");
                    String s = scanner.nextLine();
                    cards.stream().filter(c -> c.symbol.equalsIgnoreCase(s)).forEach(System.out::println);
                }
                case 3 -> cards.forEach(System.out::println);
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

