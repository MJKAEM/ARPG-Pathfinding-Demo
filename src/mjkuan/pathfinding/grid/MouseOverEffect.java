package mjkuan.pathfinding.grid;

import mjkuan.pathfinding.Global;

public class MouseOverEffect {
	static boolean visible = true;
	private GridPosition position;

	public MouseOverEffect()
	{
		reset();
	}

	public void show()
	{
		if (visible) {
			Global.callP5().noFill();
			Global.callP5().stroke(128, 128, 255);
			Global.callP5().rect(position.getX() * Tile.TILE_WIDTH, position.getY() * Tile.TILE_HEIGHT, Tile.TILE_WIDTH,
					Tile.TILE_HEIGHT);
		}
	}

	public void update()
	{
		if (Global.callP5().mouseX < position.getX() * Tile.TILE_WIDTH) {
			position.move(GridDirections.WEST);
		}
		else if (Global.callP5().mouseX > (position.getX() + 1) * Tile.TILE_WIDTH) {
			position.move(GridDirections.EAST);
		}

		if (Global.callP5().mouseY < position.getY() * Tile.TILE_HEIGHT) {
			position.move(GridDirections.NORTH);
		}
		else if (Global.callP5().mouseY > (position.getY() + 1) * Tile.TILE_HEIGHT) {
			position.move(GridDirections.SOUTH);
		}
	}

	public void reset()
	{
		int x = (int) (Global.callP5().mouseX / Tile.TILE_WIDTH);
		int y = (int) (Global.callP5().mouseY / Tile.TILE_HEIGHT);
		position = new GridPosition(x, y);
	}

	public GridPosition getPosition()
	{
		return this.position;
	}
}
