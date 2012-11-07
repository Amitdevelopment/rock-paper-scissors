public class Rules {
    private static int n = Move.values().length;
    private static final int[][] winner = new int[n][n];

    static {
        defeats(Move.SCISSORS, Move.PAPER);
        defeats(Move.PAPER, Move.ROCK);
        defeats(Move.ROCK, Move.SCISSORS);
    }

    private static void defeats(Move move1, Move move2) {
        winner[move1.ordinal()][move2.ordinal()] = 1;
        winner[move2.ordinal()][move1.ordinal()] = -1;
    }

    public static int compareMoves(Move move1, Move move2) {
        return winner[move1.ordinal()][move2.ordinal()];
    }
}
