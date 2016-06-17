package mjkuan.pathfinding.grid;

import java.util.List;

import mjkuan.pathfinding.entity.Actor;

public abstract class PathfindingMethod {
	private GridPosition currentPosition;
	private List<GridPosition> pathList;
	private GridPosition targetPosition;
	private Actor targetEntity;

	public PathfindingMethod(GridPosition currentPosition)
	{
		this.currentPosition = currentPosition;
	}
	
	public boolean isPathComplete()
	{
		return pathList == null || pathList.isEmpty();
	}
	
	public GridPosition peekNextPathPosition()
	{
		return pathList.isEmpty() ? null : pathList.get(0);
	}
	
	public GridPosition popNextPathPosition()
	{
		return pathList.isEmpty() ? null : pathList.remove(0);
	}

	public void setNewTargetEntity(Actor targetEntity)
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
