package coding.puzzle.gui;

import coding.puzzle.domain.*;

public class GameController {
    private Optional<Move> move1 = Optional.absent();
    private Optional<Move> move2 = Optional.absent();
    private final Game game = new Game();
    private GameWindow gameWindow;
    private PlayerPanel player1Panel;
    private PlayerPanel player2Panel;

    public void setPlayerMove(final Player player, final Move move) {
        if (!move1.isPresent() && !move2.isPresent()) resetDisplays();

        if (player == Player.PLAYER1) move1 = Optional.of(move);
        else if (player == Player.PLAYER2) move2 = Optional.of(move);

        if (move1.isPresent() && move2.isPresent()) playMoves();

    }

    private void playMoves() {
        final Result result = game.player1(move1.get()).player2(move2.get()).play();
        resetMoves();
        gameWindow.showResult(result);
    }

    private void resetDisplays() {
        player1Panel.clearMoveDisplay();
        player2Panel.clearMoveDisplay();
        gameWindow.clearResult();
    }

    private void resetMoves() {
        move1 = Optional.absent();
        move2 = Optional.absent();
    }

    public void setGameWindow(final GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void setPlayerPanel(final Player player, final PlayerPanel playerPanel) {
        if (player == Player.PLAYER1) player1Panel = playerPanel;
        else if (player == Player.PLAYER2) player2Panel = playerPanel;
    }
}
