package utilities;

import managers.MapManager;

public class Room {
	
	
	
	
	private Room leftRoom;
	private Room rightRoom;
	private Room upRoom;
	private Room downRoom;
	private int yRoomCoordinate;
	private int xRoomCoordinate;
	
	public Room(Room left, Room right, Room up, Room down, int x, int y) {
		this.xRoomCoordinate = x;
		this.yRoomCoordinate = y;
		this.leftRoom = left;
		this.rightRoom = right;
		this.upRoom = up;
		this.downRoom = down;
	}
	
	
	
	
	public Room getLeftRoom() {
		return leftRoom;
	}

	public void setLeftRoom(Room leftRoom) {
		this.leftRoom = leftRoom;
	}

	public Room getRightRoom() {
		return rightRoom;
	}

	public void setRightRoom(Room rightRoom) {
		this.rightRoom = rightRoom;
	}

	public Room getUpRoom() {
		return upRoom;
	}

	public void setUpRoom(Room upRoom) {
		this.upRoom = upRoom;
	}

	public Room getDownRoom() {
		return downRoom;
	}

	public void setDownRoom(Room downRoom) {
		this.downRoom = downRoom;
	}
	
	public boolean hasRight() {
		return rightRoom != null;
	}
	
	public boolean hasleft() {
		return leftRoom != null;
	}
	
	public boolean hasUp() {
		return upRoom != null;
	}
	
	public boolean hasDown() {
		return downRoom != null;
	}
	
	
}
