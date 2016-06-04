package mjkuan.pathfinding.grid;

public abstract class Entity implements Comparable<Entity> {
	private GridPosition position;

	protected Entity(GridPosition position)
	{
		this.position = position;
	}

	public abstract void show();

	public abstract void update();

	public abstract boolean isPassable();
	
	public int compareTo(Entity o)
	{
		return this.getPosition().getY() - o.getPosition().getY() != 0
				? this.getPosition().getY() - o.getPosition().getY()
				: this.getPosition().getX() - o.getPosition().getX();
	}

	public GridPosition getPosition()
	{
		return this.position;
	}
}
