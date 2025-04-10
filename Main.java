import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int numPlayers = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Enter number of players (must be a positive integer):");
                    numPlayers = scanner.nextInt();
                    scanner.nextLine();
                    if (numPlayers > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid number of players. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            List<Playerentity> players = new ArrayList<>();
            Dice dice = new Dice();

            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Enter name for Player " + (i + 1) + ":");
                players.add(new Player(scanner.nextLine(), dice));
            }

            Board board = new Board();
            Gamestate gameState = new Gamestate();
            Timemanager timer = new Timemanager();
            Leaderboard leaderboard = new Leaderboard();
            gameState.startGame();

            boolean gameWon = false;
            while (!gameWon) {
                for (Playerentity player : players) {
                    System.out.println(player.getName() + "'s turn. Press enter to roll the dice...");
                    scanner.nextLine();
                    int diceValue = dice.roll();
                    System.out.println(player.getName() + " rolled: " + diceValue);
                    player.move(diceValue, board);
                    System.out.println(player.getName() + " moved to position: " + player.getPosition());

                    if (((Player) player).hasWon()) {
                        System.out.println("🏁 " + player.getName() + " wins!");
                        leaderboard.addWinner(player.getName());
                        gameWon = true;
                        break;
                    }
                }
            }

            timer.endGame();
            gameState.endGame();
            gameState.printStats();
            leaderboard.displayLeaderboard();

            System.out.println("Game over! Do you want to play again? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
