package bigbangbomb;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Agbonxoft Prince
 */
/**
 * frame that displays the grid system.
 */
public class SquareFrame extends JFrame {

    private static JPanel panel = new JPanel();
    private static JPanel notifyBar = EventNotifier.notificationBar();

    SquareFrame() {
        super("*- Mind~Bing -*");
        setLayout(new BorderLayout());

        JPanel[][] fp = new GridDimension().callNextGrid();

        panel.setLayout(new MigLayout());

        for (int i = 0; i < fp.length; i++) {
            for (int j = fp[i].length - 1; j > 0; j--) {
                if (j == 1) {
                    System.out.print("#  \n");
                    panel.add(fp[i][j], "width 30:80:80, height 30:80:80, wrap");
                } else {
                    System.out.print("#  ");
                    panel.add(fp[i][j], "width 30:80:80, height 30:80:80");
                }
            }
        }

        add(panel, BorderLayout.CENTER);
        add(notifyBar, BorderLayout.SOUTH);
        setVisible(true);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * this is returned so it's attributes can be used in other class files
     * attributes like ( width and height )
     *
     * @return JPanel
     */
    public static JPanel squareContainer() {
        return panel;
    }

    /**
     * * this main method will be removed from this file, it's just for testing
     * if the grid system is working as expected...
     *
     * @param args
     */
    public static void main(String args[]) {
        SquareFrame mindBing = new SquareFrame();
        mindBing.setSize(470, 500);     // increases the width to fit notifier text
    }
}
