import java.awt.Color;
import java.awt.Graphics;


public class Player2Ball {
	/**
	 * this method draws a ball corresponding to player 2 on the game window
	 * @param g object of graphics
	 * @param x rectangular x coordinate to paint object
	 * @param y rectangular y coordinate to paint object
	 */
	public static void drawPlayer2Ball(Graphics g, int x, int y){
		int height;
		int width;
		height=width=25;
		g.setColor(Color.CYAN);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
		
	}
}
