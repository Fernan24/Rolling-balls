import java.awt.Color;
import java.awt.Graphics;


public class Obstacle extends GameObjects {
	/**
	 * this method draws an obestacle on the game window
	 * @param g object of graphics
	 * @param x rectangular x coordinate to paint object
	 * @param y rectangular y coordinate to paint object
	 */
	public static void drawObstacle(Graphics g, int x, int y){
		int height;
		int width;
		height=width=GameObjects.ballSize;
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
	}

}
