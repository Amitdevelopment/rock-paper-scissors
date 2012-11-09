package coding.puzzle.gui;

import coding.puzzle.domain.Move;
import coding.puzzle.domain.MoveGenerator;
import coding.puzzle.domain.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerPlayerPanel extends PlayerPanel {

    public ComputerPlayerPanel(final Player player, final GameController gameController) {
        super(player, gameController);
        setBorder(BorderFactory.createTitledBorder("Robot player"));

        JButton button = new JButton("Secret computer move");
        add(button);
        button.setBounds(50, 60, 80, 30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Move move = MoveGenerator.generate();
                gameController.setPlayerMove(player, move);
                displayMove(move);
            }
        });
    }

}
