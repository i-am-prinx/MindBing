package bigbangbomb;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class SquareFrame extends JFrame {
    private static JPanel gamePanel, squaresContainer, square, layerOne, layerTwo;
    private static JPanel startPagePanel = StartPage.configureStartPagePanel();
    private static JPanel notifyBar = EventNotifier.notificationBar();
    private static JPanel restartPagePanel = RestartPage.getRestartPagePanel();
    
    
    SquareFrame( ) {
        super("*-Mind Bing-*");
        setLayout(new BorderLayout());
        
        configureGameSquares( );
        
        square.setVisible(false);
        restartPagePanel.setVisible(false);
        notifyBar.setVisible(false);
        
        
        add(restartPagePanel, BorderLayout.NORTH);
        add(square, BorderLayout.CENTER);
        add(notifyBar, BorderLayout.SOUTH);
        add(startPagePanel, BorderLayout.WEST);
        setVisible(true);

        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    private static void configureGameSquares( ) {
        square = new JPanel( );
        square.setLayout(new MigLayout( ));
        
        JPanel[][] fp = new GridDimension().callNextGrid();
        
        for (int i = 0; i < fp.length; i++) {
            for (int j = fp[i].length - 1; j > 0; j--) {
                if (j == 1) {
                    System.out.print("#  \n");
                    square.add(fp[i][j], "width 30:80:80, height 30:80:80, wrap");
                } else {
                    System.out.print("#  ");
                    square.add(fp[i][j], "width 30:80:80, height 30:80:80");
                }
            }
        }
    }
    
    public static JPanel squareContainer( ){
        return square;
    }
    
    public static JPanel getGamePanel( ) {
        return gamePanel;
    }
    
    public static void hideSquareContainer( ) {
        square.setVisible(false);
    }
    
    public static void showSquareContainer( ) {
        square.setVisible(true);
    }
    
    public static JPanel getRestartPage() {
        return restartPagePanel;
    }
    
    public static JPanel getNotifyBar( ) {
        return notifyBar;
    }
    
    public static JPanel getStartPagePanel( ) {
        return startPagePanel;
    }
}