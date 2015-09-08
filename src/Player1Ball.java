import java.awt.Color;
import java.awt.Graphics;


public class Player1Ball {
	/**
	 * this method draws a ball corresponding to player 1 on the game window
	 * @param g object of graphics
	 * @param x rectangular x coordinate to paint object
	 * @param y rectangular y coordinate to paint object
	 */
	public static void drawPlayer1Ball(Graphics g, int x, int y){
		int height;
		int width;
		height=width=25;
		g.setColor(Color.GREEN);
		g.fillOval(x, y, width, height);
		g.setColor(Color.black);
	}
}
