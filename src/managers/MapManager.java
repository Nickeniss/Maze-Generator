package managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.print.attribute.standard.JobHoldUntil;
import javax.sql.rowset.JoinRowSet;

import utilities.Room;

public class MapManager {
	// for map size.
	private final static int Y_Width = 16;
	private final static int X_LENGTH = 16;

	// Map File path
	private final static String MAP_FILE_PATH = "src/res/mapTest.txt";
	private final File MAP_FILE = new File(MAP_FILE_PATH);

	// Map properties
	private byte xStartCord = 0;
	private byte yStartCord = 0;

	// The Room the player is currently in
	private byte xCurrentCord = 0;
	private byte yCurrentCord = 0;

	// Boss Room Coordinates
	private byte xBossCord;
	private byte yBossCord;

	private Room[][] roomMap = new Room[X_LENGTH][Y_Width];

	private int[][] roomFile = new int[X_LENGTH][Y_Width];
	
	
	//Basic Room type numbers for file reading
	private final static byte BASIC_ROOM = 1;
	private final static byte TREASURE_ROOM = 2;
	private final static byte BOSS_ROOM = 3;

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

		try {
			readRoomFile(MAP_FILE);
			createRoomMap();
		}  catch (IOException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * While the file exists, it will split each line of the file by a " " space.
	 * Then parsing it to the roomFile 2D Array
	 * 
	 * @param file - File to read from for 2d array
	 * @throws IOException
	 */
	private void readRoomFile(File file) throws IOException {

		int currentRow = 0;
		if (file.exists()) {
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNext()) {
				String currentLine = fileReader.nextLine();
				String[] currentLineArray = currentLine.split(" ");
				for (int i = 0; i < currentLineArray.length; i++) {

					roomFile[currentRow][i] = Integer.parseInt(currentLineArray[i]);

				}

				currentRow++;
			}
			fileReader.close();
		}

	}

	/**
	 * This function will iterate over the entire 2d array It will check the file
	 * version at the current indexes and check whether it's a room that is
	 * connectable. If true, then it will check all adjacent rooms to see which is
	 * one it will connect to. Then set the correct side.
	 * 
	 * @throws IOException
	 */
	private void createRoomMap() throws IOException {

		for (int i = 0; i < X_LENGTH; i++) {
			for (int j = 0; j < Y_Width; j++) {
				roomMap[i][j] = new Room();
				if (roomFile[i][j] >= BASIC_ROOM) {

					// Check left
					if (j - 1 > 0) {
						roomMap[i][j].setLeft(roomFile[i][j - 1] >= BASIC_ROOM);
					}

					// Check right
					if (j < (X_LENGTH - 1)) {
						roomMap[i][j].setRight(roomFile[i][j + 1] >= BASIC_ROOM);
					}

					// Check up
					if (i - 1 > 0) {
						roomMap[i][j].setUp(roomFile[i - 1][j] >= BASIC_ROOM);
					}

					// Check down
					if (i < (Y_Width - 1)) {
						roomMap[i][j].setDown(roomFile[i + 1][j] >= BASIC_ROOM);
					}

				}
				
				
				if (roomFile[i][j] == BOSS_ROOM) {
					xBossCord = (byte)j;
					yBossCord = (byte)i;
				}

			}
		}
	}
		
	
	
	
	private byte randomize(int length) {
		return (byte) ((Math.random() * length) + 3);
	}

	
}
