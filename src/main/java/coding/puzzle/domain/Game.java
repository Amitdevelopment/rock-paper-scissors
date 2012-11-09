package coding.puzzle.domain;

public class Game<A, B> {
    private Move player1Move;
    private Move player2Move;

    private Game(final Move player1Move, final Move player2Move) {
        this.player1Move = player1Move;
        this.player2Move = player2Move;
    }

    private Game() {
    }

    public Game<Played, B> player1(final Move player1Move) {
        this.player1Move = player1Move;
        return new Game<Played, B>(player1Move, player2Move);
    }

    public Game<A, Played> player2(final Move player2Move) {
        this.player2Move = player2Move;
        return new Game<A, Played>(player1Move, player2Move);

    }

    public static Game<NotPlayed, NotPlayed> newMove() {
        return new Game<NotPlayed, NotPlayed>();
    }

    public static Result play(Game<Played, Played> game) {
        int comparisonOfMoves = Rules.compareMoves(game.player1Move, game.player2Move);
        if (comparisonOfMoves == 0) return Result.draw();
        return (comparisonOfMoves > 0) ? Result.win(Player.PLAYER1) : Result.win(Player.PLAYER2);
    }

    interface NotPlayed {
    }

    interface Played {
    }
}
