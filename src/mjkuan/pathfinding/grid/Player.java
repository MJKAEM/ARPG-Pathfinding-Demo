package mjkuan.pathfinding.grid;

import mjkuan.pathfinding.ContentLoader;
import mjkuan.pathfinding.Global;

public class Player extends ImpassableEntity implements Movable {
	private int FRAMES_BEFORE_MOVEMENT = (int) Global.scaleSecondsToStandard(0.5);

	private PathfindingMethod pathfindingMethod;
	private GridPosition nextPosition;
	private float currentMoveFrames;

	public Player(GridPosition position)
	{
		super(position);
		this.pathfindingMethod = new StraightPathfindingMethod(position);
	}

	@Override
	public void show()
	{
		int translateX = 0;
		int translateY = 0;
		if (nextPosition != null) {
			GridDirections directionToGo = getPosition().getDirectionTo(nextPosition);
			float translateValue = currentMoveFrames / FRAMES_BEFORE_MOVEMENT;
			switch (directionToGo) {
				case EAST:
					translateX += Tile.TILE_WIDTH * translateValue;
					break;

				case NORTH:
					translateY -= Tile.TILE_HEIGHT * translateValue;
					break;

				case NORTHEAST:
					translateX += Tile.TILE_WIDTH * translateValue;
					translateY -= Tile.TILE_HEIGHT * translateValue;
					break;

				case NORTHWEST:
					translateX -= Tile.TILE_WIDTH * translateValue;
					translateY -= Tile.TILE_HEIGHT * translateValue;
					break;

				case SOUTH:
					translateY += Tile.TILE_HEIGHT * translateValue;
					break;

				case SOUTHEAST:
					translateX += Tile.TILE_WIDTH * translateValue;
					translateY += Tile.TILE_HEIGHT * translateValue;
					break;

				case SOUTHWEST:
					translateX -= Tile.TILE_WIDTH * translateValue;
					translateY += Tile.TILE_HEIGHT * translateValue;
					break;
					
				case WEST:
					translateX -= Tile.TILE_WIDTH * translateValue;
					break;

				default:
					break;
			}
		}
		Global.callP5().image(ContentLoader.getSprite("Player"), (getPosition().getX() * Tile.TILE_WIDTH) + translateX,
				(getPosition().getY() * Tile.TILE_HEIGHT) + translateY);
	}

	@Override
	public void update()
	{
		move();
	}

	@Override
	public void move()
	{
		if (!pathfindingMethod.isPathComplete() || nextPosition != null) {
			if (!pathfindingMethod.isPathComplete() && nextPosition == null) {
				nextPosition = pathfindingMethod.peekNextPathPosition();
			}
			else {
				if (currentMoveFrames < FRAMES_BEFORE_MOVEMENT) {
					currentMoveFrames += Global.scaleValueToFrames(1);
				}
				else {
					GridDirections directionToGo = getPosition().getDirectionTo(nextPosition);
					getPosition().move(directionToGo);
					nextPosition = null;
					currentMoveFrames = 0;
					
					if (pathfindingMethod.peekNextPathPosition() != null && getPosition().equals(pathfindingMethod.peekNextPathPosition())) {
						pathfindingMethod.popNextPathPosition();
					}
				}
			}
		}
	}

	public void selectTargetOnMouse()
	{
		int x = (int) (Global.callP5().mouseX / Tile.TILE_WIDTH);
		int y = (int) (Global.callP5().mouseY / Tile.TILE_HEIGHT);
		GridPosition position = new GridPosition(x, y);
		pathfindingMethod.setNewTargetPosition(position);

		if (nextPosition != null) {
			if (getPosition().equals(position)) {
				GridPosition tempPosition = new GridPosition(getPosition().getX(), getPosition().getY());
				getPosition().move(getPosition().getDirectionTo(nextPosition));
				nextPosition = tempPosition;
				currentMoveFrames = FRAMES_BEFORE_MOVEMENT - currentMoveFrames;
				return;
			}

			GridDirections meToOldNextDirection = getPosition().getDirectionTo(nextPosition);
			GridDirections meToNewNextDirection = getPosition()
					.getDirectionTo(pathfindingMethod.peekNextPathPosition());

			if (GridDirections.isOppositeDirections(meToOldNextDirection, meToNewNextDirection)) {
				nextPosition = new GridPosition(getPosition().getX(), getPosition().getY());
				getPosition().move(meToOldNextDirection);
				currentMoveFrames = FRAMES_BEFORE_MOVEMENT - currentMoveFrames;
			}
			else /*if (meToOldNextDirection == meToNewNextDirection)*/ {
				pathfindingMethod.popNextPathPosition();
			}
		}
		System.out.println(position);
	}
}
