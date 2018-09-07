package bigbangbomb;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Agbonxoft Prince
 */


public class SquarePanel extends JPanel implements MouseListener {
    SquarePanel() {
        super();
        this.addMouseListener(this);
        setBorder(BorderFactory.createLineBorder(Color.white));
        setBackground(Color.black);
        System.out.println("5\tcreateNextpanel Called and Panel is returned");
        bombSetter();
    }
    
    /**
     * This will help to randomly set bomb on created panels.
     */
    private void bombSetter( ){
        JLabel bomb = new JLabel("");
        
        
        Random bombRandomizer = new Random();
        int bombRandNumber = bombRandomizer.nextInt(2);
        if ( bombRandNumber == 0 ) {
            add( bomb );
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel src = (JPanel)e.getSource();
        System.out.println(src.getComponentCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
    }
}
