package mjkuan.pathfinding.grid;

public abstract class PassableEntity extends Entity{
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
