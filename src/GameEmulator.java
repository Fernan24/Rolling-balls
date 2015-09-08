import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GameEmulator extends JPanel implements ActionListener{
	String winnerselection;
	String inWinScore;
	String looserselection;
	String inLossScore;
	JTextField txtwinner;
	JTextField txtLooser;
/**
 * this panel simulates that a game was played
 */
	public GameEmulator(){
		setSize(500,350);
		setVisible(true);
		setLayout(null);

		String[] players= FileHandling.getCurrentPlayer();
		JLabel EnterWinnersSocre = new JLabel("Enter Winners Score:");
		EnterWinnersSocre.setBounds(51, 151, 144, 16);
		add(EnterWinnersSocre);

		JLabel ChooseTheWinner = new JLabel("Choose the Winner:");
		ChooseTheWinner.setBounds(51, 83, 125, 16);
		add(ChooseTheWinner);

		txtwinner = new JTextField();
		txtwinner.setBounds(51, 179, 125, 28);
		add(txtwinner);


		JLabel ChooseLosser = new JLabel("Choose the Looser:");
		ChooseLosser.setBounds(287, 83, 125, 16);
		add(ChooseLosser);

		JLabel EnterLoosersScore = new JLabel("Enter Looser's Score:");
		EnterLoosersScore.setBounds(287, 151, 144, 16);
		add(EnterLoosersScore);

		txtLooser = new JTextField();
		txtLooser.setBounds(287, 179, 125, 28);
		add(txtLooser);

		JLabel RecordGameTo = new JLabel("Record Game to History");
		RecordGameTo.setBounds(157, 27, 154, 16);
		add(RecordGameTo);

		JComboBox winnerbox = new JComboBox(players);
		winnerbox.setBounds(51, 111, 125, 28);
		add(winnerbox);
		winnerbox.setSelectedIndex(0);

		JComboBox looserbox = new JComboBox(players);
		looserbox.setBounds(286, 111, 126, 28);
		add(looserbox);
		looserbox.setSelectedIndex(1);

		winnerselection=(String) winnerbox.getSelectedItem();
		looserselection=(String) looserbox.getSelectedItem();

		JButton AddGameTo = new JButton("Add Game to History");
		AddGameTo.addActionListener(this);
		AddGameTo.setBounds(157, 239, 164, 29);
		add(AddGameTo);	
	}

	@Override
	/**
	 * adds functionality to button such as adding data to file when clicked
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(txtwinner.getText().isEmpty()|| txtLooser.getText().isEmpty()||
				txtwinner.getText().matches("[0-9]+")|| txtLooser.getText().matches("[0-9]+")){
			JOptionPane.showMessageDialog(null,"Must entere a valid score","Invalid Score",JOptionPane.WARNING_MESSAGE);
			txtwinner.setText("");
			txtLooser.setText("");
		}
		if(Integer.parseInt(txtwinner.getText())<Integer.parseInt(txtLooser.getText())){
			JOptionPane.showMessageDialog(null,"The winning score must be higher that the looser score"
					+ "Please enter a new score","Invalid Score",JOptionPane.WARNING_MESSAGE);
			txtwinner.setText("");
			txtLooser.setText("");
		}
		else{
			String currDate=MyDate.getCurrentDate();
			File db= new File("UserDataBaseP3.txt");
			FileHandling.gamePlayed(winnerselection, txtwinner.getText(), looserselection, txtLooser.getText(), currDate);
			FileHandling.fileUpdate(FileHandling.fileToArrayList(db), winnerselection, txtwinner.getText(),currDate);
			FileHandling.fileUpdate(FileHandling.fileToArrayList(db), looserselection, txtLooser.getText(),currDate);
			GameEmulatorFrame.frame.dispose();
			
		}
	}


}
