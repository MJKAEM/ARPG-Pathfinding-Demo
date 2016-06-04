package mjkuan.pathfinding.grid;

public enum GridDirections {
	EAST, NORTH, NORTHEAST, NORTHWEST, SOUTH, SOUTHEAST, SOUTHWEST, WEST;

	public static GridDirections combineDirections(GridDirections firstDirection, GridDirections secondDirection)
	{
		if (firstDirection == null) {
			return secondDirection;
		}

		if (secondDirection == null) {
			return firstDirection;
		}

		switch (firstDirection) {
			case EAST:
				switch (secondDirection) {
					case NORTH:
						return NORTHEAST;

					case NORTHWEST:
						return NORTH;

					case SOUTHWEST:
						return SOUTH;

					case SOUTH:
						return SOUTHEAST;

					case WEST:
						return null;

					default:
						return secondDirection;
				}

			case NORTH:
				switch (secondDirection) {
					case EAST:
						return NORTHEAST;

					case SOUTH:
						return null;

					case SOUTHWEST:
						return WEST;

					case SOUTHEAST:
						return EAST;

					case WEST:
						return NORTHWEST;

					default:
						return secondDirection;
				}

			case SOUTH:
				switch (secondDirection) {
					case EAST:
						return SOUTHEAST;

					case NORTH:
						return null;

					case NORTHWEST:
						return WEST;

					case NORTHEAST:
						return EAST;

					case WEST:
						return SOUTHWEST;

					default:
						return secondDirection;
				}

			case WEST:
				switch (secondDirection) {
					case NORTH:
						return NORTHWEST;

					case NORTHEAST:
						return NORTH;

					case SOUTHEAST:
						return SOUTH;

					case SOUTH:
						return SOUTHWEST;

					case EAST:
						return null;

					default:
						return secondDirection;
				}

			default:
				throw new IllegalArgumentException("Not possible");
		}
	}
}
