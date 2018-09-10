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
    private boolean flag = false;
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
        /**
         * a user will loose game if he clicks once on a panel that holds another
         * component ( :: in our case it's a JLabel used to signify if there is 
         * a bomb or not :: ) while flag is true. 
         * 
         * a user will mark a panel which he thinks there is a bomb if he 
         * double clicks on that panel while the flag is true. if there is 
         * actually a bomb, the panel will be marked else it will stay green
         * which means his guess about that panel was wrong.
         * 
         *       **** Implement how many times a user can guess ****
         * 
         * when a user knows a that a panel has no bomb in it and if he is right
         * the panel will be marked as checked.
         * 
         * 
         *                                  **** 
         *         to know the amount of panels marked as checked or neutralized
         *         create two variables, checked and neutralized. 
         *         -----------
         *         Run a check on variable neutralized
         *         to know if neutralized equals the amount of bombs set 
         *         ( bombs set can be gotten by calculating the amount of 0's 
         *           generated by bombRandomizer )
         *         -----------
         *         Run a check on variable checked
         *         to know if a user has actually marked all the boxes that are
         *         void of bomb ( this check can be actualized by subtracting 
         *         checked amount from the number of grids and see if it is 
         *         equal to the number calculated for bombRandomizer )
         *          
         *         
         *          
         */
        if ( flag ){
           if ( e.getClickCount() == 1 ){
               JPanel src = (JPanel)e.getSource();
               if ( src.getComponentCount() == 1 ){
                   src.setBackground(Color.red);
               }
               else {
                   src.setBackground(Color.green);
               }
           }
           else if ( e.getClickCount() == 2 ){
               JPanel src = (JPanel)e.getSource();
               if (src.getComponentCount() == 1 ){
                   src.setBackground(Color.blue);
               }
           }
        }
        
        
        /**
         * algorithm to check for surrounding squares around where a user 
         * performs a click event
         *
         * this algorithm cannot be complete unless we get the full width and
         * height of container holding all squares
         * 
         *  --- get full width of container holding all squares
         * 
         *  --- get the current location where click event occur ( x & y  position ) 
         */
        
        int squareContainerFullWidth = squareContainer.getWidth();
        int squareContainerFullHeight = squareContainer.getHeight() + 4 ;
        
        
        int currentXpos = (int) e.getLocationOnScreen().getX();
        int currentYpos = (int) e.getLocationOnScreen().getY();
        
        
        System.out.println("currentXclickPosition -- " + currentXpos);
        System.out.println("currentYclickPosition -- " + currentYpos);
        
        
        /**
         * it should be noted that since all squares displayed have same height
         * and width. If the previous statement is true, then the spaces between
         * all squares are same. 
         * 
         *  -- The top-left square ( x position begins at = 10 and x position 
         *     for that same square ends at = 89 ) && ( y position begins at = 33
         *     and y position for that same square ends at = 112 ),
         * 
         * -- The space between the first square at the top-left and the second
         *    square at the top-left is same amongst all squares which is 
         *    ( 5 spaces between squares )
         * 
         * -- The spaces that makes up a square is 79 spaces amongst all square
         *      ~ for the first square at the top-left position
         *          spaceThatMakesUpSquares = squareEnd - squareBegin
         *          spaceThatMakesUpSquares = 89 - 10
         *                                  = 79
         * 
         *      ~ The space between the every squares is 5 spaces this also 
         *        should also be added to spaceThatMakesUpSquares
         *          spaceThatMakesUpSquares = spaceThatMakesUpSquares + 5
         *                                  = 84
         * 
         *      ~ Now it can be said that between first square and second square
         *        the difference is 84
         * 
         * NOTE NOTE NOTE ::: We've just calculated for the X position, note that
         * same is true for Y position.
         * 
         * This formula will remain true if the width of squares
         * is not tempered or altered. This Formula is true for all squares 
         * displayed, since they all have equal width and height
         */
        
        int firstSquareWidthStart = 10;
        int squareSpaces = 84;
        
        int eastSquarePos = currentXpos;
        int westSquarePos = squareSpaces;
        int southSquarePos = currentYpos;
        int northSquarePos = squareSpaces;
        
        
        /**
         * Algorithm for getting the surrounding squares position around the 
         * square a click event occur on.
         */
        
        while( true ){
            System.out.println("loop");
            if ( currentXpos <= squareContainerFullWidth && currentXpos >= firstSquareWidthStart ){
                eastSquarePos += squareSpaces;
                
                // algorithm for getting the square before the current square
                // that a click event is occuring on ( square to the west of click )
                
                if ( currentXpos - squareSpaces > squareSpaces ){
                    westSquarePos = currentXpos - squareSpaces;             
                }
                // end
                System.out.println("west : " + westSquarePos);
                
                
                // algorithm for getting the square after the current square that
                // a click event is occuring on ( square to east of click )
                
                if ( currentXpos < eastSquarePos ){
                    if ( eastSquarePos - currentXpos < squareSpaces ){
                        eastSquarePos += ( currentXpos + squareSpaces );
                    }
                    
                    if ( eastSquarePos >= squareContainerFullWidth ){
                        eastSquarePos = squareContainerFullWidth - 15;
                    }
                    
                    System.out.println("east : " + eastSquarePos );
                    break;    // terminate loop when these two position has been gotten
                }
                // end
            }
        }
        
        
        
        
        while( true ){
            if ( currentYpos <= squareContainerFullHeight && currentYpos >= 33 ){
                southSquarePos += squareSpaces;
                
                // algorithm for getting square above click position ( north )
                if ( currentYpos - northSquarePos > squareSpaces ){
                    northSquarePos = currentYpos - squareSpaces;
                }
                // end
                
                
                // algorithm for getting square below click position
                if (currentYpos < southSquarePos ){
                    if ( southSquarePos + squareSpaces < squareContainerFullHeight ){
                        southSquarePos =  currentYpos + squareSpaces ;
                    }
                    
                    if ( southSquarePos > squareContainerFullHeight ){
                        southSquarePos = squareContainerFullHeight - 8;
                    }
                                  
                    System.out.println("south : " + southSquarePos );
                    break;
                }
                // end
            }
        }
        
        
        /**
         * CHECK POINT :: CHECKPOINT :: CHECKPOINT :: CHECKPOINT :: CHECKPOINT ::
         * checking if there are bomb in surrounding squares where click event
         * occur.
         */
        
        int bombsAround = 0;
        while ( true ){
            // testing if north square holds any bomb
            JPanel panel = (JPanel) squareContainer.getComponentAt(currentXpos, northSquarePos);
            if ( panel.getComponentCount() == 1 ){
                bombsAround += 1;
            }
            // testing if east square holds any bomb
            panel = (JPanel) squareContainer.getComponentAt(eastSquarePos, currentYpos);
            if ( panel.getComponentCount() == 1 ){
                bombsAround += 1;
            }
            // testing if west square holds any bomb
            panel = (JPanel) squareContainer.getComponentAt(westSquarePos, currentYpos);
            if ( panel.getComponentCount() == 1 ){
                bombsAround += 1;
            }
            // testing if south square holds any bomb
            panel = (JPanel) squareContainer.getComponentAt(currentXpos, southSquarePos);
            if ( panel.getComponentCount() == 1 ){
                bombsAround += 1;
            }
            // testing if south-west square holds any bomb
            panel = (JPanel) squareContainer.getComponentAt(westSquarePos, southSquarePos);
            if ( panel.getComponentCount() == 1 ){
                bombsAround += 1;
            }
            // testing if north-west square holds any bomb
            panel = (JPanel) squareContainer.getComponentAt(westSquarePos, northSquarePos);
            if ( panel.getComponentCount() == 1 ){
                bombsAround += 1;
            }
            // testing if north-east square holds any bomb
            panel = (JPanel) squareContainer.getComponentAt(eastSquarePos, northSquarePos);
            if ( panel.getComponentCount() == 1 ){
                bombsAround += 1;
            }
            // testing if south-east square holds any bomb
            panel = (JPanel) squareContainer.getComponentAt(eastSquarePos, southSquarePos);
            if ( panel.getComponentCount() == 1 ){
                bombsAround += 1;
            }
            break;
        }
        
        System.out.println("Bomb Around : " + bombsAround);
        
        
        
        // resetting positions
        eastSquarePos = currentXpos;
        southSquarePos = currentYpos;
        
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
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
