package mjkuan.pathfinding.grid;

import mjkuan.pathfinding.ContentLoader;
import mjkuan.pathfinding.Global;

public class Player extends ImpassableEntity implements Movable {
	private PathfindingMethod pathfindingMethod;
	private GridPosition nextPosition;

	protected Player(GridPosition position)
	{
		super(position);
		this.pathfindingMethod = new StraightPathfindingMethod(position);
	}

	@Override
	public void show()
	{
		Global.callP5().image(ContentLoader.getSprite("Player"), getPosition().getX() * 64, getPosition().getY() * 64);
	}

	@Override
	public void update()
	{
		move();
	}

	@Override
	public void move()
	{
		if (!pathfindingMethod.isPathComplete()) {
			nextPosition = pathfindingMethod.popNextPathPosition();
			GridDirections directionToGo = getPosition().getDirectionFrom(nextPosition);
			getPosition().move(directionToGo);
			nextPosition = null;
		}
	}

	public void selectTargetOnMouse()
	{
		int x = (int) (Global.callP5().mouseX / Tile.TILE_WIDTH);
		int y = (int) (Global.callP5().mouseY / Tile.TILE_HEIGHT);
		pathfindingMethod.setNewTargetPosition(new GridPosition(x, y));
	}
}
