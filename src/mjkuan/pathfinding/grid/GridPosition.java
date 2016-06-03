package mjkuan.pathfinding.grid;

public class GridPosition {
	private int positionX;
	private int positionY;

	@SuppressWarnings("unused")
	private GridPosition()
	{
		// Empty on purpose.
	}

	public GridPosition(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public GridPosition move(GridDirections direction)
	{
		switch (direction) {
			case Down:
				positionY++;
				break;

			case Left:
				positionX--;
				break;

			case LeftDown:
				positionX--;
				positionY++;
				break;

			case LeftUp:
				positionX--;
				positionY--;
				break;

			case Right:
				positionX++;
				break;

			case RightDown:
				positionX++;
				positionY++;
				break;

			case RightUp:
				positionX++;
				positionY--;
				break;
				
			case Up:
				positionY--;
				break;

			default:
				throw new IllegalArgumentException("That should not be possible.");
		}

		return this;
	}

	public int getX()
	{
		return this.positionX;
	}

	public int getY()
	{
		return this.positionY;
	}
}
