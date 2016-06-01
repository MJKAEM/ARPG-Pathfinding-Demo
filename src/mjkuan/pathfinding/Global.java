package mjkuan.pathfinding;

import processing.core.PApplet;

public class Global {
	public static final int FRAMES_STANDARD = 60;
	private static PApplet p5 = null;

	public static void initialize(PApplet p5)
	{
		if (Global.p5 != null) {
			return;
		}

		Global.p5 = p5;
	}
	
	public static double scaleSecondsToStandard(double seconds)
	{
		return FRAMES_STANDARD * seconds;
	}
	
	public static double scaleValueToFrames(double value)
	{
		return FRAMES_STANDARD * value / p5.frameRate;
	}
	
	public static PApplet callP5() {
		return p5;
	}
}
