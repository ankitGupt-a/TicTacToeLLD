import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGameInitializer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final HashSet<Character> set = new HashSet<>();
        TicTacToeGame.Builder builder = new TicTacToeGame.Builder();


        System.out.println("Welcome to the Tic-Tac-Toe game");
        System.out.println("Enter the number of players: ");
        final int numPlayers = scanner.nextInt();
        scanner.nextLine();


        for (int i=0; i<numPlayers; i++) {
            System.out.println("Enter the name of the player" + (i+1) + ": ");
            final String name = scanner.nextLine();

            System.out.println("Enter the symbol for the player " + (i+1) + ": ");
            final char symbol = scanner.nextLine().charAt(0);

            try {
                builder.addPlayers(name, symbol);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                i--;
            }
        }

        System.out.println("Enter the size of the board: ");
        final int boardSize = scanner.nextInt();
        builder.setBoardSize(boardSize);

        TicTacToeGame ticTacToeGame = builder.build();
        ticTacToeGame.startGame();

        scanner.close();
    }
}
