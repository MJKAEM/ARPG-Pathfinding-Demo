package mjkuan.pathfinding.grid;

/**
 * The base class for all actors that can interact with other entities on the
 * grid, including blocking other actors from moving into the same spot as them.
 * 
 * @author Martino Kuan
 *
 */
public abstract class PassableEntity extends Actor {
	/**
	 * Initializes a new instance of the {@link PassableEntity} class.
	 * 
	 * @param position
	 *            the starting position of this entity
	 */
	protected PassableEntity(GridPosition position)
	{
		super(position);
	}

	@Override
	public final boolean isPassable()
	{
		return true;
	}
}
