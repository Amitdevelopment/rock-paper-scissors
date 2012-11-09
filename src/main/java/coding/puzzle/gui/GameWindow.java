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
    private PlayerPanel player2Panel;
    private Label resultAnnouncement;
    private GameController gameController;
    private JPanel playersPanel;
    private Label score;
    private JPanel topPanel;

    public GameWindow() {
        setTitle("Rock Paper Scissors!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(440, 210);
        setLayout(new BorderLayout());

        addTopPanel();
        addSettingsMenu();
        createGameController();
        addPlayerPanels();
    }

    private void addPlayerPanels() {
        playersPanel = new JPanel();
        add(playersPanel, BorderLayout.WEST);
        playersPanel.setLayout(new FlowLayout());

        player1Panel = new HumanPlayerPanel(Player.PLAYER1, gameController);
        player2Panel = new ComputerPlayerPanel(Player.PLAYER2, gameController);
        playersPanel.add(player1Panel);
        playersPanel.add(player2Panel);
    }

    private void createGameController() {
        gameController = new GameController();
        gameController.setGameWindow(this);
        score.setText("Score: 0-0");
    }

    private void addTopPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);

        resultAnnouncement = new Label();
        resultAnnouncement.setForeground(Color.BLUE);
        topPanel.add(resultAnnouncement, BorderLayout.CENTER);

        score = new Label();
        score.setSize(400, 20);
        topPanel.add(score, BorderLayout.EAST);
    }

    private void addSettingsMenu() {
        menuBar = new JMenuBar();

        menu = new JMenu("Options");
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

    public void showScore(int scorePlayer1, int scorePlayer2) {
        score.setText("Score: " + scorePlayer1 + "-" + scorePlayer2);
    }

    private class ComputerVsComputer extends AbstractAction {
        public ComputerVsComputer() {
            super("Computer vs Computer");
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            createGameController();
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
            createGameController();
            player1Panel = new HumanPlayerPanel(Player.PLAYER1, gameController);
            recreatePlayersPanel();
        }
    }

    private void recreatePlayersPanel() {
        player2Panel = new ComputerPlayerPanel(Player.PLAYER2, gameController);
        playersPanel.removeAll();
        playersPanel.add(player1Panel);
        playersPanel.add(player2Panel);
        playersPanel.revalidate();
        player2Panel.clearMoveDisplay();
    }

}
