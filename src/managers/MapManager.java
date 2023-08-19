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

	//Map File path
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 
		
		
	}
	
	//Reads map file in Res.
	private void readRoomFile(File file) throws IOException {
		
		int currentRow = 0;
		if(file.exists()) {
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNext()) {
				String currentLine = fileReader.nextLine();
				String[] currentLineArray = currentLine.split(" ");
				for(int i = 0; i < currentLineArray.length; i++) {
					roomFile[i][currentRow] = Integer.parseInt(currentLineArray[i]);
					
				}
				
				currentRow++;
			}
			fileReader.close();
		}
		
		
	}
	


	private int randomizeX() {
		return (int) ((Math.random() * X_LENGTH) - 1);
	}

	private int randomizeY() {
		return (int) ((Math.random() * Y_Width) - 1);
	}
}
