
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
public class SquareFrame extends JFrame{
    private static JPanel panel = new JPanel();
    
    SquareFrame( ) {
        super();       
        setLayout(new BorderLayout());
        
        JPanel[][] fp = new GridDimension().callNextGrid();
        
        panel.setLayout(new MigLayout());
    
        for ( int i = 0 ; i < fp.length; i++) {
            for ( int j = fp[i].length-1; j > 0 ; j-- ) {
               if ( j == 1 ){
                    System.out.print("#  \n");
                    panel.add(fp[i][j], "width 30:80:80, height 30:80:80, wrap");
               }
               else {
                    System.out.print("#  ");
                    panel.add(fp[i][j], "width 30:80:80, height 30:80:80");
                } 
            }
        }
        
        
        int MAX_HEIGHT = panel.getHeight();
        int MAX_WIDTH = panel.getWidth();
        
        
        
        add(panel);
        setVisible(true);
        setSize(MAX_WIDTH, MAX_HEIGHT);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * this is returned so it's attributes can be used in other class files
     * attributes like ( width and height )
     * @return JPanel
     */
    public static JPanel squareContainer( ){
        return panel;
    }
    
    
    
    /*** this main method will be removed from this file, it's just for testing
     * if the grid system is working as expected...
     * @param args 
     */
    public static void main (String args[]){
        SquareFrame bbb = new SquareFrame();
    }
}
