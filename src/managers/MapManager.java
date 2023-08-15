package managers;

import utilities.Room;

public class MapManager {
	//for map size.
	private final static int Y_Width = 8;
	private final static int X_LENGTH = 8;
	private final static int START_POINT = 0;
	private final static int NUMBER_OF_TREASURE_ROOMS = X_LENGTH/4;
	
	//Map properties
	private Room startRoom;
	
	//The Room the player is currently in
	private Room currentRoom;
	
	//Boss Room Coordinates
	private Room bossRoom;
	
	public byte[][] roomMapCoordinates = new byte[X_LENGTH][Y_Width];	
	
	
	public MapManager() {
		
		populateMap();
	}

	public void printMap() {
	
	}
	
	

	

	/*
	 * This method will do a few main things
	 * 1. Make a chain n long at random. Create rooms of n length connected from left to right.
	 * 
	 */
	private void populateMap() {
		int length = randomizeX();
		Room tempRoom;
		startRoom = new Room(null, null, null, null, 0, 0);
		currentRoom = startRoom;
		for (int i = 1; i < length; i++) {
			tempRoom = new Room(null, currentRoom, null, null, i, 0);
			roomMapCoordinates[i][0] = 0;
			currentRoom.setLeftRoom(tempRoom);
			currentRoom = tempRoom;
			
		}
		
	}
	
	
	
	
	
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	
	
	private int randomizeX() {
		return (int)((Math.random() * X_LENGTH) + 4);
	}
				
	private int randomizeY() {
		return (int)((Math.random() * Y_Width) + 4);
	}
}
