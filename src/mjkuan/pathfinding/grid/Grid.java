package mjkuan.pathfinding.grid;

import java.util.Set;
import java.util.TreeSet;

public class Grid {
	private MouseOverEffect mouseOverEffect;
	private Set<Entity> entities;
	private Tile[] tiles;
	private int width, height, size;

	public Grid(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.size = width * height;

		this.entities = new TreeSet<>();
		this.tiles = new Tile[this.size];
		
		this.mouseOverEffect = new MouseOverEffect();
	}

	public void add(Entity entity)
	{
		entities.add(entity);
	}

	public void show()
	{
		for (Tile tile : tiles) {
			if (tile != null) {
				tile.show();
			}
		}

		for (Entity entity : entities) {
			entity.show();
		}
		
		mouseOverEffect.show();
	}

	public void update()
	{
		for (Entity entity : entities) {
			entity.update();
		}
		
		mouseOverEffect.update();
	}

	public int getHeight()
	{
		return this.height;
	}

	public int getSize()
	{
		return this.size;
	}

	public int getWidth()
	{
		return this.width;
	}
}
