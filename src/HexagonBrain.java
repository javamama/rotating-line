import java.awt.geom.Point2D;
/*
 * a hexagon is a polygon with 6 sides
 * HexagonBrain is a PolygonBrain with 6 vertices
 * will create a regular hexagon
 * given a center of (screenW/2,screenH/2) and a sideLength,
 * it will draw the hexagon
 */

public class HexagonBrain extends PolygonBrain{
	private int sideLength; 
	private Point2D.Double p2,p3,p4,p5,p6; //the other 5 points of the hexagon
	// arrays of the x and y coordinates
	private int[] xCoord;
	private int[] yCoord;
	public HexagonBrain(int width, int height, int sideLength){
		// set the width and height to 
		this.screenW = width;
		this.screenH = height;
		this.sideLength = sideLength;
		// create the 6 points of the hexagon
		double x1 = screenW/2 - sideLength/2;
		double y1 = screenH/2 - ((sideLength*Math.sqrt(3))/2);
		double x2 = screenW/2 - sideLength;
		double y2 = screenH/2;
		double x3 = screenW/2 - sideLength/2;
		double y3 = screenH/2 + (sideLength*Math.sqrt(3)/2);
		double x4 = screenW/2 + sideLength/2;
		double y4 = screenH/2 + (sideLength*Math.sqrt(3)/2);
		double x5 = screenW/2 + sideLength;
		double y5 = screenH/2;
		double x6 = screenW/2 + sideLength/2;
		double y6 = screenH/2 - (sideLength*Math.sqrt(3)/2);
		// sets the x and y coordinates to new Point2Ds 
		p1 = new Point2D.Double(x1,y1);
		p2 = new Point2D.Double(x2,y2);
		p3 = new Point2D.Double(x3,y3);
		p4 = new Point2D.Double(x4,y4);
		p5 = new Point2D.Double(x5,y5);
		p6 = new Point2D.Double(x6,y6);
		// create the arrays of x and y coordinates based on the above Points
		int[] x = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX(),(int)p4.getX(),(int)p5.getX(),(int)p6.getX()};
		int[] y = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY(),(int)p4.getY(),(int)p5.getY(),(int)p6.getY()};
		// set these arrays equal to the private ones
		xCoord = x;
		yCoord = y;
		// create a new PolygonBrain gets the shape of the created polygon
		// shape is set to the constructed polygon
		shape = new PolygonBrain(xCoord,yCoord,6).getShape();
	}
	// this method is called when the frame is resized
	// it will recalculate the new points and make a new
	// hexagon
	public void setScreenSizes(int width, int height){
		// sets the new width and height to screenW and screenH
		super.setScreenSizes(width, height);
		// does the same thing in the constructor
		double x1 = screenW/2 - sideLength/2;
		double y1 = screenH/2 - ((sideLength*Math.sqrt(3))/2);
		double x2 = screenW/2 - sideLength;
		double y2 = screenH/2;
		double x3 = screenW/2 - sideLength/2;
		double y3 = screenH/2 + (sideLength*Math.sqrt(3)/2);
		double x4 = screenW/2 + sideLength/2;
		double y4 = screenH/2 + (sideLength*Math.sqrt(3)/2);
		double x5 = screenW/2 + sideLength;
		double y5 = screenH/2;
		double x6 = screenW/2 + sideLength/2;
		double y6 = screenH/2 - (sideLength*Math.sqrt(3)/2);
		p1 = new Point2D.Double(x1,y1);
		p2 = new Point2D.Double(x2,y2);
		p3 = new Point2D.Double(x3,y3);
		p4 = new Point2D.Double(x4,y4);
		p5 = new Point2D.Double(x5,y5);
		p6 = new Point2D.Double(x6,y6);
		int[] x = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX(),(int)p4.getX(),(int)p5.getX(),(int)p6.getX()};
		int[] y = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY(),(int)p4.getY(),(int)p5.getY(),(int)p6.getY()};
		xCoord = x;
		yCoord = y;
		shape = new PolygonBrain(xCoord,yCoord,6).getShape();
	}
}
