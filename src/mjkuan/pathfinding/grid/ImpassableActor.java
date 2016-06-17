package mjkuan.pathfinding.grid;

/**
 * The base class for all actors that can interact with other entities on the
 * grid, including blocking other actors from moving into the same spot as them.
 * 
 * @author Martino Kuan
 *
 */
public abstract class ImpassableActor extends Actor {
	/**
	 * Initializes a new instance of the {@link ImpassableActor} class.
	 * 
	 * @param position
	 *            the starting position of this entity
	 */
	protected ImpassableActor(GridPosition position)
	{
		super(position);
	}

	@Override
	public final boolean isPassable()
	{
		return false;
	}
}
