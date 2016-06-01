package mjkuan.pathfinding.grid;

import mjkuan.pathfinding.ContentLoader;
import mjkuan.pathfinding.Global;

public class ImpassableTile extends Tile {
	public ImpassableTile(int tileID, GridPosition position)
	{
		super(tileID, position);
	}

	@Override
	public void show()
	{
		switch (getTileID()) {
			default:
				Global.callP5().image(ContentLoader.getSprite("ImpassableTile"), getPosition().getX() * Tile.TILE_WIDTH,
						getPosition().getY() * Tile.TILE_HEIGHT);
				break;
		}
	}

	@Override
	public boolean isPassable()
	{
		return false;
	}
}
