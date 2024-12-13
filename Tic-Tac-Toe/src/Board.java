import java.util.HashSet;

public class Board {
    private final char[][] board;
    private final int boardSize;
    private final HashSet<Character> boardSymbols = new HashSet<>();
    private int count;

    public Board(final int boardSize) {
        this.board = new char[boardSize][boardSize];
        this.boardSize = boardSize;
        count = 0;
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                board[i][j] = (char) ('0' + count);
                count++;
            }
        }
    }

    public boolean checkWinner(final char c, final int position) {

        boolean rowCheck = false, colCheck = false, diagCheck = false, revDiagCheck = false;
        final int row = position/boardSize;
        final int col = position%boardSize;

        for (int i=0; i<boardSize; i++) {
            if (board[row][i] != c) {
                rowCheck = true;
            }

            if (board[i][col] != c) {
                colCheck = true;
            }

            if (board[i][i] != c) {
                diagCheck = true;
            }

            if (board[i][boardSize-i-1] != c) {
                revDiagCheck = true;
            }
        }

        return !rowCheck || !colCheck || !diagCheck || !revDiagCheck;

    }
    public void printBoard() {
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public boolean checkAndMakeMove(final char c, final int position) {
        final int row = position/boardSize;
        final int col = position%boardSize;
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize || board[row][col] < '0' || board[row][col] > (char) ('0' +count) || boardSymbols.contains(board[row][col])) {
            return false;
        }

        board[row][col] = c;
        boardSymbols.add(c);
        return true;
    }
}
