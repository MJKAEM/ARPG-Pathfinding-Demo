package mjkuan.pathfinding.grid;

public abstract class Entity {
	private GridPosition position;

	protected Entity(GridPosition position)
	{
		this.position = position;
	}

	public abstract void show();

	public abstract void update();

	public abstract boolean isPassable();

	public GridPosition getPosition()
	{
		return this.position;
	}
}
