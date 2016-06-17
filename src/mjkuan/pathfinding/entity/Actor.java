package mjkuan.pathfinding.entity;

import mjkuan.pathfinding.grid.GridPosition;

/**
 * The base class for all entities that can interact with other entities on the
 * grid.
 * 
 * @author Martino Kuan
 *
 */
public abstract class Actor extends Entity {
	/**
	 * Initializes a new instance of the {@link Actor} class.
	 * 
	 * @param position the starting position of this entity
	 */
	protected Actor(GridPosition position)
	{
		super(position);
	}

	public abstract void update();
}
