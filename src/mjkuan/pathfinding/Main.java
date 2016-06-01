package mjkuan.pathfinding;

import processing.core.PApplet;

public class Main extends PApplet {
	private FramesCounter framesCounter;
	
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
	}
	
	@Override
	public void draw()
	{
		this.update();
		
		background(0);
		framesCounter.show();
	}
	
	public void update()
	{
		framesCounter.update();
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
