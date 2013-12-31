import java.awt.Polygon;
/*
 * PolygonBrain is a class that is a Brain but deals with 
 * shapes that are not predefined in Java like Rectangles and
 * Lines. 
 */
public class PolygonBrain extends Brain {
	//default for when extended 
	public PolygonBrain(){
	}
	//makes a new polygon 
	public PolygonBrain(int[] xCoords, int[] yCoords, int points){
		shape = new Polygon(xCoords, yCoords, points);
	}
	

}
