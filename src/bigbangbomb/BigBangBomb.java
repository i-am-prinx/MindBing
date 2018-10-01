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

    /**
     * this helps to pack the element within the frame, using SquareFrame object
     */
    public static void packSquareFrame() {
        squareFrame.pack();
    }

    /**
     * Helps to set the width of the frame using the object of SquareFrame.
     *
     * @param width desired width to set the frame to
     * @param height desired height to set the frame to
     */
    public static void setSquareFrameWH(int width, int height) {
        squareFrame.setSize(width, height);
    }
}
