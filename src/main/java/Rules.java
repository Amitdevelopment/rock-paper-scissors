public class Rules {
    public static int compareMoves (Move player1Move, Move player2Move) {
        if (player1Move == player2Move) { return 0; }
        return (player2Move == Move.ROCK) ? -1 : 1;
    }
}
