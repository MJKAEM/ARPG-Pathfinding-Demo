package mjkuan.pathfinding;

import processing.core.PApplet;

public class Global {
	public static final int FRAMES_STANDARD = 60;
	public static final boolean DEBUG_PROTECTION = true;

	private static PApplet p5 = null;

	/**
	 * Initializes the {@link Global} class for usage.
	 * 
	 * @param p5
	 *            the main Processing PApplet to be called by other methods
	 */
	public static void initialize(PApplet p5)
	{
		if (Global.p5 != null) {
			return;
		}

		Global.p5 = p5;
	}

	/**
	 * Calls the main Processing applet, which allows for access to Processing
	 * methods.
	 * 
	 * @return the main Processing applet
	 */
	public static PApplet callP5()
	{
		return p5;
	}

	/**
	 * Scales the number of seconds to the number of frames that would have
	 * advanced.
	 * 
	 * @param seconds
	 *            the number of seconds that would pass
	 * @return the number of frames that would have advanced
	 */
	public static double scaleSecondsToStandard(double seconds)
	{
		return FRAMES_STANDARD * seconds;
	}

	/**
	 * Scales the value to the current frame rate, to allow frame rate
	 * independent updating.
	 * 
	 * @param value
	 *            the value to scale to the current frame rate
	 * @return a value scaled to the current frame rate
	 */
	public static double scaleValueToFrames(double value)
	{
		return FRAMES_STANDARD * value / p5.frameRate;
	}
}
