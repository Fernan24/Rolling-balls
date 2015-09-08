
public class Point {
	private int xCord;
	private int yCord;
	/**
	 * constructor of object of type point which stores an x coordinate and a y coordinate
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public Point(int x,int y){
		setxCord(x);
		setyCord(y);
	}

	/**
	 * @return the xCord
	 */
	public int getxCord() {
		return xCord;
	}

	/**
	 * @param xCord the xCord to set
	 */
	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	/**
	 * @return the yCord
	 */
	public int getyCord() {
		return yCord;
	}

	/**
	 * @param yCord the yCord to set
	 */
	public void setyCord(int yCord) {
		this.yCord = yCord;
	}

}
