import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class DisplayFileHistory extends JPanel {
	/**
	 * constructs panel to display data form file
	 */
	public DisplayFileHistory(){
		setSize(500,500);
		setLayout(null);
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 92, 494, 402);
		add(textArea);
		textArea.setText(bydate());
	}
	/**
	 * display the sorting of file by date of the game
	 * @return string to be added to jta
	 */
	public static String bydate(){
		File history= new File("P3History.txt");
		String tempstring="";
		ArrayList<String> str=Sorting.sortByDate(FileHandling.fileToArrayList(history));
		for (String string : str) {
			String[] line= string.split(" ");
			tempstring+= "Winner:"+line[0]+" Score: "+line[1]+" Looser :"+line[2]+" Score: "+
			line[3]+" Date: "+line[4]+" " +line[5]+"\n";
		}
		return tempstring;
	}
}
