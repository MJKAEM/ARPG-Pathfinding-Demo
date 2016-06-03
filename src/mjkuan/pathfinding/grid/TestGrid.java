package mjkuan.pathfinding.grid;

public class TestGrid extends Grid {
	public TestGrid()
	{
		super(10, 7);
		GridPosition playerPosition = new GridPosition(0, 0);
		add(new Player(playerPosition));

		GridPosition rockPosition001 = new GridPosition(1, 1);
		add(new Rock(rockPosition001));

		GridPosition waterPosition001 = new GridPosition(9, 6);
		add(new Water(waterPosition001));
	}
}
