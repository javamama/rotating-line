import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D; 
/*
 * Brain serves as a class that calculates the new points
 * to rotate and shape. It has one Point and a Shape which it will rotate
 * a by one degree (ONE_TURN). It also has the width and height of the frame
 * it will be paining on.
 */
public abstract class Brain {
	protected Point2D p1;
	protected Shape shape;
	//size of angle
	protected double ONE_TURN = 0.017;
	protected int screenW, screenH;
	public Brain(){
		p1= new Point2D.Double(0,0);
	}
	public Brain(Point2D p1){
		this.p1=p1;
	}
	public Shape getShape(){
		return shape;
	}
	//for when the screen resizes 
	public void setScreenSizes(int width, int height){
		screenW = width;
		screenH = height;
	}
	//toggles the direction set by the classes(size of angle depends upon the shape)
	public void toggleDirection(){
		ONE_TURN = -ONE_TURN;
	}
	/*
	 * will rotate shape and set the rotated shape to the private one within 
	 * the brain hierarchy 
	 */
	public void calcPoint() {
		AffineTransform at = new AffineTransform();
		at.rotate(ONE_TURN, screenW/2, screenH/2);
		shape = at.createTransformedShape(shape);
	}
}
