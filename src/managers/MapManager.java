package managers;

import javax.print.attribute.standard.JobHoldUntil;
import javax.sql.rowset.JoinRowSet;

import utilities.Room;

public class MapManager {
	// for map size.
	private final static int Y_Width = 8;
	private final static int X_LENGTH = 8;
	private final static int START_POINT = 0;
	private final static int NUMBER_OF_TREASURE_ROOMS = X_LENGTH / 4;

	// Map properties
	private byte xStartCord;
	private byte yStartCord;

	// The Room the player is currently in
	private byte xCurrentCord;
	private byte yCurrentCord;

	// Boss Room Coordinates
	private byte xBossCord;
	private byte yBossCord;

	public Room[][] roomMap = new Room[X_LENGTH][Y_Width];

	public MapManager() {

		populateMap();
	}

	public void printMap() {

	}

	/*
	 * This method will do a few main things 1. Make a chain n long at random.
	 * Create rooms of n length connected from left to right.
	 * 
	 */
	private void populateMap() {
		xStartCord = (byte) randomizeX();
		yStartCord = (byte) randomizeY();
		xBossCord = -1;
		yBossCord = -1;
		
		while (xBossCord != xStartCord && yBossCord != xStartCord) {
			xBossCord = (byte) randomizeX();
			yBossCord = (byte) randomizeY();
		}
		generateRoom(xStartCord, yStartCord, xBossCord, yBossCord);

	
	}

	private void generateRoom(int xStartCord, int yStartCord, int xBossCord, int yBossCord) {

		Room startRoom = new Room(false, false, false, false);
		Room bossRoom = new Room(false, false, false, false);
		System.out.println("x: " + xBossCord + " -- y:" + yBossCord);
		roomMap[xStartCord][yStartCord] = startRoom;
		roomMap[xBossCord][yBossCord] = bossRoom;
		
		xStartCord = 0;
		yStartCord = 0;
		//Minus 2 since we already have two rooms.
		int totalRooms = X_LENGTH * Y_Width - 2;
		
		for (int i = 0; i < totalRooms; i++) {
			
			System.out.println("x: " + xStartCord++ + " -- y:" + yStartCord++);
		}

	}

	private boolean canhavePath() {
		return (randomizeX() >= X_LENGTH / 2);
	}

	private int randomizeX() {
		return (int) ((Math.random() * X_LENGTH) - 1);
	}

	private int randomizeY() {
		return (int) ((Math.random() * Y_Width) - 1);
	}
}
