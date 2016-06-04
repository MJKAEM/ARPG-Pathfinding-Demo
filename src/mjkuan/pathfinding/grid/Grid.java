package mjkuan.pathfinding.grid;

import java.util.Set;
import java.util.TreeSet;

public class Grid {
	private MouseOverEffect mouseOverEffect;
	private Player player;
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

	public boolean add(Entity entity)
	{
		boolean added = isValid(entity.getPosition()) && !isOccupied(entity.getPosition()) ? entities.add(entity)
				: false;
		
		if (added && entity instanceof Player) {
			player = (Player) entity;
		}
		return added;
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
	
	public void mouseReleased()
	{
		player.selectTargetOnMouse();
	}

	public boolean isOccupied(GridPosition position)
	{
		return false;
	}

	public boolean isValid(GridPosition position)
	{
		if (position.getX() < 0 || position.getX() >= width) {
			return false;
		}

		if (position.getY() < 0 || position.getY() >= height) {
			return false;
		}

		return true;
	}

	public GridPosition getMouseClickPosition()
	{
		return this.mouseOverEffect.getPosition();
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
