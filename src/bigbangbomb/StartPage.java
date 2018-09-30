package bigbangbomb;


import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;


public class StartPage {
    private static JButton startBtn, exitBtn, helpBtn;
    private static JPanel startPagePanel, squaresContainer, square;
    private static JPanel notifyBar;
    private static GridBagConstraints grid;
    
    public static JPanel configureStartPagePanel( ) {
        startPagePanel = new JPanel( );
        startPagePanel.setLayout(new GridBagLayout());
        grid = new GridBagConstraints();
        
        startBtn = new JButton("start game");
        startBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        startBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        grid.gridx = 0;
        grid.gridy = 0;
        grid.insets = new Insets( 3, 3, 3, 3);
        startPagePanel.add(startBtn, grid);
        
        helpBtn = new JButton("instructions");
        helpBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        helpBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        grid.gridx = 0;
        grid.gridy = 1;
        grid.insets = new Insets( 3, 3, 3, 3);
        startPagePanel.add(helpBtn, grid);
        
        exitBtn = new JButton("exit game");
        exitBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        exitBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        grid.gridx = 0;
        grid.gridy = 2;
        grid.insets = new Insets( 3, 3, 3, 3);
        startPagePanel.add(exitBtn, grid);
        
        
        
        
        startBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e ) {
                startPagePanel.setVisible(false);
                squaresContainer = SquareFrame.squareContainer();
                squaresContainer.setVisible(true);
                notifyBar = SquareFrame.getNotifyBar();
                notifyBar.setVisible(true);
                BigBangBomb.packSquareFrame();
            }
        });
        
        helpBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e ) {
                
            }
        });
        
        exitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e ) {
                
            }
        });
        
        
        return startPagePanel;
    }
    

}