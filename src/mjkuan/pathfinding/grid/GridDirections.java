package mjkuan.pathfinding.grid;

import java.util.Objects;

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

	public static boolean isOppositeDirections(GridDirections firstDirection, GridDirections secondDirection)
	{
		Objects.requireNonNull(firstDirection);
		Objects.requireNonNull(secondDirection);

		if (firstDirection == secondDirection) {
			return false;
		}

		switch (firstDirection) {
			case EAST:
				return !(secondDirection == GridDirections.NORTHEAST || secondDirection == GridDirections.SOUTHEAST);

			case NORTH:
				return !(secondDirection == GridDirections.NORTHEAST || secondDirection == GridDirections.NORTHWEST);

			case NORTHEAST:
				return secondDirection == GridDirections.SOUTHWEST || secondDirection == GridDirections.SOUTH
						|| secondDirection == GridDirections.WEST;

			case NORTHWEST:
				return secondDirection == GridDirections.EAST || secondDirection == GridDirections.SOUTH
						|| secondDirection == GridDirections.SOUTHEAST;

			case SOUTH:
				return !(secondDirection == GridDirections.SOUTHEAST || secondDirection == GridDirections.SOUTHWEST);

			case SOUTHEAST:
				return secondDirection == GridDirections.NORTH || secondDirection == GridDirections.NORTHWEST
						|| secondDirection == GridDirections.WEST;

			case SOUTHWEST:
				return secondDirection == GridDirections.EAST || secondDirection == GridDirections.NORTH
						|| secondDirection == GridDirections.NORTHEAST;

			case WEST:
				return !(secondDirection == GridDirections.NORTHWEST || secondDirection == GridDirections.SOUTHWEST);

			default:
				throw new IllegalArgumentException("Impossible!");
		}
	}
}
