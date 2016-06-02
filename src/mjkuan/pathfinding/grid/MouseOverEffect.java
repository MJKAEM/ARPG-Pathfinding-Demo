package mjkuan.pathfinding.grid;

import mjkuan.pathfinding.Global;

public class MouseOverEffect {
	private static boolean visible = false;
	private GridPosition position;
	
	public MouseOverEffect()
	{
		reset();
	}
	
	public static void toggleVisibility()
	{
		visible = !visible;
	}
	
	public static boolean isVisible()
	{
		return visible;
	}
	
	public void show()
	{
		Global.callP5().noFill();
		Global.callP5().stroke(128, 128, 255);
		Global.callP5().rect(position.getX() * Tile.TILE_WIDTH, position.getY() * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
	}
	
	public void update()
	{
		if (Global.callP5().mouseX < position.getX() * Tile.TILE_WIDTH) {
			position.moveLeft();
		}
		else if (Global.callP5().mouseX > (position.getX() + 1) * Tile.TILE_WIDTH) {
			position.moveRight();
		}
		
		if (Global.callP5().mouseY < position.getY() * Tile.TILE_HEIGHT) {
			position.moveUp();
		}
		else if (Global.callP5().mouseY > (position.getY() + 1) * Tile.TILE_HEIGHT) {
			position.moveDown();
		}
	}
	
	public void reset()
	{
		int x = (int)(Global.callP5().mouseX / Tile.TILE_WIDTH);
		int y = (int)(Global.callP5().mouseY / Tile.TILE_HEIGHT);
		position = new GridPosition(x, y);
	}
	
	public GridPosition getPosition()
	{
		return this.position;
	}
}
