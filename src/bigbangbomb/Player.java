package bigbangbomb;

/**
 *
 * @author Agbonxoft Prince
 */


public class Player {
    
    /**
     * this variable will be used to determine the level of the player and the 
     * amount of grid that will be displayed for that level.
     */
    private static int currentLevel = 1;
    
    
    
    /**
     * this will help to return the current level of a player
     * @return integer
     */
    public int getCurrentLevel() {
        return this.currentLevel;
    }
    
    
    
    /**
     * this will increment a player's level by one at each call
     */
    private static void nextLevel( ) {
        currentLevel++;
    }
    
    
    
    /**
     * this will help to call nextLevel method outside of this class
     */
    public static void callNextLevel( ) {
        nextLevel();
    }
    
}
