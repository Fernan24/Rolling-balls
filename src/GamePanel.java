import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GamePanel extends JPanel {
	/**
	 * constructs panel
	 */
	public GamePanel() {
		setLayout(null);
		setBackground(Color.WHITE);
	}
	ArrayList<Point> happyFace= new ArrayList<Point>();
	ArrayList<Point> mine= new ArrayList<Point>();
	ArrayList<Point> obstacle= new ArrayList<Point>();
	ArrayList<Point> p1ball= new ArrayList<Point>();
	ArrayList<Point> p2ball= new ArrayList<Point>();

/**
 * paints all the components displayed in the game panel
 */
	public void paintComponent(Graphics g){
		JButton b1= new JButton("Shoot");
		b1.setForeground(Color.GREEN);
		b1.setBounds(100, 600, 100, 25);
		add(b1);
		
		JButton b2= new JButton("Shoot");
		b2.setForeground(Color.CYAN);
		b2.setBounds(300, 600, 100, 25);
		add(b2);
		
		JButton abort = new JButton("Abort Game");
		abort.setForeground(Color.ORANGE);
		abort.setBounds(500, 600, 125, 25);
		add(abort);
		
		int balls=20;
		g.drawRect(45, 50, 445, 450);//draw rect area of the game
		for(int i=1;i<11;i++){
			g.drawLine(45+40*i, 50, 45+40*i, 500);//veritcal lines
			g.drawLine(45, 50+40*i, 490, 50+40*i);// horizontal lines
		}
		try {
			GameStatsTable.drawTable(g, 500, 300);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<=balls;i++){
			randomCoord(happyFace);
			randomCoord(mine);
			randomCoord(obstacle);
			randomCoord(p1ball);
			randomCoord(p2ball);
		}
		displayBalls(happyFace, g, "happyface");
		displayBalls(obstacle, g,"obstacle");
		displayBalls(mine, g, "mine");
		displayBalls(p1ball, g,"p1");
		displayBalls(p2ball, g,"p2");
	}
	
	/**
	 * generates random coordinates of the balls displayed in game
	 * @param arr list where the coordinates will be stored 
	 */
	public void randomCoord(ArrayList<Point> arr){
		int x=(int) (Math.random()*(445-45)+45);
		int y=(int) (Math.random()*(450-50)+50);
		Point point =new Point(x,y);
		arr.add(point);
	}
	/**
	 * this method paints the balls in the panel of the game
	 * @param arr list of ball coordinates
	 * @param g graphics object
	 * @param type name of the ball type
	 */
	public void displayBalls(ArrayList<Point> arr,Graphics g, String type ){
		if(type.equals("happyface")){
			for (Point ball : arr) {
				HappyFace.drawHappyFace(g, ball.getxCord(), ball.getyCord());
			}
		}
		if(type.equals("mine")){
			for(Point ball: arr){
				Mine.drawBlackBall(g, ball.getxCord(), ball.getyCord());
			}
		}
		if(type.equals("p1")){
			for(Point ball: arr){
				Player1Ball.drawPlayer1Ball(g, ball.getxCord(), ball.getyCord());
			}
		}
		if(type.equals("p2")){
			for(Point ball: arr){
				Player2Ball.drawPlayer2Ball(g, ball.getxCord(), ball.getyCord());
			}
		}
		if(type.equals("obstacle")){
			for(Point ball: arr){
				Obstacle.drawObstacle(g, ball.getxCord(), ball.getyCord());
			}
		}
	}
	


}
