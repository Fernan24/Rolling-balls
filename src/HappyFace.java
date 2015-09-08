import java.awt.Color;
import java.awt.Graphics;


public class HappyFace extends GameObjects{
	


	public static void drawHappyFace(Graphics g,int x, int y){
		int width;
		int height;
		width=height=GameObjects.ballSize;
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		g.drawArc(x+3, y, width-6, height-5, 225, 90 );
		g.fillOval(x+5, y+5, 4, 4);
		g.fillOval(x+15, y+5, 4, 4);
	}
	
}
