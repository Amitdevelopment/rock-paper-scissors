package coding.puzzle.domain;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class GameTest {

//Wouldn't compile unless both players play
//    @Test
//    public void bothPlayersMustPlay() {
//        Game.play(Game.newMove().player1(Move.ROCK));
//        Game.play(Game.newMove().player2(Move.ROCK));
//        Game.play(Game.newMove().player1(Move.ROCK).player1(Move.SCISSORS));
//    }

    @Test
    public void whenPlayer1ChoosesScissorsAndPlayer2ChoosesRockThenPlayer2Wins() {
        Result result = Game.play(Game.newMove().player1(Move.SCISSORS).player2(Move.ROCK));
        Assertions.assertThat(result.hasWinner()).isTrue();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER2);
    }

    @Test
    public void whenPlayer1ChoosesRockAndPlayer2ChoosesScissorsThenPlayer1Wins() {
        Result result = Game.play(Game.newMove().player1(Move.ROCK).player2(Move.SCISSORS));
        Assertions.assertThat(result.hasWinner()).isTrue();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER1);
    }

    @Test
    public void whenPlayer1ChoosesScissorsAndPlayer2ChoosesPaperThenPlayer1Wins() {
        Result result = Game.play(Game.newMove().player2(Move.PAPER).player1(Move.ROCK));
        Assertions.assertThat(result.hasWinner()).isTrue();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER2);
    }

    @Test
    public void whenPlayer1ChoosesPaperAndPlayer2ChoosesScissorsThenPlayer2Wins() {
        Result result = Game.play(Game.newMove().player1(Move.PAPER).player2(Move.SCISSORS));
        Assertions.assertThat(result.hasWinner()).isTrue();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER2);
    }

    @Test
    public void whenBothPlayersChooseRockThereIsADraw() {
        Result result = Game.play(Game.newMove().player1(Move.ROCK).player2(Move.ROCK));
        Assertions.assertThat(result.hasWinner()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void whenThereIsADrawItIsIllegalToGetTheWinner() {
        Result result = Game.play(Game.newMove().player1(Move.ROCK).player2(Move.ROCK));
        result.getWinner();
    }
}
