package coding.puzzle.gui;

import coding.puzzle.domain.Player;
import coding.puzzle.domain.Result;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private PlayerPanel player1Panel;
    private final PlayerPanel player2Panel;
    private final Label resultAnnouncement;
    private final GameController gameController;
    private final JPanel playersPanel;

    public GameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        setLayout(new BorderLayout());

        resultAnnouncement = new Label();
        resultAnnouncement.setForeground(Color.BLUE);
        add(resultAnnouncement, BorderLayout.PAGE_START);


        addSettingsMenu();

        gameController = new GameController();
        gameController.setGameWindow(this);

        playersPanel = new JPanel();
        add(playersPanel, BorderLayout.WEST);
        playersPanel.setLayout(new FlowLayout());

        player1Panel = new HumanPlayerPanel(Player.PLAYER1, gameController);
        player2Panel = new ComputerPlayerPanel(Player.PLAYER2, gameController);
        playersPanel.add(player1Panel);
        playersPanel.add(player2Panel);
    }

    private void addSettingsMenu() {
        menuBar = new JMenuBar();

        menu = new JMenu("Settings");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Set the type of game");
        menuBar.add(menu);

        final ButtonGroup group = new ButtonGroup();
        final JRadioButtonMenuItem playerVsComputerMenuItem = new JRadioButtonMenuItem(new PlayerVsComputerAction());

        playerVsComputerMenuItem.setSelected(true);
        playerVsComputerMenuItem.setMnemonic(KeyEvent.VK_P);
        group.add(playerVsComputerMenuItem);

        menu.add(playerVsComputerMenuItem);

        final JRadioButtonMenuItem computerVsComputerMenuItem = new JRadioButtonMenuItem(new ComputerVsComputer());
        computerVsComputerMenuItem.setMnemonic(KeyEvent.VK_C);
        group.add(computerVsComputerMenuItem);

        menu.add(computerVsComputerMenuItem);

        setJMenuBar(menuBar);
    }

    public void showResult(Result result) {
        resultAnnouncement.setText(result.toString());
        repaint();
    }

    public void clearResult() {
        resultAnnouncement.setText("");
    }

    private class ComputerVsComputer extends AbstractAction {
        public ComputerVsComputer() {
            super("Computer vs Computer");
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            player1Panel = new ComputerPlayerPanel(Player.PLAYER1, gameController);
            recreatePlayersPanel();
        }
    }

    private class PlayerVsComputerAction extends AbstractAction {

        public PlayerVsComputerAction() {
            super("Player vs Computer");
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            player1Panel = new HumanPlayerPanel(Player.PLAYER1, gameController);
            recreatePlayersPanel();
        }
    }

    private void recreatePlayersPanel() {
        playersPanel.removeAll();
        playersPanel.add(player1Panel);
        playersPanel.add(player2Panel);
        playersPanel.revalidate();
        player2Panel.clearMoveDisplay();
    }

}
