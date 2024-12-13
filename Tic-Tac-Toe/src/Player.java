public class Player {
    private final String name;
    private final char symbol;

    public Player(final String name, final char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

}
