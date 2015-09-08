import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;


public class GameFrame1{
	public static JMenuBar MenuBar;
	public static JMenu PlayNewGameMenu;
	public static JMenuItem CurrentPlayersMenu;
	public static JMenuItem SelectNewPlayersMenu;
	public static JMenu FirstTimePlayerMenu;
	public static JMenuItem CreateNewUserMenu;
	public static JMenu HistoryMenu;
	public static JMenuItem HighScoreMenu;
	public static JMenuItem DateMenu;
	public static JMenu HelpMenu;
	public static JMenuItem DisplayHelpMenu;
	public static JMenu ExitMenu;
	public static JMenuItem ExitMenuItem;
	public static JFrame frame;
	public static boolean bydate=false;
	/** 
	 * constructs frame and adds jmenu to it of where the game is to be displayed
	 */
	public GameFrame1(){
		frame = new JFrame("The Rolling Balls Game");
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
		
		MenuBar = new JMenuBar();
		//Menu Creation
		PlayNewGameMenu = new JMenu("Play New Game");
		CurrentPlayersMenu = new JMenuItem("Current Players");
		CurrentPlayersMenu.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new GameFrame1();
				new GameEmulatorFrame();
			}
		});
		SelectNewPlayersMenu = new JMenuItem("Choose New Players");
		SelectNewPlayersMenu.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ChoosePlayersFrame();
			}
		});
		
		//Add Items To Menu
		PlayNewGameMenu.add(CurrentPlayersMenu);
		PlayNewGameMenu.add(SelectNewPlayersMenu);
		MenuBar.add(PlayNewGameMenu);
		
		//Menu Creation
		FirstTimePlayerMenu = new JMenu("First Time Player");
		CreateNewUserMenu = new JMenuItem("Create New User");
		
		//Add Items To Menu
		FirstTimePlayerMenu.add(CreateNewUserMenu);
		CreateNewUserMenu.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddNewUserFrame();
			}
		});
		MenuBar.add(FirstTimePlayerMenu);
		
		//Menu Creation 
		HistoryMenu = new JMenu("History");
		HighScoreMenu = new JMenuItem("Sort by High Score");
		HighScoreMenu.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new DisplayFileFrame(1);
			}
		});
		DateMenu = new JMenuItem("Sort by Date");
		DateMenu.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new DisplayFileFrame(2);
			}
		});
		
		//Add Items To Menu
		HistoryMenu.add(HighScoreMenu);
		HistoryMenu.add(DateMenu);
		MenuBar.add(HistoryMenu);
		
		//Menu Creation
		HelpMenu= new  JMenu("Help");
		DisplayHelpMenu= new JMenuItem("Show Help");
		DisplayHelpMenu.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new DisplayFileFrame(3);
			}
		});
		
		//Add Item To Menu
		HelpMenu.add(DisplayHelpMenu);
		MenuBar.add(HelpMenu);
		
		//Menu Creation
		ExitMenu= new JMenu("Exit");
		ExitMenuItem= new JMenuItem("Exit Program");
		
		//Add Item To Menu
		ExitMenu.add(ExitMenuItem);
		ExitMenuItem.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		MenuBar.add(ExitMenu);

		
		frame.setJMenuBar(MenuBar);
		
		frame.getContentPane().add(new GamePanel());
		frame.setVisible(true);
	}
	
}
