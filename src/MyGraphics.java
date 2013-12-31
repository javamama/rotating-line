
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Class MyGraphics extends JComponent in order to be added to a frame as well as 
 * having its own paintComponent method. Since JComponent is part of the Swing 
 * family, the paintComponent method also double buffers automatically, which smoothes 
 * the painting of the lines. There are class variables for all of the buttons, as well as
 * the timer. There is an inner class that implements all of the listeners needed for the
 * buttons etc using action commands. The paint component method prints the class 
 * variable brain's shape, which can be changed with the shape button. 
 */

public class MyGraphics extends JComponent{
	private static final long serialVersionUID = 1L;
	private Brain brain;
	private int shapeCount = 1;
	private boolean isMoving = false;
	public MyGraphics(Brain brain){
		this.brain = brain;
	}
	//default and only constructor starts with a line using the height and width of this
	public MyGraphics(){
		this.brain = new LineBrain(this.getWidth(), this.getHeight());
	}
	/*
	 * class everything listener is an inner class that implements all of the necessary 
	 * listeners for the actions that occur during this program
	 */
	private class EverythingListener implements ActionListener, ChangeListener, ComponentListener{
		private MyGraphics g;
		
		public EverythingListener(MyGraphics g){
			this.g = g;
		}
		//action performed for buttons
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Start")){
				if(isMoving == false){
					startButton.setText("Stop");
					timer.start();
					g.repaint();
					isMoving = true;
				}
				else{
					startButton.setText("Start");
					timer.stop();
					g.repaint();
					isMoving = false;
				}
			}
			if(e.getActionCommand().equals("Timer")){
				brain.calcPoint();
				g.repaint();
			}
			if(e.getActionCommand().equals("Direction")){
				brain.toggleDirection();
			}
			//next shape
			if(e.getActionCommand().equals("Shape")){
				
				if(shapeCount == 1){
					startButton.setText("Start");
					timer.stop();
					isMoving = false;
					brain = new RectangleBrain(200, 200, g.getWidth(), g.getHeight());
					shapeCount++;
				}
				else if(shapeCount == 0){
					startButton.setText("Start");
					timer.stop();
					isMoving = false;
					brain = new LineBrain(g.getWidth(), g.getHeight());
					shapeCount++;
				}
				else if(shapeCount == 2){
					startButton.setText("Start");
					timer.stop();
					isMoving = false;
					brain = new TriangleBrain(g.getWidth(), g.getHeight(), 200);
					shapeCount++;
				}
				else if(shapeCount == 3){
					startButton.setText("Start");
					timer.stop();
					isMoving = false;
					brain = new HexagonBrain(g.getWidth(), g.getHeight(), 200);
					shapeCount=0;
				}
				brain.setScreenSizes(g.getWidth(), g.getHeight());
				g.repaint();
			}
		}
		//change listener for the slider 
		@Override
		public void stateChanged(ChangeEvent e) {
			int frequency = slider.getValue();
			timer.setDelay(frequency);
		}
		//component listeners for the window
		@Override
		public void componentHidden(ComponentEvent arg0) {g.repaint();}
		@Override
		public void componentMoved(ComponentEvent arg0) {}
		//resized
		@Override
		public void componentResized(ComponentEvent e) {
			startButton.setText("Start");
			timer.stop();
			isMoving = false;
			brain.setScreenSizes(g.getWidth(), g.getHeight());
			g.repaint();
		}
		@Override
		public void componentShown(ComponentEvent arg0) {g.repaint();}
		
	}
	//declarations of all of the pieces needed 
	private ActionListener everythingListener = new EverythingListener(this);
	private Timer timer = new Timer(1 ,everythingListener);
	private JButton startButton = new JButton("Start");
	private JButton directionButton = new JButton("Direction");
	private JButton shapeButton = new JButton("Shape");
	private JPanel buttonPanel = new JPanel();
	private JSlider slider = new JSlider(SwingConstants.HORIZONTAL);
	
	//init sets all of the parts to their correct places etc 
	public void init(){
		shapeButton.addActionListener(everythingListener);
		shapeButton.setActionCommand("Shape");
		
		startButton.addActionListener(everythingListener);
		startButton.setActionCommand("Start");
		
		directionButton.addActionListener(everythingListener);
		directionButton.setActionCommand("Direction");
		
		timer.addActionListener(everythingListener);
		timer.setActionCommand("Timer");
		
		slider.addChangeListener((ChangeListener) everythingListener);
		slider.setMinimum(1);
		slider.setMaximum(100);
		
		buttonPanel.add(shapeButton);
		buttonPanel.add(directionButton);
		buttonPanel.add(startButton);
		buttonPanel.add(new JLabel("Fast"));
		buttonPanel.add(slider);
		buttonPanel.add(new JLabel("Slow"));
		
		this.addComponentListener((ComponentListener) everythingListener);
	}
	
	//getter method for the button panel
	public JPanel getButtonPanel(){return buttonPanel;}
	
	//paint component paints the shape at its proper position 
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.fill(brain.getShape());
		g2.draw(brain.getShape());
	}	
}
