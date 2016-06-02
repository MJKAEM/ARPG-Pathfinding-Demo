package mjkuan.pathfinding.grid;

import mjkuan.pathfinding.ContentLoader;
import mjkuan.pathfinding.Global;

public class Player extends ImpassableEntity {
	protected Player(GridPosition position)
	{
		super(position);
	}

	@Override
	public void show()
	{
		Global.callP5().image(ContentLoader.getSprite("Player"), getPosition().getX() * 64, getPosition().getY() * 64);
	}

	@Override
	public void update()
	{
		//
	}
}
