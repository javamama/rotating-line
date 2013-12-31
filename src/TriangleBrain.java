import java.awt.geom.Point2D;
/*
 * class triangle brain utilizes polygon brain to create a triangle
 * it calculates the points using a sidelength and the center point 
 */
public class TriangleBrain extends PolygonBrain {
	private int sideLength;
	private Point2D p2, p3;
	int[] xCoord;
	int[] yCoord;
	//creates a triangle and calculates the points 
	public TriangleBrain(int width, int height, int sideLength) {
		this.screenW = width;
		this.screenH = height;
		this.sideLength = sideLength;
		//calculating all the coordinates for the points 
		double x1 = screenW/2;
		double y1 = screenH/2 - ((2*(sideLength/2)*Math.sqrt(3))/3);
		double x2 = screenW/2 - sideLength/2;
		double y2And3 = screenH/2 + ((sideLength/2)*Math.sqrt(3))/3;
		double x3 = screenW/2 + sideLength/2;
		p1 = new Point2D.Double(x1, y1);
		p2 = new Point2D.Double(x2, y2And3);
		p3 = new Point2D.Double(x3, y2And3);
		int[] x = {(int)p1.getX(), (int)p2.getX(),(int)p3.getX()};
		int[] y = {(int)p1.getY(), (int)p2.getY(), (int)p3.getY()};
		xCoord = x;
		yCoord = y;
		shape = new PolygonBrain(xCoord, yCoord, 3).getShape();
	}
	//for when the screen is resized, recalculates the points 
	public void setScreenSizes(int width, int height){
		super.setScreenSizes(width, height);
		double x1 = screenW/2;
		double y1 = screenH/2 - ((2*(sideLength/2)*Math.sqrt(3))/3);
		double x2 = screenW/2 - sideLength/2;
		double y2And3 = screenH/2 + ((sideLength/2)*Math.sqrt(3))/3;
		double x3 = screenW/2 + sideLength/2;
		p1 = new Point2D.Double(x1, y1);
		p2 = new Point2D.Double(x2, y2And3);
		p3 = new Point2D.Double(x3, y2And3);
		int[] x = {(int)p1.getX(), (int)p2.getX(),(int)p3.getX()};
		int[] y = {(int)p1.getY(), (int)p2.getY(), (int)p3.getY()};
		xCoord = x;
		yCoord = y;
		shape = new PolygonBrain(xCoord, yCoord, 3).getShape();
		shape = new PolygonBrain(xCoord, yCoord, 3).getShape();
	}


}
