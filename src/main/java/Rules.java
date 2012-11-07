import java.util.HashMap;
import java.util.Map;

public class Rules {

    private static Map<Move, Integer> positions = new HashMap<Move, Integer>();
    private static final Integer SIZE = Move.values().length;

    //if we view this as a cyclical array, each item defeats its right neighbor and is defeated by its left neighbor
    static {
        positions.put(Move.PAPER, 1);
        positions.put(Move.ROCK, 2);
        positions.put(Move.SCISSORS, 3);
    }

    public static int compareMoves (Move move1, Move move2) {
        if (move1 == move2) { return 0; }
        return isToTheLeftOf(move1, move2) ? 1 : -1;
    }

    private static boolean isToTheLeftOf (final Move move1, final Move move2) {
        return positions.get(move1) % SIZE == (positions.get(move2) + SIZE - 1) % SIZE;
    }
}
