package bigbangbomb;

/**
 *
 * @author Agbonxoft Prince
 */
public class BigBangBomb {
    static SquareFrame squareFrame;
    public static void main(String[] args) {
        squareFrame = new SquareFrame();
    }
    
    public static void packSquareFrame( ){
        squareFrame.pack();
    }
    
    public static void setSquareFrameWH(int width, int height) {
        squareFrame.setSize(width, height);
    }
}
