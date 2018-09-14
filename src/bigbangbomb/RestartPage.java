package bigbangbomb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Agbonxoft Prince
 */
public class RestartPage {
    private static JPanel restartPage = new JPanel();
    private static JButton restartBtn, homeBtn, exitBtn;
    private static JLabel gameOverlbl;
    
    /**
     *
     * @return JPanel
     */
    public static JPanel getRestartPagePanel() {
        return restartPage;
    }
    
    /**
     * helps to configure all components that will be displayed in the restart
     * page panel
     */
    public static void configureRestartPage() {
        restartPage.setLayout(new MigLayout());
        
        gameOverlbl = new JLabel("GAME OVER");
        gameOverlbl.setFont(new Font( Font.MONOSPACED, Font.BOLD, 60));
        gameOverlbl.setForeground(Color.red);
        
        restartPage.add( gameOverlbl, "push, span, wrap");
        
        restartBtn = new JButton("restart");
        restartBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30 ));
        restartBtn.setBackground(Color.darkGray);
        restartBtn.setForeground(Color.green);
        
        restartPage.add( restartBtn, "push");
        
        
        homeBtn = new JButton("home");
        homeBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30 ));
        homeBtn.setBackground(Color.darkGray);
        homeBtn.setForeground(Color.green);
        
        
        restartPage.add( homeBtn, "push");
        
        
        exitBtn = new JButton("exit");
        exitBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30 ));
        exitBtn.setBackground(Color.darkGray);
        exitBtn.setForeground(Color.green);
        
        
        restartBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });
        
        
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        
        
        homeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        
        restartPage.add( exitBtn, "span, push");
        restartPage.setVisible(true);
        restartPage.setBackground(Color.DARK_GRAY);
    }
}
