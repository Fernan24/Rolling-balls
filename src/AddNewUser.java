import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class AddNewUser extends JPanel implements ActionListener{
	private JTextField UsernameTxtField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmTxtField;
	private String username;
	private String password;
	private String confrimPassword;
	/**
	 * construacts the panel which display the GUI of this panel
	 */
	public AddNewUser(){
		setSize(500,500);
		setVisible(true);

		setLayout(null);

		JLabel lblCreateNewUser = new JLabel("Create New User");
		lblCreateNewUser.setBounds(170, 33, 110, 48);
		add(lblCreateNewUser);

		JLabel usernamelbl = new JLabel("Enter your new Username:");
		usernamelbl.setBounds(143, 98, 164, 16);
		add(usernamelbl);

		UsernameTxtField = new JTextField();
		UsernameTxtField.setBounds(158, 127, 134, 28);
		add(UsernameTxtField);
		UsernameTxtField.setColumns(10);

		JLabel passowrdlbl = new JLabel("Enter your new password:");
		passowrdlbl.setBounds(144, 167, 161, 16);
		add(passowrdlbl);

		passwordField = new JPasswordField();
		passwordField.setBounds(158, 195, 134, 28);
		add(passwordField);

		JLabel confirmPasswordField = new JLabel("Confirm your password");
		confirmPasswordField.setBounds(150, 238, 149, 16);
		add(confirmPasswordField);

		passwordConfirmTxtField = new JPasswordField();
		passwordConfirmTxtField.setBounds(160, 266, 132, 28);
		add(passwordConfirmTxtField);

		JButton createUserBtn = new JButton("Create User");
		createUserBtn.setBounds(166, 311, 117, 29);
		add(createUserBtn);
		createUserBtn.addActionListener(this);	


	}
	/**
	 * adds functionality to the add user button which will validate the input and the add user to file
	 */		
	public void actionPerformed(ActionEvent e){
		String username = UsernameTxtField.getText();
		String password = passwordField.getText();
		String confirmPassword = passwordConfirmTxtField.getText();
		if(username.contains(" ")){
			JOptionPane.showMessageDialog(null,"Username cannot contain a space character, please use a different username.",
					"Invalid Username",JOptionPane.WARNING_MESSAGE);
			UsernameTxtField.setText("");
			passwordField.setText("");
			passwordConfirmTxtField.setText("");
			return;
		}
		if(FileHandling.checkForExistingUser(username)){
			JOptionPane.showMessageDialog(null,"Username already created, please use a different username.",
					"Exisisting Username",JOptionPane.WARNING_MESSAGE);
			UsernameTxtField.setText("");
			passwordField.setText("");
			passwordConfirmTxtField.setText("");
			return;
		}
		if(username.length()<4){
			JOptionPane.showMessageDialog(null,"Your username must be at least 4 charcaters long.",
					"Username too Short",JOptionPane.WARNING_MESSAGE);
			UsernameTxtField.setText("");
			passwordField.setText("");
			passwordConfirmTxtField.setText("");
			return;
		}
		if(password.length()<4){
			JOptionPane.showMessageDialog(null,"Your password must be at least 4 charcaters long.",
					"Password too Short",JOptionPane.WARNING_MESSAGE);
			UsernameTxtField.setText("");
			passwordField.setText("");
			passwordConfirmTxtField.setText("");
			return;
		}
		if(!password.equals(confirmPassword)){
			JOptionPane.showMessageDialog(null,"Passwords don't match, please try again.","Password Mismatch",
					JOptionPane.WARNING_MESSAGE);
			UsernameTxtField.setText("");
			passwordField.setText("");
			passwordConfirmTxtField.setText("");
			return;
		}
		FileHandling.addUserToFile(username, password);
		int answer= JOptionPane.showConfirmDialog(null,"Your user account has been added to our database. \n Would you like to add another user?",
				"Add another user?",JOptionPane.YES_NO_OPTION);
		if(answer== JOptionPane.YES_OPTION){
			AddNewUserFrame.frame.dispose();
			new AddNewUserFrame();
		}
		else{
			AddNewUserFrame.frame.dispose();
			new ChoosePlayersFrame();
		
		}

	}

}
