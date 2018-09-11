/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbangbomb;


import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;



/**
 *
 * @author Agbonxoft Prince
 */
public class EventNotifier {
    private static JPanel squareContainer = SquareFrame.squareContainer();
    private static int WIDTH = squareContainer.getWidth();
    private static int lifeRemaining = Player.getGameLife();
    private static JLabel lifeLabel, lifeNotify;
    private static JPanel SMFN = new JPanel();
    
    
    
    /**
     * will be displayed before the grid will be displayed on the game menu
     * which will hold users remaining life and events that happens when 
     * click event is performed on a square.
     */
    public static JPanel notificationBar(){
        JPanel notifierBar = new JPanel();
        notifierBar.setLayout(new MigLayout());
        notifierBar.setSize(WIDTH, 300);
        notifierBar.setBackground(Color.darkGray);
        
        lifeNotify = new JLabel("GuessLife : ");
        lifeNotify.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        lifeNotify.setForeground(Color.magenta);
        lifeNotify.setBounds(10, 10, 10, 10);
        
        lifeLabel = new JLabel(lifeRemaining + "");
        lifeLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        lifeLabel.setForeground(Color.GREEN);
        lifeLabel.setBounds(15, 15, 65, 15);
        if ( lifeRemaining < 3){
            lifeLabel.setForeground(Color.RED);
            lifeLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
        }
        
        ConfiguredShowMsgForNeutralize();
        
        notifierBar.add(lifeNotify);
        notifierBar.add(lifeLabel, "wrap" );
        notifierBar.add(SMFN, "span");
        return notifierBar;
    }
    
    
    /**
     * this will output a message anytime a bomb was successfully neutralized.
     * by default this is hidden, when needed showSMFN should be called.
     * @param msg
     * @return JPanel
     */
    private static void ConfiguredShowMsgForNeutralize( ){
        SMFN.setBackground(Color.darkGray);
        
        JLabel neutralizeMsg = new JLabel("Bomb was succefully Neutralized");
        neutralizeMsg.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        neutralizeMsg.setForeground(Color.YELLOW);
        SMFN.setVisible(false);
        SMFN.add(neutralizeMsg);
    }
    
    /**
     * this will be used to hide messageForNeutralize from displaying when not needed
     */
    public static void hideSMFN(){
        SMFN.setVisible(false);
    }
    
    /**
     * this will be used to show messageForNeutralize ( so it displays ) when needed.
     */
    public static void showSMFN(){
        SMFN.setVisible(true);
    }
}
