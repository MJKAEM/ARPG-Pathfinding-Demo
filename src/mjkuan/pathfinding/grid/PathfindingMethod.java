package mjkuan.pathfinding.grid;

import java.util.List;

public abstract class PathfindingMethod {
	private GridPosition currentPosition;
	private List<GridPosition> pathList;
	private GridPosition targetPosition;
	private Entity targetEntity;

	public PathfindingMethod(GridPosition currentPosition)
	{
		this.currentPosition = currentPosition;
	}
	
	public GridPosition peekNextPathPosition()
	{
		return pathList.isEmpty() ? null : pathList.get(0);
	}

	public void setNewTargetEntity(Entity targetEntity)
	{
		this.targetEntity = targetEntity;
		this.targetPosition = null;
		initializePathList();
	}

	public void setNewTargetPosition(GridPosition targetPosition)
	{
		this.targetEntity = null;
		this.targetPosition = targetPosition;
		initializePathList();
	}
	
	protected abstract List<GridPosition> generatePath(GridPosition destination);

	private void initializePathList()
	{
		this.pathList = targetPosition != null ? generatePath(targetPosition)
				: generatePath(targetEntity.getPosition());
	}

	public GridPosition getCurrentPosition()
	{
		return this.currentPosition;
	}
}
