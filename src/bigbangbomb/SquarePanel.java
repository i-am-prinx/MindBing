package bigbangbomb;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Agbonxoft Prince
 */


public class SquarePanel {
    
    /**
     * this will be used to set the sizes of the panels that will be created,
     * which is better-off than hard coding the literals.
     */
    private final int squareSize = 100;
    
    
    /**
     * this creates a new JPanel with a square shape
     */
    private JPanel createPanel( ) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.white));
        panel.setBackground(Color.black);
        System.out.println("5\tcreateNextpanel Called and Panel is returned");
        return panel;
    }
    
    
    /**
     * this will call the createPanel method outside this class
     * @return JPanel
     */
    public JPanel callCreatePanel( ) {
        return this.createPanel( );
    }
}
