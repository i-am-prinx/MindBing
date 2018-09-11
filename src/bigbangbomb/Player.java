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
    private static int gameLife = 5;
    
    
    
    /**
     * This will reduce the game life of a player
     * @return integer
     */
    public static int reduceLife(){
        return gameLife -= 1;
    }
    
    
    
    /**
     * This will increase the game life of a player
     * @return integer
     */
    public static int increaseLife(){
        return gameLife += 1;
    }
    
    
    
    /**
     * this will help to return the current level of a player
     * @return integer
     */
    public static int getCurrentLevel() {
        return currentLevel;
    }
    
    
    
    /**
     * this will increment a player's level by one at each call
     */
    private static void nextLevel( ) {
        currentLevel++;
    }
    
    
    /**
     * This will help get the current game life of a player
     * @return integer
     */
    public static int getGameLife(){
        return gameLife;
    }
    
    
    
    /**
     * this will help to call nextLevel method outside of this class
     */
    public static void callNextLevel( ) {
        nextLevel();
    }
    
}
