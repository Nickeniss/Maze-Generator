package managers;


public class MapManager {
	//for map size.
	private final static int Y_Width = 8;
	private final static int X_LENGTH = 5;
	private final static int START_POINT = 0;
	private final static int NUMBER_OF_TREASURE_ROOMS = X_LENGTH/4;
	
	//Map properties
	private char [][] map;
	private int yCoordinate;
	private int xCoordinate;
	
	
	
	public MapManager() {
		this.map = new char [X_LENGTH][Y_Width];
		populateMap();
	}

	public char[][] getMap() {
		return map;
	}

	public void printMap() {
		for(int i = 0; i < X_LENGTH; i++) {
			for (int j = 0; j < Y_Width; j++) {
				if (map[i][j] == '\0') {
					map[i][j] = 'x';
				}
				System.out.print("[" + map[i][j] + "]");
				
			}
			System.out.println("\n");
		}
	}
	
	/*
	 * This method will do a few main things
	 * 1. It will generate 1 end point and a begin point
	 * 2. A beginning point is always the corner [0][0]
	 * 3. A end point is a random point within the plain
	 * 4. There is only 1 true path
	 * 5. It will choose a set amount of treasure rooms
	 * 6. it will connect paths and room at random.
	 */
	private void populateMap() {
		int random_x = randomize();
		int random_y = randomize(); 
		this.map[random_x][random_y] = 'g';
		this.map[START_POINT][START_POINT] = 's';
		int i = 0;
		while (i < NUMBER_OF_TREASURE_ROOMS) {
			random_x = randomize();
			random_y = randomize();
			if (map[random_x][random_y] == '\0') {
				map[random_x][random_y] = 't';
				i++;
			}
		}
		
	}
	
	private int randomize() {
		return (int)(Math.random() * X_LENGTH - 1);
	}
				
	
}
