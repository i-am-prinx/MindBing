package bigbangbomb;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Agbonxoft Prince
 *
 */
public class RestartPage {

    private static JPanel restartPage = new JPanel();
    private static JButton replayBtn, homeBtn, exitBtn;
    private static JLabel gameOverlbl, reasonlbl;

    /**
     * this will help to transfer restart page panel with other classes
     *
     * @return JPanel
     */
    public static JPanel getRestartPagePanel() {
        return restartPage;
    }

    /**
     * helps to configure all components that will be displayed within the
     * restart page panel
     *
     * @param reason
     */
    public static void configureRestartPage(String reason) {
        restartPage.setLayout(new MigLayout());

        gameOverlbl = new JLabel("GAME OVER");
        gameOverlbl.setFont(new Font(Font.MONOSPACED, Font.BOLD, 60));
        gameOverlbl.setForeground(Color.red);

        restartPage.add(gameOverlbl, "push, span, wrap, push");

        reasonlbl = new JLabel(reason);
        reasonlbl.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 18));
        reasonlbl.setForeground(Color.black);

        restartPage.add(reasonlbl, "wrap 2");

        replayBtn = new JButton("replay");
        replayBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        replayBtn.setBackground(Color.darkGray);
        replayBtn.setForeground(Color.green);

        restartPage.add(replayBtn, "push");

        homeBtn = new JButton("home");
        homeBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        homeBtn.setBackground(Color.darkGray);
        homeBtn.setForeground(Color.green);

        restartPage.add(homeBtn, "push");

        exitBtn = new JButton("exit");
        exitBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        exitBtn.setBackground(Color.darkGray);
        exitBtn.setForeground(Color.green);

        replayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPage.setVisible(false);

                // get the grid container & remove all of it's component
                SquareFrame.squareContainer().removeAll();

                // reconfigure the grid container and display it
                SquareFrame.getConfigureGameSquares();
                SquareFrame.squareContainer().setVisible(true);
                SquareFrame.getNotifyBar().setVisible(true);

                BigBangBomb.packSquareFrame();
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // when exit button is clicked, we want application to close up
                System.exit(0);
            }
        });

        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               homeBtnConfiguration();
            }
        });

        restartPage.add(exitBtn, "span, push");
        restartPage.setVisible(true);
    }

    /**
     * home buttons are used in several panel, instead of writing this same 
     * configuration for every of the home button we have in the application
     * it is best if one configuration can be shared amongst others.
     */
    public static void homeBtnConfiguration() {
        /**
         * when home button that is displayed within restart page is clicked we
         * want restart page to be hidden and start page ( which is representing
         * the home page ) to be displayed
         */
        int life = Player.getGameLife();
        restartPage.setVisible(false);

        /**
         * code below will help to reset bombs around and life remaining. this
         * is because we are starting a new game. so the figures need to be
         * changed to their initial value.
         */
        EventNotifier.resetLifeRemaining();
        EventNotifier.resetBombAroundNotify();
        EventNotifier.setLife(life);
        EventNotifier.setBombAroundSquare(0);
        EventNotifier.hideNotifierPanel();

        // displaying the start page panel and making sure the frame 
        // takes the size if the panel.
        SquareFrame.getStartPagePanel().setVisible(true);
        BigBangBomb.packSquareFrame();
    }
}
