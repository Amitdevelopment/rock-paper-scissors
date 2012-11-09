package coding.puzzle.gui;

import coding.puzzle.domain.Move;
import coding.puzzle.domain.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanPlayerPanel extends PlayerPanel {
    public HumanPlayerPanel(final Player player, final GameController gameController) {
        super(player, gameController);
        setBorder(BorderFactory.createTitledBorder("Human Player"));

        final JButton rockButton = createButton(Move.ROCK);
        final JButton paperButton = createButton(Move.PAPER);
        final JButton scissorsButton = createButton(Move.SCISSORS);
        add(rockButton, BorderLayout.WEST);
        add(paperButton, BorderLayout.CENTER);
        add(scissorsButton, BorderLayout.EAST);
    }

    private JButton createButton(final Move move) {
        final JButton button = new JButton(move.getName());
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                gameController.setPlayerMove(player, move);
                displayMove(move);
            }
        });
        return button;
    }

}
