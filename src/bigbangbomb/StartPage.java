package bigbangbomb;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class StartPage {

    private static JButton startBtn, exitBtn, helpBtn;
    private static JPanel startPagePanel;
    private static GridBagConstraints grid;

    /**
     * this helps to configure the components that are set within the start page
     * which can also be regarded as the home page.
     *
     * @return JPanel this returns the start page panel
     */
    public static JPanel configureStartPagePanel() {
        startPagePanel = new JPanel();
        startPagePanel.setLayout(new GridBagLayout());
        grid = new GridBagConstraints();

        startBtn = new JButton("start game");
        startBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        startBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        startBtn.setBackground(Color.DARK_GRAY);
        startBtn.setForeground(Color.WHITE);
        grid.gridx = 0;
        grid.gridy = 0;
        grid.insets = new Insets(3, 3, 3, 3);
        startPagePanel.add(startBtn, grid);

        helpBtn = new JButton("instructions");
        helpBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        helpBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        helpBtn.setBackground(Color.DARK_GRAY);
        helpBtn.setForeground(Color.WHITE);
        grid.gridx = 0;
        grid.gridy = 1;
        grid.insets = new Insets(3, 3, 3, 3);
        startPagePanel.add(helpBtn, grid);

        exitBtn = new JButton("exit game");
        exitBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        exitBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        exitBtn.setBackground(Color.DARK_GRAY);
        exitBtn.setForeground(Color.WHITE);
        grid.gridx = 0;
        grid.gridy = 2;
        grid.insets = new Insets(3, 3, 3, 3);
        startPagePanel.add(exitBtn, grid);

        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * when an action is performed on the start button, we want to
                 * hide start page within the frame and display the squares
                 * container, which is holding all of the grid.
                 *
                 * we also want the notify bar that displays the number of bombs
                 * and life remaining, when all of these are displayed, we also
                 * want the frame to fit exactly to the size of the square
                 * container, hence we call the pack of square frame
                 */

                startPagePanel.setVisible(false);

                // get the grid container & remove all of it's component
                SquareFrame.squareContainer().removeAll();

                // reconfigure the grid container and display it
                SquareFrame.getConfigureGameSquares();
                SquareFrame.squareContainer().setVisible(true);
                SquareFrame.getNotifyBar().setVisible(true);

                BigBangBomb.packSquareFrame();
            }
        });

        helpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = ("MIND BING\n\n"
                        + "Sets of grid are displayed, some are containing a bomb"
                        + " and others are not. A user is expected to select all grids"
                        + "\n\nRULES\n\n"
                        + "Grids containing bombs should be right clicked twice\n"
                        + "When a grid not containing a bomb is right clicked twice, there"
                        + " will be a reduction in the players life\n"
                        + "Grids not containing bomb should be left clicked once\n\n"
                        + "NOTE\n\n"
                        + "When a player right clicks ( twice ) a grid containing a bomb, the"
                        + "bomb will be neutralized, there will be no need for such grid to\n"
                        + "be clicked again\n"
                        + "When a player clicks on a grid not containing a bomb, and when"
                        + " a player neutralizes a bomb, grids surrounding the previously\n"
                        + "clicked grid will be checked for bombs, if bomb is found, it will"
                        + " be calculated and displayed in the notification bar.\n"
                        + "Players current life is also displayed in the notification bar.");
                JOptionPane.showMessageDialog(
                        null, message, "Instructions", JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * when an action is performed on the exit button, application
                 * should close up.
                 */
                System.exit(0);
            }
        });

        return startPagePanel;
    }
    
}
