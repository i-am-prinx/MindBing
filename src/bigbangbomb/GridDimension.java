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
 * a bomb, and if there are bomb, the amount should be displayed else ignore if
 * there are no surrounding bomb.
 * 
 * 
 * Based on the statement above, this is likely to be done with dimensional arrays
 * so that we can check the surrounding dimension if there are actually bombs
 *
 */
public class GridDimension {
    
    /**
     * this variable will be used to determine the level of the user and the 
     * amount of grid that will be displayed for that level
     * ---- if level is 2 which is the default, game will display two grid -----
     */
    private int userLevel = 2;
    
}
