import java.util.Random;

public class MoveGenerator {
    private static Random rnd = new Random();

    public static Move generate() {
        int randomIndex = rnd.nextInt(Move.values().length);
        return Move.values()[randomIndex];
    }
}
