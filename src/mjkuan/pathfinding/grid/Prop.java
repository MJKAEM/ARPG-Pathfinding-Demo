package mjkuan.pathfinding.grid;

import mjkuan.pathfinding.ContentLoader;
import mjkuan.pathfinding.Global;

/**
 * An {@link Entity} that is capable of blocking other entities and is displayed
 * purely for aesthetic purposes. Unlike {@link Actor}, a Prop does not update,
 * and can be represented without too much variation in input.
 * 
 * @author Martino Kuan
 *
 */
public class Prop extends Entity {
	private PropNames propName;

	/**
	 * Initializes a new instance of the {@link Prop} class.
	 * 
	 * @param position
	 *            the starting position of this entity
	 * @param propName
	 *            the name of the prop to be represented
	 */
	public Prop(GridPosition position, PropNames propName)
	{
		super(position);
		this.propName = propName;
	}

	@Override
	public void show()
	{
		switch (propName) {
			case Rock:
				Global.callP5().image(ContentLoader.getSprite("Rock"), getPosition().getX() * Tile.TILE_WIDTH,
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
