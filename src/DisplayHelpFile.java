import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DisplayHelpFile extends JPanel {
	/**
	 * cosnturcts panel to display help
	 */
	public DisplayHelpFile(){
		setSize(500,350);
		File help= new File("help.txt");
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 6, 494, 344);
		add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(6, 6, 494, 344);
		add(scrollPane);
		textArea.setText(FileHandling.readfile(help));
		setVisible(true);
	}
	

}
