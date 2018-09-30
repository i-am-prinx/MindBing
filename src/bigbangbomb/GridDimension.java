package bigbangbomb;

import javax.swing.JPanel;

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
    private static int row = 4;
    private static int col = 4;
    
    
    
    /**
     * this method will calculate the number of grid that will be displayed.
     * columns and row are to grow simultaneously at each call.
     */
    private JPanel[][] nextGrid( ) {
        System.out.println("3\tnextGrid Called");
        JPanel[][] grid = new JPanel[row][col];
        grid = this.gridCreatorCalculator(grid);
        System.out.println("7\ttested rows and columns when they have 2");   
        return grid;
    }
    
    /**
     * increases rows and columns before nextGrid is called. 
     */
    public static void increaseRowsNcols(){
        row += 2;
        col += 2;
    }
    
    
    /**
     * this method will call nextGrid outside of this class and return grid
     */
    public JPanel[][] callNextGrid( ) {
        System.out.println("1\tinside of callNextGrid");
        if ( this.row <= this.MAX_ROW && this.col <= this.MAX_COL )
        {
            System.out.println("2\ttested rows and columns are lower than max");
            return this.nextGrid();
        }
        
        else
        {
           // use JOptionPane.showMessageDialog to inform the user that all 
           // levels has been clared, and also display main menu
            return null;
        }
    }
    
    
    
    /**
     * this will compute the loop that will create panel based on the current
     * amount of rows and columns and then return the computation
     * @param p 
     * @return JPanel
     */
    private JPanel[][] gridCreatorCalculator( JPanel[][] p ){
        
        // The reason for this is so that we can be able to create panel based
        // on the specification on the SquarePanel class
        
        
        for (int r = 0; r < p.length; r++ ) {
            for (int c = p[r].length - 1; c >= 0; c-- ) {
                System.out.println("4\tcalling createPanel");
                p[r][c] = new SquarePanel();
            }
        }
        System.out.println("6\treturn grid after calculation");
        return p;
    }
    
    /** 
     * returns the number of rows of grids displayed
     * @return integer
     */
    public static int getCurrentRow( ){
        return row;
    }
    
    /**
     * returns the number of columns of grids displayed. computers start counting
     * at Zero, so columns tends to always be 1 lesser than the actual amount
     * @return integer
     */
    public static int getCurrentCol( ){
        return col - 1;
    }
}
