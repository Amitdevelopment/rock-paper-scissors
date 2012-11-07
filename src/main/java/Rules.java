public class Rules {
    public static int compareMoves(Move player1Move, Move player2Move) {
        return (player2Move == Move.ROCK) ? -1 : 1;
    }
}
