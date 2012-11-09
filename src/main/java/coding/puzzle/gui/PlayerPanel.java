package coding.puzzle.gui;

import coding.puzzle.domain.Move;
import coding.puzzle.domain.Player;

import javax.swing.*;
import java.awt.*;

class PlayerPanel extends JPanel {
    protected Player player;
    protected GameController gameController;
    protected final Label chosenMove = new Label();

    public PlayerPanel(Player player, GameController gameController) {
        setLayout(new BorderLayout());
        this.player = player;
        this.gameController = gameController;
        add(chosenMove, BorderLayout.PAGE_START);
        gameController.setPlayerPanel(player, this);
    }

    protected void displayMove(Move move) {
        this.chosenMove.setText(player.getName() + " played: " + move.getName());
        updateUI();
    }

    public void clearMove() {
        chosenMove.setText("");
    }
}
