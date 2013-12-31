import java.awt.geom.Point2D;


public class HexgonBrain extends PolygonBrain{
	private int sideLength;
	private Point2D.Double p2,p3,p4,p5,p6;
	private int[] xCoord;
	private int[] yCoord;
	public HexgonBrain(int sideLength){
		this.sideLength = sideLength;
		double x1 = screenW/2 - sideLength/2;
		double y1 = screenH/2 - (sideLength*Math.sqrt(3)/2);
		double x2 = screenW/2 - sideLength;
		double y2 = screenH/2;
		double x3 = screenW/2 - sideLength/2;
		double y3 = screenH/2 + (sideLength*Math.sqrt(3)/2);
		double x4 = screenW/2 + sideLength/2;
		double y4 = screenW/2 + sideLength/2;
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
		int[] y = {(int)p1.getY(),(int)p3.getY(),(int)p3.getY(),(int)p4.getY(),(int)p5.getY(),(int)p6.getY()};
		xCoord = x;
		yCoord = y;
		shape = new PolygonBrain(xCoord,yCoord,6).getShape();
	}
	public void setScreenSizes(int width, int height){
		super.setScreenSizes(width, height);
		double x1 = screenW/2 - sideLength/2;
		double y1 = screenH/2 - (sideLength*Math.sqrt(3)/2);
		double x2 = screenW/2 - sideLength;
		double y2 = screenH/2;
		double x3 = screenW/2 - sideLength/2;
		double y3 = screenH/2 + (sideLength*Math.sqrt(3)/2);
		double x4 = screenW/2 + sideLength/2;
		double y4 = screenW/2 + sideLength/2;
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
		int[] y = {(int)p1.getY(),(int)p3.getY(),(int)p3.getY(),(int)p4.getY(),(int)p5.getY(),(int)p6.getY()};
		xCoord = x;
		yCoord = y;
		shape = new PolygonBrain(xCoord,yCoord,6).getShape();
	}
}
