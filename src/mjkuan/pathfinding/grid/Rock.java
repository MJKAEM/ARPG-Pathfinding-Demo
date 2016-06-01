package mjkuan.pathfinding.grid;

import mjkuan.pathfinding.ContentLoader;
import mjkuan.pathfinding.Global;

public class Rock extends ImpassableEntity {

	public Rock(GridPosition position)
	{
		super(position);
	}

	@Override
	public void show()
	{
		Global.callP5().image(ContentLoader.getSprite("Rock"), getPosition().getX() * 32, getPosition().getY() * 32);
	}

	@Override
	public void update()
	{
		// Do absolutely nothing.
	}
}
