import javax.swing.JFrame;


public class AddNewUserFrame {
	public static JFrame frame;
	/**
	 *constructs the frme to display the add user panel
	 */
	public AddNewUserFrame(){
		frame= new JFrame("Create New User Account");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(new AddNewUser());
		frame.setVisible(true);
	}
}
