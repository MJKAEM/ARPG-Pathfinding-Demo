package mjkuan.pathfinding;

import mjkuan.pathfinding.grid.TestGrid;
import processing.core.PApplet;

public class Main extends PApplet {
	private FramesCounter framesCounter;
	private TestGrid testGrid;
	
	@Override
	public void settings()
	{
		size(640, 480);
	}
	
	@Override
	public void setup()
	{
		frameRate((float) Math.pow(2, 8));
		Global.initialize(this);
		ContentLoader.loadContent();
		framesCounter = new FramesCounter(FramesCounterAlignment.bottomRight, 0, 12);
		testGrid = new TestGrid();
	}
	
	@Override
	public void draw()
	{
		this.update();
		
		background(0);
		framesCounter.show();
		testGrid.show();
	}
	
	public void update()
	{
		framesCounter.update();
		testGrid.update();
	}
	
	@Override
	public void mouseReleased()
	{
		testGrid.mouseReleased();
	}
	
	@Override
	public void keyReleased()
	{
		framesCounter.toggle();
	}
	
	public static void main(String[] argv)
	{
		PApplet.main(Main.class.getName());
	}
}
