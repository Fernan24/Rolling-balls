import javax.swing.JFrame;


public class ChoosePlayersFrame {
	public static JFrame frame;
	/**
	 * constructs frame that shows the panel to choose new players
	 * 
	 */
	public ChoosePlayersFrame(){
		frame= new JFrame("Create New User Account");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(new SelectNewUsers());
		frame.setVisible(true);
	}
}
 