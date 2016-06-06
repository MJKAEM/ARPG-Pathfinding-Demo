package mjkuan.pathfinding.grid;

import java.util.LinkedList;
import java.util.List;

/**
 * An algorithm to find the shortest possible path from one place to another.
 * Ignores tiles and entities that cannot be traversed over. Useful if combined
 * with a much smarter algorithm.
 * 
 * @author Art
 *
 */
public class StraightPathfindingMethod extends PathfindingMethod {

	public StraightPathfindingMethod(GridPosition currentPath)
	{
		super(currentPath);
	}

	@Override
	protected List<GridPosition> generatePath(GridPosition targetPosition)
	{
		List<GridPosition> pathList = new LinkedList<>();

		GridPosition currentPosition = getCurrentPosition();
		while (!currentPosition.equals(targetPosition)) {
			GridDirections facingDirection = currentPosition.getDirectionTo(targetPosition);
			GridPosition nextPosition = currentPosition.getAdjacentPosition(facingDirection);
			pathList.add(nextPosition);
			currentPosition = nextPosition;
		}

		return pathList;
	}
}
