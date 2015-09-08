import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;


public class SelectNewUsers extends JPanel implements ActionListener{
	private JPasswordField passwordFieldP1;
	private JPasswordField passwordFieldP2;
	JLabel SelectplayersLabel;
	JLabel Player1Label;
	JLabel Player2Label;
	JScrollPane scrollPaneP1;
	JList player1;
	JScrollPane scrollPaneP2;
	JList player2;
	JButton SelectPlayersbtn;
	JLabel lblEnterPlayers;
	JLabel lblNewLabel;
	/**
	 * this is the constructor of the panel to choose new users to play a game
	 */
	public SelectNewUsers(){
		setSize(500,500);
		setLayout(null);

		SelectplayersLabel = new JLabel("Please Select Players");
		SelectplayersLabel.setBounds(157, 25, 135, 16);
		add(SelectplayersLabel);

		Player1Label = new JLabel("Player 1");
		Player1Label.setBounds(100, 51, 61, 16);
		add(Player1Label);

		Player2Label = new JLabel("Player 2");
		Player2Label.setBounds(298, 51, 61, 16);
		add(Player2Label);

		scrollPaneP1 = new JScrollPane();
		scrollPaneP1.setBounds(52, 73, 135, 163);
		add(scrollPaneP1);

		player1 = new JList(FileHandling.getListOfUsers());
		scrollPaneP1.setViewportView(player1);

		scrollPaneP2 = new JScrollPane();
		scrollPaneP2.setBounds(258, 73, 135, 163);
		add(scrollPaneP2);

		player2 = new JList(FileHandling.getListOfUsers());
		scrollPaneP2.setViewportView(player2);

		SelectPlayersbtn = new JButton("Select Players");
		SelectPlayersbtn.addActionListener(this);
		SelectPlayersbtn.setBounds(167, 335, 117, 29);
		add(SelectPlayersbtn);

		passwordFieldP1 = new JPasswordField();
		passwordFieldP1.setBounds(52, 278, 135, 29);
		add(passwordFieldP1);

		lblEnterPlayers = new JLabel("Enter Player 1's user password");
		lblEnterPlayers.setBounds(25, 248, 190, 34);
		add(lblEnterPlayers);

		lblNewLabel = new JLabel("Enter Player 2's user password");
		lblNewLabel.setBounds(237, 248, 190, 34);
		add(lblNewLabel);

		passwordFieldP2 = new JPasswordField();
		passwordFieldP2.setBounds(258, 278, 135, 28);
		add(passwordFieldP2);
		setVisible(true);
	}
	

	

	@Override
	/**
	 * this method adds functionality to the jbutton on the panel which will on click open 2 new frames and close the startup frame
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==SelectPlayersbtn){
			String pwordP1 = passwordFieldP1.getText();
			String pwordP2 = passwordFieldP2.getText();
			boolean p1Credentials = FileHandling.checkCredentials((String) player1.getSelectedValue(), (String) pwordP1);
			boolean p2Credentials = FileHandling.checkCredentials((String) player2.getSelectedValue(), (String) pwordP2);
			if(p1Credentials==false){
				JOptionPane.showMessageDialog(null,"Player 1's Password doesn't match the one registered for that user."
						+ "Please re-enter the password to continue.","Password Mismatch",JOptionPane.WARNING_MESSAGE);
				passwordFieldP1.setText("");
				passwordFieldP2.setText("");
			}
			if(p2Credentials==false){
				JOptionPane.showMessageDialog(null,"Player 2's Password doesn't match the one registered for that user."
						+ "Please re-enter the password to continue.","Password Mismatch",JOptionPane.WARNING_MESSAGE);
				passwordFieldP1.setText("");
				passwordFieldP2.setText("");
			}
			if(p1Credentials==true && p2Credentials==true)
			{
				FileHandling.setCurrentPlayers((String)player1.getSelectedValue(), (String)player2.getSelectedValue());
				InItFrame.frame.dispose();
				new GameFrame1();
				new GameEmulatorFrame();

			}

		}
	}
}
