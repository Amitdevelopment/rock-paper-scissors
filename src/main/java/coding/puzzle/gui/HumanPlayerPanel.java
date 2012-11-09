package coding.puzzle.gui;

import coding.puzzle.domain.Move;
import coding.puzzle.domain.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanPlayerPanel extends PlayerPanel {
    public HumanPlayerPanel(Player player, GameController gameController) {
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
        JButton button = new JButton(move.name());
        button.setBounds(50, 60, 80, 30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                gameController.setPlayerMove(player, move);
                displayMove(move);
            }
        });
        return button;
    }

}
