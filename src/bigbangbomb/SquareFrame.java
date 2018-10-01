package bigbangbomb;

import javax.swing.JFrame;
import java.awt.BorderLayout;
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
    private static JPanel notifyBar;

    SquareFrame() {
        super("*-Mind Bing-*");
        setLayout(new BorderLayout());

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
