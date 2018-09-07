package bigbangbomb;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Agbonxoft Prince
 */


public class SquarePanel extends JPanel {
    SquarePanel() {
        setBorder(BorderFactory.createLineBorder(Color.white));
        setBackground(Color.black);
        System.out.println("5\tcreateNextpanel Called and Panel is returned");
    }
}
