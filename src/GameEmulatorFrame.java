import javax.swing.JFrame;


public class GameEmulatorFrame {
	public static JFrame frame;
	/**
	 * creates frame that holds panel for gameEmulator
	 */
	public GameEmulatorFrame(){
		frame= new JFrame("Game Finished");
		frame.setSize(500, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(new GameEmulator());
		frame.setVisible(true);
	}
}
