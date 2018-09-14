package bigbangbomb;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;



/**
 *
 * @author Agbonxoft Prince
 */
public class StartPage extends JFrame implements ActionListener{
    private static JPanel box;
    private static JLabel gameName;
    private static JPanel gameTitle = new JPanel();
    private static JButton startGameBtn, exitGameBtn, helpBtn;
    private static GridBagConstraints grid = new GridBagConstraints();
    
    StartPage(){
        super("*- Mind~Bing -*");
        setLayout(new GridBagLayout());
        
        gameTitle.setLayout(new MigLayout());
        gameName = new JLabel("Mind Bing");
        gameName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        gameName.setForeground(Color.BLUE);
        gameName.setBounds(10, 10, 10, 10);
        
        box = new JPanel();
        box.setSize(250, 50);
        box.setBounds(25, 25, 25, 25);
        box.setBackground(Color.RED);
        
        gameTitle.add( box, "push");
        
        gameTitle.add(gameName, "push");
        
        box = new JPanel();
        box.setSize(250, 50);
        box.setBounds(25, 25, 25, 25);
        box.setBackground(Color.GREEN);
        gameTitle.add( box, "push" );
        
        
        grid.gridx = 0;
        grid.gridy = 0;
        grid.insets = new Insets(5, 5, 5, 5);
        grid.ipadx = 5;
        grid.ipady = 5;
        
        add(gameTitle, grid);
        
        
        startGameBtn = new JButton("start");
        startGameBtn.setFont(new Font( Font.MONOSPACED, Font.BOLD, 20));
        startGameBtn.setBackground(Color.DARK_GRAY);
        startGameBtn.setForeground(Color.lightGray);
        
        grid.gridx = 0;
        grid.gridy = 1;
        grid.insets = new Insets(5, 5, 5, 5);
        grid.ipadx = 5;
        grid.ipady = 5;
        
        add(startGameBtn, grid);
        
        
        helpBtn = new JButton("help");
        helpBtn.setFont(new Font( Font.MONOSPACED, Font.BOLD, 20));
        helpBtn.setBackground(Color.darkGray);
        helpBtn.setForeground(Color.lightGray);
        
        grid.gridx = 0;
        grid.gridy = 2;
        grid.insets = new Insets(5, 5, 5, 5);
        grid.ipadx = 5;
        grid.ipady = 5;
        
        add(helpBtn, grid);
        
        
        exitGameBtn = new JButton("exit");
        exitGameBtn.setFont(new Font( Font.MONOSPACED, Font.BOLD, 20));
        exitGameBtn.setBackground(Color.darkGray);
        exitGameBtn.setForeground(Color.lightGray);
        
        grid.gridx = 0;
        grid.gridy = 3;
        grid.insets = new Insets(5, 5, 5, 5);
        grid.ipadx = 5;
        grid.ipady = 5;
        
        add(exitGameBtn, grid);
        
        
        startGameBtn.addActionListener(this);
        exitGameBtn.addActionListener(this);
        helpBtn.addActionListener( this );
        
        
        
        pack();
        setVisible(true);
        this.setSize(400, 340);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       JButton src = (JButton) e.getSource();
       if ( src == startGameBtn ){
           this.dispose();
           SquareFrame frame = new SquareFrame();
       } 
       else if (src == helpBtn ){
           
       }
       else if ( src == exitGameBtn ){
           this.dispose();
           System.exit(0);
       }
    }
    
}
