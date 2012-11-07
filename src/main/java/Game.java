public class Game {
    private Move player1Move;
    private Move player2Move;

    public Game player1(Move player1Move) {
        this.player1Move = player1Move;
        return this;
    }

    public Game player2(Move player2Move) {
        this.player2Move = player2Move;
        return this;
    }

    public Result play() {
        double comparisonOfMoves = Rules.compareMoves(player1Move, player2Move);
        if (comparisonOfMoves == 0) return Result.draw();
        return (comparisonOfMoves > 0) ? Result.win(Player.PLAYER1) : Result.win(Player.PLAYER2);

    }
}
