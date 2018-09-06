/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbangbomb;

/**
 *
 * @author Agbonxoft Prince
 */



/**
 * 
 * Project demands that a structure of multiple squares to be displayed. when a
 * user click on a square that doesn't contain a bomb, there should be a check
 * if the surrounding squares around the square that a user clicks on is having
 * a bomb, and if there are bomb, the amount around the surrounding square should 
 * be displayed else ignore if there are no bomb surrounding the square.
 * 
 * 
 * Based on the statement above, this is likely to be done with dimensional arrays
 * so that we can check the surrounding dimension if there are actually bombs
 *
 */
public class GridDimension {
    
    /**
     * MAX_ROW is the amount of rows a grid can have.
     * MAX_COL is the amount of columns a grid can have.
     */
    private final int MAX_ROW = 10;
    private final int MAX_COL = 10;
    
    
    /** 
     * these are the default rows and columns which will grow simultaneously 
     * whenever they are called. their values cannot be greater than their max
     */
    private int row = 2;
    private int col = 2;
    
    
    /**
     * this method will calculate the number of grid that will be displayed.
     * columns and row are to grow simultaneously at each call.
     */
    private void nextGrid( ) {
        if ( this.row == 2 && this.col == 2 )
        {
            SquarePanel[][] grid = new SquarePanel[this.row][this.col];
        } 
        
        else 
        {
            SquarePanel[][] grid = new SquarePanel[this.row][this.col];
        }
    }
    
    
    
    
    /**
     * this method will call next grid outside of this class
     */
    public void callNextGrid( ) {
        if ( this.row != this.MAX_ROW && this.col != this.MAX_COL )
        {
            this.row = this.col += 2;       // ( row += 2 ) ( col += 2 )
            this.nextGrid();
        }
        
        else
        {
           // use JOptionPane.showMessageDialog to inform the user that all 
           // levels has been clared, and also display main menu
        }
    }
}
