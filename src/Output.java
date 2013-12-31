import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

//class output is a runner class for MyGraphics 
public class Output {
	//private variables for height and width of myGraphics
	private static int HEIGHT = 600, WIDTH = 600;
	//declarations of frame and instances 
	public static void makeFrame(){
		//new JFrame
		JFrame f = new JFrame("Rotating Line");
		MyGraphics a = new MyGraphics();
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		f.getContentPane().add(BorderLayout.CENTER, a);
		f.add(BorderLayout.SOUTH, a.getButtonPanel());
		a.init();
		//packed the frame will always be at least 538 pixels wide because of the jPanel
		f.pack();
		f.setVisible(true);
		
	}
	
	public static void main(String[] args){
		Output.makeFrame();
	}
}
