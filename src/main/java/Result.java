public class Result {

    private Player winner;
    private final boolean draw;

    private Result(Player winner) {
        this.winner = winner;
        this.draw = false;
    }

    private Result() {
        this.draw = true;
    }

    public boolean isDraw() {
        return draw;
    }

    public static Result win(Player winner) {
        return new Result(winner);
    }

    public Player getWinner() {
        return winner;
    }

    public static Result draw() {
        return new Result();
    }
}
