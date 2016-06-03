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

	/**
	 * Gets the position adjacent to the current position in the specified
	 * direction.
	 * 
	 * @param direction
	 *            The direction to look for the adjacent position
	 * @return
	 */
	public GridPosition getAdjacentPosition(GridDirections direction)
	{
		GridPosition tempPosition = new GridPosition(positionX, positionY);
		tempPosition.move(direction);
		return tempPosition;
	}

	public GridDirections getDirectionFrom(GridPosition targetPosition)
	{
		if (this == targetPosition) {
			return null;
		}

		GridDirections directionX = null;
		GridDirections directionY = null;

		if (positionX < targetPosition.positionX) {
			directionX = GridDirections.EAST;
		}
		else if (positionX > targetPosition.positionX) {
			directionX = GridDirections.WEST;
		}

		assert directionX == null || directionX == GridDirections.EAST || directionX == GridDirections.WEST;

		if (positionY < targetPosition.positionY) {
			directionY = GridDirections.SOUTH;
		}
		else if (positionY > targetPosition.positionY) {
			directionY = GridDirections.NORTH;
		}

		assert directionY == null || directionY == GridDirections.NORTH || directionY == GridDirections.SOUTH;

		return GridDirections.combineDirections(directionX, directionY);
	}

	/**
	 * Moves the position to an adjacent position in the specified direction.
	 * 
	 * @param direction
	 *            The direction to move the current position
	 * @return
	 */
	public GridPosition move(GridDirections direction)
	{
		switch (direction) {
			case SOUTH:
				positionY++;
				break;

			case WEST:
				positionX--;
				break;

			case SOUTHWEST:
				positionX--;
				positionY++;
				break;

			case NORTHWEST:
				positionX--;
				positionY--;
				break;

			case EAST:
				positionX++;
				break;

			case SOUTHEAST:
				positionX++;
				positionY++;
				break;

			case NORTHEAST:
				positionX++;
				positionY--;
				break;

			case NORTH:
				positionY--;
				break;

			default:
				throw new IllegalArgumentException("That should not be possible.");
		}

		return this;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof GridPosition) {
			GridPosition tempPosition = (GridPosition) obj;
			return positionX == tempPosition.positionX && positionY == tempPosition.positionY;
		}

		return false;
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
