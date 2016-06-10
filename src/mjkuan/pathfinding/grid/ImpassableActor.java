package mjkuan.pathfinding.grid;

public abstract class ImpassableActor extends Actor {
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
