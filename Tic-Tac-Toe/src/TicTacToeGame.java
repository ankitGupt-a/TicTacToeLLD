import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private final List<Player> players;
    private final Board board;
    private int currentTurn;
    private int totalMoves;
    private final int dimensionOfBoard;
    final static HashSet<String> setName = new HashSet<>();
    final static HashSet<Character> set = new HashSet<>();

    Scanner scanner = new Scanner(System.in);

    private TicTacToeGame(final List<Player> players, final int boardSize) {
        this.players = players;
        this.board = new Board(boardSize);
        currentTurn = 0;
        totalMoves = 0;
        dimensionOfBoard = boardSize*boardSize;

    }

    public void startGame() {
        System.out.println("Game Started: enjoy");

        while(totalMoves < dimensionOfBoard) {
            System.out.println(players.get(currentTurn).getName() + " turns: pick a position");
            board.printBoard();
            int position = scanner.nextInt();

            if (board.checkAndMakeMove(players.get(currentTurn).getSymbol(), position)) {
                totalMoves++;
                if (board.checkWinner(players.get(currentTurn).getSymbol(), position)) {
                    System.out.println("Player " + players.get(currentTurn).getName() + " is the winner");
                    board.printBoard();
                    return;
                }
            } else {
                System.out.println("Invalid move for player " + players.get(currentTurn).getName() +" with symbol " + String.valueOf(players.get(currentTurn).getSymbol() + " : try again " ));
                continue;
            }
            currentTurn = (currentTurn + 1) % players.size();
        }

        System.out.println("Oops, Game is draw");
        board.printBoard();
    }

    public static class Builder {
        private final List<Player> players = new ArrayList<>();
        private int boardSize;

        public Builder addPlayers(final String name, final char symbol) {
            if (set.contains(symbol)) {
                throw new IllegalArgumentException("Symbol " + symbol + " is already taken.");
            }

            if (setName.contains(name)) {
                throw new IllegalArgumentException("Name " + name + " is already taken");
            }
            players.add(new Player(name, symbol));
            return this;
        }

        public Builder setBoardSize(final int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public TicTacToeGame build() {
            return new TicTacToeGame(players, boardSize);
        }
    }
}
