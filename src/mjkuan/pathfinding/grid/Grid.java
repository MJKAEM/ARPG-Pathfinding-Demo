package mjkuan.pathfinding.grid;

import java.util.Set;
import java.util.TreeSet;

public class Grid {
	private Set<Entity> entities;
	private Tile[] tiles;
	private int sizeX, sizeY, size;

	public Grid(int sizeX, int sizeY)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.size = sizeX * sizeY;

		this.entities = new TreeSet<>();
		this.tiles = new Tile[this.size];
	}

	public void add(Entity entity, GridPosition position)
	{
		entities.add(entity);
	}

	public void show()
	{
		for (Entity entity : entities) {
			entity.show();
		}
	}

	public void update()
	{
		for (Entity entity : entities) {
			entity.update();
		}
	}
}
