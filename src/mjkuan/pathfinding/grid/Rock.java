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
		Global.callP5().image(ContentLoader.getSprite("Rock"), getPosition().getX() * 64, getPosition().getY() * 64);
	}

	@Override
	public void update()
	{
		// Do absolutely nothing.
	}
}
