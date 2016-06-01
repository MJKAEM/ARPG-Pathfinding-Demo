package mjkuan.pathfinding;

import java.util.HashMap;
import java.util.Map;

import processing.core.PImage;

public class ContentLoader {
	private static final Map<String, PImage> imageMap = new HashMap<>();

	public static void loadContent()
	{
		imageMap.put("Player", Global.callP5().loadImage("data/Player.png"));
		imageMap.put("Rock", Global.callP5().loadImage("data/Rock.png"));
		imageMap.put("Water", Global.callP5().loadImage("data/Water.png"));
		imageMap.put("ImpassableTile", Global.callP5().loadImage("data/ImpassableTile.png"));
		imageMap.put("PassableTile", Global.callP5().loadImage("data/PassableTile.png"));
	}

	public static PImage getSprite(String key)
	{
		return imageMap.get(key);
	}
}
