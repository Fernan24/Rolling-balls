import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StartupPanel extends JPanel {

	/**
	 * Create the panel wihch is shown at the beggining of the execution.
	 */
	public StartupPanel() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1000,700);
		setLayout(null);
		
		JButton choosePlayers = new JButton("Choose Players");
		choosePlayers.addActionListener(new ActionListener() {
			/**
			 * this method adds fucntionality to the jbutton which on click will open a new frame
			 */
			public void actionPerformed(ActionEvent arg0) {
				new ChoosePlayersFrame();
			}
		});
		choosePlayers.setBounds(78, 552, 139, 29);
		add(choosePlayers);
		
		JButton playNow = new JButton("Play Now");
		playNow.addActionListener(new ActionListener() {
			/**
			 * this method add fucntionality to the jbutton which will on click open 2 frames and dispose the frame
			 * where this panel is being displayed
			 */
			public void actionPerformed(ActionEvent e) {
				new GameFrame1();
				InItFrame.frame.dispose();
				new GameEmulatorFrame();
			}
		});
		playNow.setBounds(441, 552, 117, 29);
		add(playNow);
		
		JButton signUp = new JButton("Sign up");
		signUp.setBounds(804, 552, 117, 29);
		signUp.addActionListener(new ActionListener() {
			/**
			 * this method adds fucntionality to the jbutton which on click will open a new frame
			 */
			public void actionPerformed(ActionEvent e) {
				new AddNewUserFrame();
				
			}
		});
		add(signUp);
		
		JLabel lblClickHereTo = new JLabel("Start New Game with new players.");
		lblClickHereTo.setBounds(41, 514, 212, 16);
		add(lblClickHereTo);
		
		JLabel lblClickHereTo_1 = new JLabel("Play new Game with currently selected players");
		lblClickHereTo_1.setBounds(353, 514, 294, 16);
		add(lblClickHereTo_1);
		
		JLabel lblCreateANew = new JLabel("Create a new user:");
		lblCreateANew.setBounds(804, 514, 117, 16);
		add(lblCreateANew);
		
		JLabel lblTheRollingBalls = new JLabel("The Rolling balls Game");
		lblTheRollingBalls.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 40));
		lblTheRollingBalls.setBounds(192, 188, 591, 53);
		add(lblTheRollingBalls);
		
		JLabel lblNewLabel = new JLabel("by Fernando Rodriguez ");
		lblNewLabel.setBounds(476, 264, 212, 42);
		add(lblNewLabel);
		
		

	}
}
