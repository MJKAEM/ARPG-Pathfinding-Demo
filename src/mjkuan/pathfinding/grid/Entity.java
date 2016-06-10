package mjkuan.pathfinding.grid;

/**
 * The base class for renderable and interactable objects on the grid.
 * 
 * @author Martino Kuan
 *
 */
public abstract class Entity implements Comparable<Entity> {
	private GridPosition position;

	/**
	 * Initializes a new instance of the {@link Entity} class.
	 * 
	 * @param position
	 *            the starting position of this entity
	 */
	protected Entity(GridPosition position)
	{
		this.position = position;
	}

	/**
	 * Renders the entity on the current grid.
	 */
	public abstract void show();

	/**
	 * Determines whether this entity can freely pass through other entities and
	 * vice versa.
	 * 
	 * @return {@code true} if the entity can pass through other entities and
	 *         vice versa
	 */
	public abstract boolean isPassable();

	/**
	 * Returns the current position of this {@link Entity}.
	 * 
	 * @return the current position of this entity
	 */
	public GridPosition getPosition()
	{
		return this.position;
	}

	public int compareTo(Entity o)
	{
		return this.getPosition().getY() - o.getPosition().getY() != 0
				? this.getPosition().getY() - o.getPosition().getY()
				: this.getPosition().getX() - o.getPosition().getX();
	}
}
