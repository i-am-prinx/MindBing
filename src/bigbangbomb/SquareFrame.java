package bigbangbomb;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Agbonxoft Prince
 */
/**
 * This application will share just one frame
 */
public class SquareFrame extends JFrame {

    private static JPanel square;
    private static JPanel startPagePanel = StartPage.configureStartPagePanel();
    private static JPanel restartPagePanel = RestartPage.getRestartPagePanel();
    private static JPanel notifyBar, levelCompletePanel;

    SquareFrame() {
        super("*-Mind Bing-*");
        setLayout(new BorderLayout());

        levelCompletePanel = new JPanel();
        levelCompletePanel.setVisible(false);

        EventNotifier.configureNotificationBar();
        notifyBar = EventNotifier.getNotificationBar();

        square = new JPanel();
        square.setVisible(false);
        restartPagePanel.setVisible(false);
        notifyBar.setVisible(false);

        add(restartPagePanel, BorderLayout.NORTH);
        add(square, BorderLayout.CENTER);
        add(notifyBar, BorderLayout.SOUTH);
        add(startPagePanel, BorderLayout.WEST);
        add(levelCompletePanel, BorderLayout.EAST);
        setVisible(true);

        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * helps to configure the grid system. This dynamically aligns all of the
     * grid to fit in to their container
     */
    private static void configureGameSquares() {
        square.setLayout(new MigLayout());

        // calling the grid system.
        JPanel[][] fp = new GridDimension().callNextGrid();

        // computing the calculations to align grid system accordingly
        for (int i = 0; i < fp.length; i++) {
            for (int j = fp[i].length - 1; j > 0; j--) {
                if (j == 1) {
                    System.out.print("#  \n");
                    square.add(fp[i][j], "width 30:80:80, height 30:80:80, wrap");
                } else {
                    System.out.print("#  ");
                    square.add(fp[i][j], "width 30:80:80, height 30:80:80");
                }
            }
        }
    }

    /**
     * this configures level complete panel
     */
    public static void configureLevelCompletePanel() {
        levelCompletePanel.setLayout(new MigLayout());
        levelCompletePanel.setVisible(true);
        String[] completeChar = {
            "l", "e", "v", "e", "l", "  ",
            "c", "o", "m", "p", "l", "e", "t", "e"
        };

        // panel to hold level complete label
        JPanel completePanel = new JPanel();
        completePanel.setLayout(new MigLayout());

        /**
         * this will increment the grid row and column before displaying the
         * grid squareContainer holding and displaying the incremented values
         * for rows and column
         */
        JButton nextLevelBtn = new JButton("next level");
        nextLevelBtn.setBackground(Color.DARK_GRAY);
        nextLevelBtn.setForeground(Color.WHITE);
        nextLevelBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nextLevelBtn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        nextLevelBtn.setBounds(5, 5, 5, 5);

        nextLevelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                levelCompletePanel.setVisible(false);   // hide level complete panel
                GridDimension.increaseRowsNcols();      // increase grid dimension
                
                /**
                 * reset bombs around from previous play 
                 */
                EventNotifier.resetLifeRemaining();
                EventNotifier.resetBombAroundNotify();
                EventNotifier.setLife(Player.getGameLife());
                EventNotifier.setBombAroundSquare(0);

                // get the grid container & remove all of it's component
                squareContainer().removeAll();
                EventNotifier.hideSMFN();       // hide bomb neutralized message
                EventNotifier.hideSMFRL();      // hide life reduced message

                // reconfigure the grid container and display it
                getConfigureGameSquares();
                squareContainer().setVisible(true);
                getNotifyBar().setVisible(true);

                BigBangBomb.packSquareFrame();
            }
        });

        /**
         * configuring home button... this button will act like the button in
         * restart page. it will trigger the display of the start page.
         */
        JButton homeBtn = new JButton("home");
        homeBtn.setBackground(Color.DARK_GRAY);
        homeBtn.setForeground(Color.WHITE);
        homeBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        homeBtn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        homeBtn.setBounds(5, 5, 5, 5);

        homeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.resetGameLife();   // helps to reset game life to initial
                RestartPage.homeBtnConfiguration(); // returns to the start page
                EventNotifier.hideSMFN();       // hide bomb neutralized message
                EventNotifier.hideSMFRL();      // hide life reduced message
                levelCompletePanel.setVisible(false); // making level complete visible
                BigBangBomb.packSquareFrame();  // main frame should take the size of panel
            }
        });

        JLabel eachCharlbl;

        for (int i = 0; i < completeChar.length; i++) {
            String letter = completeChar[i];
            eachCharlbl = new JLabel(letter);
            eachCharlbl.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
            eachCharlbl.setForeground(Color.MAGENTA);

            /**
             * this is to make a little pause before display, so it will look
             * like an animation.
             */
//            try{
//                Thread.sleep(100);
//            } catch(Exception Err) {
//                System.out.println(
//                 "Error occured while trying to display level complete panel");
//            }
            completePanel.add(eachCharlbl, "push");
            System.out.println(i);
        }

        /**
         * adding buttons and message label to level complete panel
         */
        levelCompletePanel.add(completePanel, "push, wrap");
        levelCompletePanel.add(nextLevelBtn, "push 2");
        levelCompletePanel.add(homeBtn, "push");
    }

    /**
     * allows other classes to be able to use levelCompletePanel
     *
     * @return JPanel returning actual levelCompletePanel that is added to frame
     */
    public static JPanel getlevelCompletePanel() {
        return levelCompletePanel;
    }

    /**
     * allow other classes to get to use the square, which literally holds game
     * grid
     *
     * @return JPanel; the container that holds every grid computed
     */
    public static JPanel squareContainer() {
        return square;
    }

    /**
     * hides the square container holding computed grid
     */
    public static void hideSquareContainer() {
        square.setVisible(false);
    }

    /**
     * reveals the square container holding computed grid
     */
    public static void showSquareContainer() {
        square.setVisible(true);
    }

    /**
     * allows other classes to use restart page panel that has been added to
     * frame
     *
     * @return JPanel returns restart page panel that is contained within main
     * frame
     */
    public static JPanel getRestartPage() {
        return restartPagePanel;
    }

    /**
     * allows other classes to use notify bar panel that has been added to frame
     *
     * @return JPanel returns notify bar panel that is contained within main
     * frame
     */
    public static JPanel getNotifyBar() {
        return notifyBar;
    }

    /**
     * allows other classes to use start page panel that has been added to frame
     *
     * @return JPanel returns start page panel that is contained within main
     * frame
     */
    public static JPanel getStartPagePanel() {
        return startPagePanel;
    }

    /**
     * allows other class to use this method to reconfigure the grid system.
     * example of when this is to be called is when a player want to restart
     * game after a game over has been encountered.
     */
    public static void getConfigureGameSquares() {
        configureGameSquares();
    }
}
