import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    private Game game;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem playerVsComputerMenuItem;
    private JRadioButtonMenuItem computerVsComputerMenuItem;

    public GameWindow () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new JLabel("hi there :D"));
        setLayout(new FlowLayout());
        pack();
        setVisible(true);

        menuBar = new JMenuBar();

        menu = new JMenu("Settings");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Set the type of game");
        menuBar.add(menu);

        ButtonGroup group = new ButtonGroup();
        playerVsComputerMenuItem = new JRadioButtonMenuItem("Player vs Computer");
        playerVsComputerMenuItem.setSelected(true);
        playerVsComputerMenuItem.setMnemonic(KeyEvent.VK_P);
        group.add(playerVsComputerMenuItem);

        menu.add(playerVsComputerMenuItem);

        computerVsComputerMenuItem = new JRadioButtonMenuItem("Computer vs Computer");
        computerVsComputerMenuItem.setMnemonic(KeyEvent.VK_C);
        group.add(computerVsComputerMenuItem);

        menu.add(computerVsComputerMenuItem);

        setJMenuBar(menuBar);

        game = new Game();
    }
}
