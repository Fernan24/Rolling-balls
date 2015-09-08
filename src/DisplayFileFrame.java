import javax.swing.JFrame;


public class DisplayFileFrame {
	public static JFrame frame;
	/**
	 * contructs frame to display the diplayfile panel
	 * @param num is used to identify both panles being used by this frame
	 */
	public DisplayFileFrame(int num){
		frame= new JFrame("Show Data");
		frame.setSize(550, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		if(num==1){
			frame.add(new DisplayFileHighScore());	
		}
		if(num==2){
			frame.add(new DisplayFileHistory());
		}
		if(num==3)
			frame.add(new DisplayHelpFile());
		frame.setVisible(true);
	}
}
