package mjkuan.pathfinding.grid;

import java.util.LinkedList;
import java.util.List;

public class StraightPathfindingMethod extends PathfindingMethod {
	
	public StraightPathfindingMethod(GridPosition currentPath)
	{
		super(currentPath);
	}
	
	@Override
	protected List<GridPosition> generatePath(GridPosition targetPosition)
	{
		List<GridPosition> pathList = new LinkedList<>();
		pathList.add(getCurrentPosition());
		
		GridPosition currentPosition = getCurrentPosition();
		while(currentPosition != targetPosition) {
			GridDirections facingDirection = currentPosition.getDirectionFrom(targetPosition);
			GridPosition nextPosition = currentPosition.getAdjacentPosition(facingDirection);
			pathList.add(nextPosition);
			currentPosition = nextPosition;
		}
		
		return null;
	}
}
