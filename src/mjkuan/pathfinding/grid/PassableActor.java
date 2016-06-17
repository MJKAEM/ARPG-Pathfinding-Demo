package mjkuan.pathfinding.grid;

/**
 * The base class for all actors that can interact with other entities on the
 * grid, but cannot block other actors from moving into the same spot as them.
 * 
 * @author Martino Kuan
 *
 */
public abstract class PassableActor extends Actor {
	/**
	 * Initializes a new instance of the {@link PassableActor} class.
	 * 
	 * @param position
	 *            the starting position of this entity
	 */
	protected PassableActor(GridPosition position)
	{
		super(position);
	}

	@Override
	public final boolean isPassable()
	{
		return true;
	}
}
