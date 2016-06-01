package mjkuan.pathfinding;

import processing.core.PApplet;

public class FramesCounter {
	public static final FramesCounterAlignment DEFAULT_ALIGNMENT = FramesCounterAlignment.bottomRight;
	public static final double DEFAULT_MAX_COUNT = Global.scaleSecondsToStandard(0.03125 /*0.015625*/);
	public static final float DEFAULT_TEXT_SIZE = 12;
	
	private FramesCounterAlignment alignment;
	private boolean enabled;
	private int currentFrameRate;
	private double maxCount;
	private double currentCount;
	private float textSize;

	public FramesCounter()
	{
		this(DEFAULT_ALIGNMENT, DEFAULT_MAX_COUNT, DEFAULT_TEXT_SIZE);
	}

	public FramesCounter(FramesCounterAlignment alignment, double maxCount, float textSize)
	{
		this.alignment = alignment;
		this.maxCount = maxCount;
		this.textSize = textSize;
	}

	public void show()
	{
		if (enabled) {
			Global.callP5().textSize(textSize);

			float positionX = Global.callP5().textWidth(' ');
			float positionY = 12;

			switch (alignment) {
				case topLeft:
					break;

				case topRight:
					positionX = Global.callP5().width - Global.callP5().textWidth(String.valueOf(currentFrameRate) + " ");
					break;

				case bottomLeft:
					positionY = Global.callP5().height - (textSize / 2);
					break;

				case bottomRight:
					positionX = Global.callP5().width - Global.callP5().textWidth(String.valueOf(currentFrameRate) + " ");
					positionY = Global.callP5().height - (textSize / 2);
					break;

				default:
					throw new RuntimeException("This is impossible.");
			}

			Global.callP5().text(currentFrameRate, positionX, positionY);
		}
	}

	public void update()
	{
		if (enabled) {
			if (currentCount >= maxCount) {
				currentFrameRate = (int) Global.callP5().frameRate;
				currentCount = 0;
			}
			else {
				currentCount += Global.scaleValueToFrames(1.0);
			}
		}
	}

	public void toggle()
	{
		if (Global.callP5().key == '`') {
			enabled = !enabled;
		}
	}
}
