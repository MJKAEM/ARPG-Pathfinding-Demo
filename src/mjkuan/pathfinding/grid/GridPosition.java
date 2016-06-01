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
	
	public int moveDown()
	{
		return ++positionY;
	}
	
	public int moveLeft()
	{
		return --positionX;
	}
	
	public int moveRight()
	{
		return ++positionX;
	}
	
	public int moveUp()
	{
		return --positionY;
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
