import javax.swing.JFrame;


public class InItFrame extends JFrame {
	public static JFrame frame;
	public InItFrame(){
		frame= new JFrame("The Rolling Balls Game");
		frame.setSize(1000, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.setMenuBar(new Jmenu());
		frame.add(new StartupPanel());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InItFrame();
	}
}
