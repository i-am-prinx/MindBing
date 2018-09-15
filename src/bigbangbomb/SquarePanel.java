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
        /***************************************************************
         * logic to display the grid color and relative notifier message
         * so app can be user friendly
         */
        
        JPanel src = (JPanel) e.getSource();
        if (flag) {
            long startTime = System.nanoTime();
            if (e.getClickCount() == 1) {
                if (src.getComponentCount() == 1) {
                    src.setBackground(Color.red);
                    EventNotifier.hideSMFN();
                    EventNotifier.hideSMFRL();
//                    gameOver("stepped on land mine");
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
//                    src.removeMouseListener(this);
                } else {
                    Player.reduceLife();
                    EventNotifier.showSMFRL();  
                    // reduce player's life
                }
            }
            
            long endTime = System.nanoTime();
            System.out.println("time ----: " + (endTime - startTime));
            if ( endTime - startTime > 9000000 ){ 
                gameOver("stepped land mine");
            }
        }
        
        
        EventNotifier.resetBombAroundNotify();
        EventNotifier.resetLifeRemaining();
        EventNotifier.hideBombAround();
        
        JPanel squareContainer = SquareFrame.squareContainer();
        
        /**
         * getting x and y position within the frame whenever an event happens
         */
        int yLocationOnScreen = 0, xLocationOnScreen = 0;
        Point mousePosition = src.getMousePosition();
        if ( mousePosition != null ){
            yLocationOnScreen = (int) mousePosition.getY();
            xLocationOnScreen = (int) mousePosition.getX();
        }
        

        System.out.println("y -- " + yLocationOnScreen);
        System.out.println("x -- " + xLocationOnScreen);
        
        
        /**
         * getting the component clicked on 
         */
        JPanel compClickedOn = null;
        int xPos = 0, yPos = 0;
        
        try{
            System.out.println("Within if try and catch statement");
            
            compClickedOn = (JPanel) src.getComponentAt(xLocationOnScreen, yLocationOnScreen);
            xPos = compClickedOn.getX();
            yPos = compClickedOn.getY();
            System.out.println("Component  gotten color : " + compClickedOn.getBackground());
            
        } catch (Exception err ){ System.out.println("No Component Found"); }
        
        
        System.out.println("xPosition : " + xPos);
        System.out.println("yPosition : " + yPos);
        
        
        
        // declaring variables for all grids surrounding a grid clicked on
        
        int eastSquare, southSquare, northSquare, westSquare, spaceDiff = 84;
        
        eastSquare = xPos + spaceDiff;              //.... y-axis remains the same
        westSquare = xPos - spaceDiff;              //.... y-axis remains the same
        northSquare = yPos - spaceDiff;             //.... x-axis remains the same
        southSquare = yPos + spaceDiff;             //.... x-axis remains the same
        
        /**
         *             --- NOTIFICATION --- NOTIFICATION --- NOTIFICATION ---
         * 
         * NOTE: southEastSquare, southWestSquare, northEastSquare, northWestSquare
         * are not declared. 
         * To compute for southEastSquare we'll do
         * 
         *      southEastSquare =  
         *              southSquare :: is the y-axis
         *              xPos + spaceDiff :: is the x-axis       ( eastSquare )
         *          
         *      southWestSquare = 
         *              southSquare :: is the y-axis
         *              xPos - spaceDiff :: is the x-axis       ( westSquare )
         * 
         *      northEastSquare = 
         *              northSquare :: is the y-axis 
         *              xPos + spaceDiff :: is the x-axis       ( eastSquare )
         * 
         * 
         *      northWestSquare = 
         *              northSquare :: is the y-axis
         *              xPos - spaceDiff :: is the x-axis       ( westSquare )
         *      
         *      -- END OF NOTIFICATION -- END OF NOTIFICATION -- 
         */
        
        
        
        
        // COMPUTING FOR BOMBS AROUND
        try {                   // getting for eastSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(eastSquare, yPos);
            if ( newComp.getComponentCount() == 1 ){
                bombsAround += 1;
            }
        } catch( Exception h ){ System.out.println("No Component found"); }

        try {                   // getting for westSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(westSquare, yPos);
            if ( newComp.getComponentCount() == 1 ){
                bombsAround += 1;
            }
        } catch( Exception h ){ System.out.println("No Component found"); }

        try {                   // getting for northSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(xPos, northSquare);
            if ( newComp.getComponentCount() == 1 ){
                bombsAround += 1;
            }
        } catch( Exception h ){ System.out.println("No Component found"); }
       
        try {                   // getting for southSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(xPos, southSquare);
            if ( newComp.getComponentCount() == 1 ){
                bombsAround += 1;
            }
        } catch( Exception h ){ System.out.println("No Component found"); }
  
        try {                   // getting for northWestSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(westSquare, northSquare);
            if ( newComp.getComponentCount() == 1 ){
                bombsAround += 1;
            }
        } catch( Exception h ){ System.out.println("No Component found"); }
        
        try {                   // getting for northEastSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(eastSquare, northSquare);
            if ( newComp.getComponentCount() == 1 ){
                bombsAround += 1;
            }
        } catch( Exception h ){ System.out.println("No Component found"); }
        
        try {                   // getting for southWestSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(westSquare, southSquare);
            if ( newComp.getComponentCount() == 1 ){
                bombsAround += 1;
            }
        } catch( Exception h ){ System.out.println("No Component found"); }
        
        try {                   // getting for southEastSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(eastSquare, southSquare);
            if ( newComp.getComponentCount() == 1 ){
                bombsAround += 1;
            }
        } catch( Exception h ){ System.out.println("No Component found"); }
        
        // ----- END OF ALGORITHM::: WHICH GETS BOMB AROUND  -----------------
        
        System.out.println("BA ::=== " + bombsAround );
        
        
        // resetting and setting notifier
        int playerLife = Player.getGameLife();
        EventNotifier.setLife(playerLife);
        EventNotifier.setBombAroundSquare(bombsAround);
        EventNotifier.showBombAround();
        
        
        
        bombsAround = eastSquare = southSquare = northSquare = westSquare = 0;
        
         // If player's life equals Zero, then game should end
        int playersLife = Player.getGameLife();
        if ( playersLife  == 0 ){
            gameOver("used all life");
        }
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
    
    /**
     * game over implementation... this is to avoid redundancy
     * @param str 
     *      this tells the reason why game ends
     */
    private static void gameOver( String str ) {
        RestartPage.configureRestartPage(str);
        EventNotifier.hideNotifierPanel();
        SquareFrame.hideSquareContainer();
    }
}
