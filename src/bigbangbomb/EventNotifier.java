/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbangbomb;


import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;



/**
 *
 * @author Agbonxoft Prince
 */
public class EventNotifier {
    
    private static JPanel SMFN = new JPanel();
    private static JPanel SMFRL = new JPanel();
    private static int gameLife = Player.getGameLife();
    private static JPanel lifeNotifyPanel = new JPanel(); 
    private static JPanel bombAroundSquare = new JPanel();
    private static int bombAround = SquarePanel.getBombAround();
    private static JLabel lifeLabel, lifeNotify, bombAroundLabel, bombAroundNotify;
    
    
    //******************** Show Message For Neutralize( SMFN )
    //*************** Show Message For Reduced Life ( SMFRL )
    
    /**
     * will be displayed before the grid will be displayed on the game menu
     * which will hold users remaining life and events that happens when 
     * click event is performed on a square.
     */
    public static JPanel notificationBar(){
        JPanel notifierBar = new JPanel();
        notifierBar.setLayout(new MigLayout());
        notifierBar.setBackground(Color.darkGray);
        
        ConfiguredShowMsgForNeutralize();
        ConfiguredShowMsgForReducedLife();
        
        setLife(gameLife);
        
        setBombAroundSquare(bombAround);
                
        
        notifierBar.add(bombAroundSquare, "push");
        notifierBar.add(lifeNotifyPanel, "wrap" );
        notifierBar.add(SMFN);
                notifierBar.add(SMFRL);
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
        
        JLabel neutralizeMsg = new JLabel("Bomb Neutralized");
        neutralizeMsg.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        neutralizeMsg.setForeground(Color.YELLOW);
        SMFN.setVisible(false);
        SMFN.add(neutralizeMsg);
    }
    
    
    
    private static void ConfiguredShowMsgForReducedLife( ){
        SMFRL.setBackground(Color.darkGray);
        
        JLabel reducedLifeMsg = new JLabel("life reduced");
        reducedLifeMsg.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        reducedLifeMsg.setForeground(Color.YELLOW);
        SMFRL.setVisible(false);
        SMFRL.add(reducedLifeMsg);
    }
    
    
    /**
     * this will help to set a new text on the bombAroundPanel, so a user will
     * always know the amount of squares around the square where click event 
     * occur on
     * @param bombsAround
     *    this is the amount of bomb surrounding the square where click event
     *    occur on
     *          
     * @param txt 
     *    this is the text that will suffice the amount of bomb.
     */
    public static void setBombAroundSquare( int bombsAround ){
        bombAroundSquare.setLayout(new MigLayout());
        bombAroundSquare.setBackground(Color.darkGray);
        
        bombAroundNotify = new JLabel("Bomb around : ");
        bombAroundNotify.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        bombAroundNotify.setForeground(Color.magenta);
        bombAroundNotify.setBounds(10, 10, 10, 10);
        
        bombAroundLabel = new JLabel(" "+ bombsAround);
        bombAroundLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        bombAroundLabel.setForeground(Color.GREEN);
        bombAroundLabel.setBounds(15, 15, 65, 15);
        
        bombAroundSquare.add(bombAroundNotify);
        bombAroundSquare.add(bombAroundLabel);
    }
    
    
     public static void setLife( int lifeRemaining ){
        lifeNotifyPanel.setLayout(new MigLayout());
        lifeNotifyPanel.setBackground(Color.darkGray);
        
        lifeNotify = new JLabel("life : ");
        lifeNotify.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        lifeNotify.setForeground(Color.magenta);
        lifeNotify.setBounds(10, 10, 10, 10);
        
        lifeLabel = new JLabel(lifeRemaining + " ");
        lifeLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        lifeLabel.setForeground(Color.GREEN);
        lifeLabel.setBounds(15, 15, 65, 15);
        if ( lifeRemaining < 3){
            lifeLabel.setForeground(Color.RED);
            lifeLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        }
        
        lifeNotifyPanel.add(lifeNotify);
        lifeNotifyPanel.add(lifeLabel);
    }
    
    public static void resetLifeRemaining( ){
        lifeNotifyPanel.removeAll();
    }
    
    /**
     * For each time a new new square is clicked we want the new figure of bomb
     * around the square that is clicked, hence this method will always help to
     * remove the previous text.
     */
    public static void resetBombAroundNotify(){
        bombAroundSquare.removeAll();
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
    
    
     /**
     * this will be used to hide messageForNeutralize from displaying when not needed
     */
    public static void hideSMFRL(){
        SMFRL.setVisible(false);
    }
    
    /**
     * this will be used to show messageForNeutralize ( so it displays ) when needed.
     */
    public static void showSMFRL(){
        SMFRL.setVisible(true);
    }
    
}
