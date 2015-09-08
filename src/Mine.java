import java.awt.Graphics;


public class Mine extends GameObjects {
/**
 * this methos draws a mine
 * @param g graphics object
 * @param x coordinate of x 
 * @param y cordinate of y
 */
	public static void drawBlackBall(Graphics g, int x, int y){
		int width;
		int height;
		width=height=GameObjects.ballSize;
		g.fillOval(x, y, width, height);
	}
}
