package mjkuan.pathfinding.grid;

public abstract class ImpassableEntity extends Actor {
	protected ImpassableEntity(GridPosition position)
	{
		super(position);
	}

	@Override
	public final boolean isPassable()
	{
		return false;
	}
}
