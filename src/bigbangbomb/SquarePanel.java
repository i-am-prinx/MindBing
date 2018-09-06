package bigbangbomb;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Agbonxoft Prince
 */


public class SquarePanel extends JPanel {
    
    /**
     * this will be used to set the sizes of the panels that will be created,
     * which is better-off than hard coding the literals.
     */
    private final int squareSize = 50;
    
    
    /**
     * this creates a new JPanel with a square shape
     */
    private JPanel createPanel( ) {
        JPanel panel = new JPanel();
        setSize(this.squareSize, this.squareSize);
        setBackground(Color.black);
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
