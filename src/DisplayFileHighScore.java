import java.io.File;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DisplayFileHighScore extends JPanel {
	/**
	 * consturcts panel that display text formated by sorting methods
	 */
	public DisplayFileHighScore(){
		setSize(500,500);
		setLayout(null);
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 92, 494, 402);
		add(textArea);
		
		JButton btnByDate = new JButton("by date");
		btnByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(byHSDate());
			}
		});
		btnByDate.setBounds(22, 51, 117, 29);
		add(btnByDate);
		
		JButton btnByScore = new JButton("by High Score");
		btnByScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(byHighestScore());
			}
		});
		btnByScore.setBounds(204, 51, 117, 29);
		add(btnByScore);
		
		JButton btnbyName = new JButton("by Username");
		btnbyName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(byUsername());
			}
		});
		btnbyName.setBounds(377, 51, 117, 29);
		add(btnbyName);
		
		JLabel lblChooseYourDesired = new JLabel("Choose your desired sorting method:");
		lblChooseYourDesired.setBounds(142, 23, 234, 16);
		add(lblChooseYourDesired);
		
		setVisible(true);

	}
	
	/**
	 * display the sorting of file by alphabetical order of the usernames
	 * @return string to be added to jta
	 */
	public static String byUsername(){
		File names= new File("UserDataBaseP3.txt");
		String tempstring="";
		ArrayList<String> str=Sorting.sortByUserName(FileHandling.fileToArrayList(names));
		for (String string : str) {
			String[] line= string.split(" ");
			tempstring+= "User: "+line[0]+" Score: "+line[2]+" Date: "+line[3]+" "+
			line[4]+"\n";
		}
		return tempstring;
	}
	/**
	 * display the sorting of file by highestscore
	 * @return string to be added to jta
	 */
	public static String byHighestScore(){
		File scores= new File("UserDataBaseP3.txt");
		String tempstring="";
		ArrayList<String> str=Sorting.sortByHighestScore(FileHandling.fileToArrayList(scores), 2);
		for (String string : str) {
			String[] line= string.split(" ");
			tempstring+= "User: "+line[0]+" Score: "+line[2]+" Date: "+line[3]+" "+
			line[4]+"\n";
		}
		return tempstring;
		
	}
	/**
	 * display the sorting of file by order of the date of the highscore
	 * @return string to be added to jta
	 */
	public static String byHSDate(){
		File scores= new File("UserDataBaseP3.txt");
		String tempstring="";
		ArrayList<String> str=Sorting.sortByHSDate(FileHandling.fileToArrayList(scores), 3);
		for (String string : str) {
			String[] line= string.split(" ");
			tempstring+= "User: "+line[0]+" Score: "+line[2]+" Date: "+line[3]+" "+
			line[4]+"\n";
		}
		return tempstring;
	}
}
