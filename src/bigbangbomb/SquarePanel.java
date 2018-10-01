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
    private static int gridGotten = 0;

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
        JPanel squareContainer = SquareFrame.squareContainer();
        int numberOfGrid = squareContainer.getComponentCount();
        System.out.println("Number of components: " + numberOfGrid );
        /**
         * *************************************************************
         * logic to display the grid color and relative notifier message so app
         * can be user friendly
         */
        
        JPanel src = (JPanel) e.getSource();
        if (flag) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    if (src.getComponentCount() == 1) {
                        src.setBackground(Color.red);
                        EventNotifier.hideSMFN();
                        EventNotifier.hideSMFRL();
                        // set the size of the frame to 800x600 so our restart
                        // page can every of it's component
                        BigBangBomb.setSquareFrameWH(800, 600);
                        // since we want to show restart page, we have to hide
                        // square Container
                        squareContainer.setVisible(false);
                        // reveal restart page
                        SquareFrame.getRestartPage().removeAll();
                        gameOver("stepped on land mine");
                        SquareFrame.getRestartPage().setVisible(true);

                    } else {
                        src.setBackground(Color.green);
                        EventNotifier.hideSMFN();
                        EventNotifier.hideSMFRL();
                        
                        // if a user turns a square that there is no bomb, 
                        // increment grid gotten 
                        gridGotten += 1;
                    }
                }
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                if (e.getClickCount() == 2) {
                    /**
                     * this will be worked on :::: We only want a bomb to get
                     * neutralized when a user right clicks, and not when he
                     * double clicks....
                     */
                    if (src.getComponentCount() == 1) {
                        src.setBackground(Color.blue);
                        EventNotifier.showSMFN();
                        // when a user neutralizes a grid by right clicking twice
                        // in a grid containing a bomb increment gridGotten by 1
                        gridGotten += 1;
                    } else {
                        Player.reduceLife();
                        EventNotifier.showSMFRL();
                        // reduce player's life
                    }
                }
            }
        }
        
        /**
         * when the amount of grids a user has gotten equals the amount of grids
         * displayed without a user stepping on a bomb, then the user completes
         * that level
         * 
         * a user get grid when he turns a grid that doesn't contain a bomb or 
         * when he neutralizes a bomb
         */
        if ( gridGotten == numberOfGrid ) {
            System.out.println("\n\n\n\n\n\nInside of level complete logic");
            squareContainer.setVisible(false);
            EventNotifier.hideNotifierPanel();            
            SquareFrame.configureLevelCompletePanel();
            BigBangBomb.packSquareFrame();
        }

        EventNotifier.resetBombAroundNotify();
        EventNotifier.resetLifeRemaining();
        EventNotifier.hideBombAround();

        /**
         * getting x and y position within the frame whenever an event happens
         */
        int yLocationOnScreen = 0, xLocationOnScreen = 0;
        Point mousePosition = src.getMousePosition();
        if (mousePosition != null) {
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

        try {
            System.out.println("Within if try and catch statement");

            compClickedOn = (JPanel) src.getComponentAt(xLocationOnScreen, yLocationOnScreen);
            xPos = compClickedOn.getX();
            yPos = compClickedOn.getY();
            System.out.println("Component  gotten color : " + compClickedOn.getBackground());

        } catch (Exception err) {
            System.out.println("No Component Found");
        }

        System.out.println("xPosition : " + xPos);
        System.out.println("yPosition : " + yPos);

        // declaring variables for all grids surrounding a grid clicked on
        int eastSquare, southSquare, northSquare, westSquare, spaceDiff = 84;

        eastSquare = xPos + spaceDiff;              //.... y-axis remains the same
        westSquare = xPos - spaceDiff;              //.... y-axis remains the same
        northSquare = yPos - spaceDiff;             //.... x-axis remains the same
        southSquare = yPos + spaceDiff;             //.... x-axis remains the same

        /**
         * --- NOTIFICATION --- NOTIFICATION --- NOTIFICATION ---
         *
         * NOTE: southEastSquare, southWestSquare, northEastSquare,
         * northWestSquare are not declared. To compute for southEastSquare
         * we'll do
         *
         * southEastSquare = southSquare :: is the y-axis xPos + spaceDiff :: is
         * the x-axis ( eastSquare )
         *
         * southWestSquare = southSquare :: is the y-axis xPos - spaceDiff :: is
         * the x-axis ( westSquare )
         *
         * northEastSquare = northSquare :: is the y-axis xPos + spaceDiff :: is
         * the x-axis ( eastSquare )
         *
         *
         * northWestSquare = northSquare :: is the y-axis xPos - spaceDiff :: is
         * the x-axis ( westSquare )
         *
         * -- END OF NOTIFICATION -- END OF NOTIFICATION --
         */
        // COMPUTING FOR BOMBS AROUND
        try {                   // getting for eastSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(eastSquare, yPos);
            if (newComp.getComponentCount() == 1) {
                bombsAround += 1;
            }
        } catch (Exception h) {
            System.out.println("No Component found");
        }

        try {                   // getting for westSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(westSquare, yPos);
            if (newComp.getComponentCount() == 1) {
                bombsAround += 1;
            }
        } catch (Exception h) {
            System.out.println("No Component found");
        }

        try {                   // getting for northSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(xPos, northSquare);
            if (newComp.getComponentCount() == 1) {
                bombsAround += 1;
            }
        } catch (Exception h) {
            System.out.println("No Component found");
        }

        try {                   // getting for southSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(xPos, southSquare);
            if (newComp.getComponentCount() == 1) {
                bombsAround += 1;
            }
        } catch (Exception h) {
            System.out.println("No Component found");
        }

        try {                   // getting for northWestSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(westSquare, northSquare);
            if (newComp.getComponentCount() == 1) {
                bombsAround += 1;
            }
        } catch (Exception h) {
            System.out.println("No Component found");
        }

        try {                   // getting for northEastSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(eastSquare, northSquare);
            if (newComp.getComponentCount() == 1) {
                bombsAround += 1;
            }
        } catch (Exception h) {
            System.out.println("No Component found");
        }

        try {                   // getting for southWestSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(westSquare, southSquare);
            if (newComp.getComponentCount() == 1) {
                bombsAround += 1;
            }
        } catch (Exception h) {
            System.out.println("No Component found");
        }

        try {                   // getting for southEastSquare
            JPanel newComp = (JPanel) squareContainer.getComponentAt(eastSquare, southSquare);
            if (newComp.getComponentCount() == 1) {
                bombsAround += 1;
            }
        } catch (Exception h) {
            System.out.println("No Component found");
        }

        // ----- END OF ALGORITHM::: WHICH GETS BOMB AROUND  -----------------
        System.out.println("BA ::=== " + bombsAround);

        // resetting and setting notifier
        int playerLife = Player.getGameLife();
        EventNotifier.setLife(playerLife);
        EventNotifier.setBombAroundSquare(bombsAround);
        EventNotifier.showBombAround();

        bombsAround = eastSquare = southSquare = northSquare = westSquare = 0;

        // If player's life equals Zero, then game should end
        int playersLife = Player.getGameLife();
        if (playersLife == 0) {
            BigBangBomb.setSquareFrameWH(800, 600);
            squareContainer.setVisible(false);
            SquareFrame.getRestartPage().removeAll();
            gameOver("used all life");
            SquareFrame.getRestartPage().setVisible(true);
        }

        /**
         * ALGORITHM TO COMPUTE A SUCCESSFUL GAME ::::::
         *
         * we'll have a counter that increments each time a click event occurs.
         * thereafter we can get the amount of rows and columns that are
         * currently displayed, multiply the amount of rows by the number of
         * columns, and if the counter is up to the result gotten after the
         * multiplication, then we can say that a user completely finished that
         * level.
         */
        int displayedRows = GridDimension.getCurrentRow();
        int displayedCols = GridDimension.getCurrentCol();
        System.out.println("rows displayed " + displayedRows);
        System.out.println("columns displayed " + displayedCols);
        System.out.println("Grids displayed are " + (displayedRows * displayedCols));
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
     * game over implementation... this is to avoid redundancy and to reset
     * every values used in previous game play.
     *
     * @param str this tells the reason why game ends
     */
    private static void gameOver(String str) {
        Player.resetGameLife();     // resetting the game life to initial value
        RestartPage.configureRestartPage(str);  // displays why game ends
        EventNotifier.resetBombAroundNotify();  // remove previous value of bombaround
        EventNotifier.resetLifeRemaining();     // remove previous value of life
        EventNotifier.hideSMFN();               // hide bomb neutralized message
        EventNotifier.hideSMFRL();              // hide life reduced message
        EventNotifier.hideNotifierPanel();      // hide the notifier panel
        SquareFrame.hideSquareContainer();      // hide square container holding grid
        SquareFrame.squareContainer().removeAll(); // remove all of the grids
        gridGotten = 0;                         // reset gotten grid to 0
    }
}
