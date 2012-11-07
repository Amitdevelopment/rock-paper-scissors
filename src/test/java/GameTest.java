import org.fest.assertions.Assertions;
import org.junit.Test;

public class GameTest {

    @Test
    public void whenPlayer1ChoosesScissorsAndPlayer2ChoosesRockThenPlayer2Wins () {
        Game game = new Game();
        Result result = game.player1(Move.SCISSORS).player2(Move.ROCK).play();
        Assertions.assertThat(result.isDraw()).isFalse();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER2);
    }

    @Test
    public void whenPlayer1ChoosesScissorsAndPlayer2ChoosesPaperThenPlayer1Wins () {
        Game game = new Game();
        Result result = game.player1(Move.SCISSORS).player2(Move.PAPER).play();
        Assertions.assertThat(result.isDraw()).isFalse();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER1);
    }

    @Test
    public void whenBothPlayersChooseRockThereIsADraw () {
        Game game = new Game();
        Result result = game.player1(Move.ROCK).player2(Move.ROCK).play();
        Assertions.assertThat(result.isDraw()).isTrue();
    }
}
