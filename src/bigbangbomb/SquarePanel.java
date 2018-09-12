package bigbangbomb;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Agbonxoft Prince
 */
public class SquarePanel extends JPanel implements MouseListener {

    private boolean flag = false;
    private static int bombsAround = 0;
    private JPanel squareContainer = SquareFrame.squareContainer();

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
    private void bombSetter() {
        JLabel bomb = new JLabel("");

        Random bombRandomizer = new Random();
        int bombRandNumber = bombRandomizer.nextInt(2);
        if (bombRandNumber == 0) {
            add(bomb);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        EventNotifier.resetBombAroundNotify();
        EventNotifier.resetLifeRemaining();
        
        if (flag) {
            JPanel src = (JPanel) e.getSource();
            if (e.getClickCount() == 1) {
                if (src.getComponentCount() == 1) {
                    src.setBackground(Color.red);
                    EventNotifier.hideSMFN();
                    EventNotifier.hideSMFRL();
                } else {
                    src.setBackground(Color.green);
                    EventNotifier.hideSMFN();
                    EventNotifier.hideSMFRL();
                }
            }
            else if (e.getClickCount() == 2) {                
                if (src.getComponentCount() == 1) {
                    src.setBackground(Color.blue);
                    EventNotifier.showSMFN();
                } else {
                    Player.reduceLife();
                    EventNotifier.showSMFRL();
                    // reduce player's life
                }
            }
        }
        int playerLife = Player.getGameLife();
        EventNotifier.setLife(playerLife);
        EventNotifier.setBombAroundSquare(bombsAround);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        flag = true;
        System.out.println(flag);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        flag = false;
        System.out.println(flag);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    public static int getBombAround() {
        return bombsAround;
    }
}
