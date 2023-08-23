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

	private final static int NUMBER_OF_TREASURE_ROOMS = X_LENGTH / 4;

	// Map File path
	private final static String MAP_FILE_PATH = "src/res/mapTest.txt";
	private final File MAP_FILE = new File(MAP_FILE_PATH);

	// Map properties
	private byte xStartCord;
	private byte yStartCord;

	// The Room the player is currently in
	private byte xCurrentCord;
	private byte yCurrentCord;

	// Boss Room Coordinates
	private byte xBossCord;
	private byte yBossCord;

	private Room[][] roomMap = new Room[X_LENGTH][Y_Width];

	private int[][] roomFile = new int[X_LENGTH][Y_Width];

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
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < X_LENGTH; i++) {
			for (int j = 0; j < Y_Width; j++) {

				System.out.println("roomMap[" + i + "][" + j + "]" + roomMap[i][j].toString());
			}
		}

	}

	// Reads map file in Res.
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

	private void createRoomMap() throws IOException {

		for (int i = 0; i < X_LENGTH; i++) {
			for (int j = 0; j < Y_Width; j++) {
				roomMap[i][j] = new Room();
				if (roomFile[i][j] == 1) {

					// Check left
					if(j - 1 > 0) {
						roomMap[i][j].setLeft(roomFile[i][j - 1] == 1);
					}
					
					// Check right
					if(j < (Y_Width - 1)) {
						roomMap[i][j].setRight(roomFile[i][j + 1] == 1);
					}
					
					// Check up
					if(i - 1 > 0) {
						roomMap[i][j].setUp(roomFile[i - 1][j] == 1);
					}
					
					//Check down
					if(i < (X_LENGTH - 1)) {
						roomMap[i][j].setDown(roomFile[i + 1][j] == 1);
					}
					
				}

			}
		}
	}

	private int randomizeX() {
		return (int) ((Math.random() * X_LENGTH) - 1);
	}

	private int randomizeY() {
		return (int) ((Math.random() * Y_Width) - 1);
	}
}
