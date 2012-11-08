public class Result {

    private final Optional<Player> winner;
    private final boolean draw;

    private Result() {
        this.draw = true;
        this.winner = Optional.absent();
    }

    private Result(Player winner) {
        this.winner = Optional.of(winner);
        this.draw = false;
    }

    public static Result draw() {
        return new Result();
    }

    public static Result win(Player winner) {
        return new Result(winner);
    }

    public boolean hasWinner() {
        return !draw;
    }

    public Player getWinner() {
        return winner.get();
    }

    public String toString() {
        return (draw) ? "Draw." : winner.get() + " won!";
    }
}
