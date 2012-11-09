package coding.puzzle.domain;

import org.fest.assertions.Assertions;
import org.junit.Test;
import coding.puzzle.domain.*;

public class GameTest {

    @Test
    public void whenPlayer1ChoosesScissorsAndPlayer2ChoosesRockThenPlayer2Wins() {
        Game game = new Game();
        Result result = game.player1(Move.SCISSORS).player2(Move.ROCK).play();
        Assertions.assertThat(result.hasWinner()).isTrue();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER2);
    }

    @Test
    public void whenPlayer1ChoosesRockAndPlayer2ChoosesScissorsThenPlayer1Wins() {
        Game game = new Game();
        Result result = game.player1(Move.ROCK).player2(Move.SCISSORS).play();
        Assertions.assertThat(result.hasWinner()).isTrue();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER1);
    }

    @Test
    public void whenPlayer1ChoosesScissorsAndPlayer2ChoosesPaperThenPlayer1Wins() {
        Game game = new Game();
        Result result = game.player2(Move.PAPER).player1(Move.ROCK).play();
        Assertions.assertThat(result.hasWinner()).isTrue();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER2);
    }

    @Test
    public void whenPlayer1ChoosesPaperAndPlayer2ChoosesScissorsThenPlayer2Wins() {
        Game game = new Game();
        Result result = game.player1(Move.PAPER).player2(Move.SCISSORS).play();
        Assertions.assertThat(result.hasWinner()).isTrue();
        Assertions.assertThat(result.getWinner()).isEqualTo(Player.PLAYER2);
    }

    @Test
    public void whenBothPlayersChooseRockThereIsADraw() {
        Game game = new Game();
        Result result = game.player1(Move.ROCK).player2(Move.ROCK).play();
        Assertions.assertThat(result.hasWinner()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void whenThereIsADrawItIsIllegalToGetTheWinner() {
        Game game = new Game();
        Result result = game.player1(Move.ROCK).player2(Move.ROCK).play();
        result.getWinner();
    }

    @Test
    public void canPlayPlayerAgainstComputer() {
        Game game = new Game();
        Result result = game.player1(Move.ROCK).player2(MoveGenerator.generate()).play();
        System.out.println(result);
    }

    @Test
    public void canPlayComputerAgainstComputer() {
        Game game = new Game();
        Result result = game.player1(MoveGenerator.generate()).player2(MoveGenerator.generate()).play();
        System.out.println(result);
    }
    /**
     * TODO:
     *  UI
     *  type-safety in game play (set both players)
     *  player vs computer (make it impossible to be player1 and then player2) and computer vs computer
     */

}
