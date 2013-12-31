import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
/*
 * Rectangle brain is the brain for the rectangle shape and extends brain 
 * so that it has the rotate method 
 */
public class RectangleBrain extends Brain{
	protected int height, width;
	//constructor 
	public RectangleBrain(int width, int height, int screenW, int screenH){
		this.width = width;
		this.height = height; 
		this.screenW = screenW;
		this.screenH = screenW;
		//center point - (half of width, half height) = rectangle placed top left corner 
		double x1 = (this.screenW/2)-(this.width/2);
		double y1 = (this.screenH/2)-(this.height/2);
		p1 = new Point2D.Double(x1, y1);
		shape = new Rectangle2D.Double(p1.getX(), p1.getY(), width, height);
	}
	//for when the frame is resized 
	public void setScreenSizes(int sWidth, int sHeight){
		super.setScreenSizes(sWidth, sHeight);
		double x1 = (screenW/2)-(width/2);
		double y1 = (screenH/2)-(height/2);
		p1 = new Point2D.Double(x1, y1);
		shape = new Rectangle2D.Double(p1.getX(), p1.getY(), width, height);
	}
	
}
