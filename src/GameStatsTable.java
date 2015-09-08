import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import javax.swing.JOptionPane;


public class GameStatsTable {
	/**
	 * draws the table displayed in game
	 * @param g graphics object
	 * @param x X coordinate of where it will be drawn
	 * @param y y coordinate of where it will be drawn
	 * @throws Exception if there arent currently selected players then exception is thrown
	 */
	public static  void drawTable(Graphics g, int x, int y)throws Exception{
		int width=250;
		int height=35;
		String[] users=FileHandling.getCurrentPlayer();
		try{
			if(users.length==0)
				throw new Exception("No Currently Selected players. Please selectPlayers");
		}catch(Exception e){
			GameFrame1.frame.dispose();
			new InItFrame();
			int answer= JOptionPane.showConfirmDialog(null,"You havent selected users to play and therefore the game cannot start."
					+ "\nWould you like to choose them now?",
					"Havent Selected Users",JOptionPane.YES_NO_OPTION);
			if(answer== JOptionPane.YES_OPTION){
				new ChoosePlayersFrame();
			}
		}
		g.setColor(Color.orange);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		g.setColor(Color.GREEN);
		g.fillRect(x, y+35, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y+35, width, height);
		g.setColor(Color.CYAN);
		g.fillRect(x, y+70, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y+70, width, height);
		g.drawString("Player", x+10, y+25);
		g.drawString("Score", x+85, y+25);
		g.drawString("Distance", x+170, y+25);
		g.drawString(users[0], x+10, y+60);
		g.drawString(users[1], x+10, y+95);
		
	}

}
