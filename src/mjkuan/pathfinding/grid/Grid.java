package mjkuan.pathfinding.grid;

import java.util.Set;
import java.util.TreeSet;

import mjkuan.pathfinding.entity.Actor;
import mjkuan.pathfinding.entity.Entity;
import mjkuan.pathfinding.entity.Player;

//TODO: Make Grid the data structure and rename this to Level or Map
/**
 * A structure to update and render actions, tiles, and entities to the screen.
 * 
 * @author Martino Kuan
 *
 */
public class Grid {
	private MouseOverEffect mouseOverEffect;
	private Player player;
	private Set<Actor> actors;
	private Tile[] tiles;
	private Prop[] props;
	private int width, height, size;

	/**
	 * Initializes a new instance of the {@link Grid} class.
	 * 
	 * @param width
	 *            the starting width of this grid
	 * @param height
	 *            the starting height of this grid
	 */
	public Grid(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.size = width * height;

		this.actors = new TreeSet<>();
		this.tiles = new Tile[this.size];
		this.props = new Prop[this.size];

		this.mouseOverEffect = new MouseOverEffect();
	}

	/**
	 * Adds an entity to this grid, allowing it to interact with other entities
	 * in this grid.
	 * 
	 * @param entity
	 *            the entity to add to this grid
	 * @return {@code true} if the entity is added to the grid
	 */
	public boolean add(Entity entity)
	{
		boolean added = false;

		if (entity instanceof Actor) {
			added = isValid(entity.getPosition()) && !isOccupied(entity.getPosition()) ? actors.add((Actor) entity)
					: false;

			if (added && entity instanceof Player) {
				player = (Player) entity;
			}
		}
		else if (entity instanceof Prop) {
			int position = entity.getPosition().getY() * width + entity.getPosition().getX();

			added = isValid(entity.getPosition()) && !isOccupied(entity.getPosition());
			if (added) {
				props[position] = (Prop) entity;
			}
		}
		return added;
	}

	/**
	 * Renders all entities and tiles on this grid.
	 */
	public void show()
	{
		for (Tile tile : tiles) {
			if (tile != null) {
				tile.show();
			}
		}

		for (Prop prop : props) {
			if (prop != null) {
				prop.show();
			}
		}

		for (Actor actor : actors) {
			actor.show();
		}

		mouseOverEffect.show();
	}

	/**
	 * Updates the behavior of all actors on the grid.
	 */
	public void update()
	{
		for (Actor actor : actors) {
			actor.update();
		}

		mouseOverEffect.update();
	}

	public void mouseReleased()
	{
		player.selectTargetOnMouse();
	}

	/**
	 * Returns whether a position on this grid is being occupied by an entity,
	 * regardless of whether the entity is passable or not.
	 * 
	 * @param position
	 *            the position to check on this grid
	 * @return {@code true} if the position specified is occupied by an entity
	 */
	public boolean isOccupied(GridPosition position)
	{
		return false;
	}

	/**
	 * Returns whether a position on this grid is valid for occupation by any
	 * object on the grid. This checks for whether the position is within the
	 * boundaries of this grid.
	 * 
	 * @param position
	 *            the position to check on this grid
	 * @return {@code true} if the position specified is within the boundaries
	 *         of this grid
	 */
	public boolean isValid(GridPosition position)
	{
		return (position.getX() >= 0 && position.getX() < width) && (position.getY() >= 0 && position.getY() < height);
	}

	public GridPosition getMouseClickPosition()
	{
		return this.mouseOverEffect.getPosition();
	}

	/**
	 * Returns the height of this grid.
	 * 
	 * @return the height of this grid
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * Returns the maximum capacity of this grid.
	 * 
	 * @return the maximum capacity of this grid
	 */
	public int getSize()
	{
		return this.size;
	}

	/**
	 * Returns the width of this grid.
	 * 
	 * @return the width of this grid
	 */
	public int getWidth()
	{
		return this.width;
	}
}
