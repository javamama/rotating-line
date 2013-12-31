import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/*
 * class line brain utilizes Line2D for its line that it prints on the screen and 
 * extends brain because it is the brain for the rotations and changing the direction
 * of the rotations 
 */
public class LineBrain extends Brain{
	private Point2D p2;
	//constructor takes the size of the screen and makes the points and line necessary 
	public LineBrain(int width, int height){
		super(new Point2D.Double(0, 0));
		this.p2 = new Point2D.Double(width, height);
		this.screenH = height;
		this.screenW = width;
		shape = new Line2D.Double(p1, p2);
	}
	//resizes for screen size change 
	public void setScreenSizes(int width, int height){
		super.setScreenSizes(width, height);
		this.p2 = new Point2D.Double(width, height);
		shape = new Line2D.Double(p1, p2);
	}

}
