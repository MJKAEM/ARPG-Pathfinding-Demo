package mjkuan.pathfinding.grid;

public abstract class Tile {
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;

	private GridPosition position;
	private int tileID;

	protected Tile(int tileID, GridPosition position)
	{
		this.tileID = tileID;
		this.position = position;
	}

	public abstract void show();

	public abstract boolean isPassable();

	public GridPosition getPosition()
	{
		return this.position;
	}

	public int getTileID()
	{
		return this.tileID;
	}
}
