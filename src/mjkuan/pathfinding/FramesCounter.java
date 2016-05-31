package mjkuan.pathfinding;

import processing.core.PApplet;

public class FramesCounter {
	public static final FramesCounterAlignment DEFAULT_ALIGNMENT = FramesCounterAlignment.bottomRight;
	public static final double DEFAULT_MAX_COUNT = Global.scaleSecondsToStandard(0.03125 /*0.015625*/);
	public static final float DEFAULT_TEXT_SIZE = 12;

	private PApplet p5;
	private FramesCounterAlignment alignment;
	private boolean enabled;
	private int currentFrameRate;
	private double maxCount;
	private double currentCount;
	private float textSize;

	public FramesCounter(PApplet p5)
	{
		this(p5, DEFAULT_ALIGNMENT, DEFAULT_MAX_COUNT, DEFAULT_TEXT_SIZE);
	}

	public FramesCounter(PApplet p5, FramesCounterAlignment alignment, double maxCount, float textSize)
	{
		this.p5 = p5;
		this.alignment = alignment;
		this.maxCount = maxCount;
		this.textSize = textSize;
	}

	public void show()
	{
		if (enabled) {
			p5.textSize(textSize);

			float positionX = 0;
			float positionY = 0;

			switch (alignment) {
				case topLeft:
					break;

				case topRight:
					positionX = p5.width - p5.textWidth(String.valueOf(currentFrameRate) + " ");
					break;

				case bottomLeft:
					positionY = p5.height - textSize;
					break;

				case bottomRight:
					positionX = p5.width - p5.textWidth(String.valueOf(currentFrameRate) + " ");
					positionY = p5.height - textSize;
					break;

				default:
					throw new RuntimeException("This is impossible.");
			}

			p5.text(currentFrameRate, positionX, positionY);
		}
	}

	public void update()
	{
		if (enabled) {
			if (currentCount >= maxCount) {
				currentFrameRate = (int) p5.frameRate;
				currentCount = 0;
			}
			else {
				currentCount += Global.scaleValueToFrames(1.0);
			}
		}
	}

	public void toggle()
	{
		if (p5.key == '`') {
			enabled = !enabled;
		}
	}
}
