package bigbangbomb;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel src = (JPanel)e.getSource();
        
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
