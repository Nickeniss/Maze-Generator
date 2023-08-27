package utilities;

import managers.MapManager;

public class Room {
	
	private boolean hasRight;
	private boolean hasLeft;
	private boolean hasUp;
	private boolean hasDown;
	private boolean hasTreasure;
	
	public Room(boolean left, boolean right, boolean up, boolean down) {
		this.hasRight = left;
		this.hasLeft = right;
		this.hasUp = up;
		this.hasDown = down;
	}
	
	public Room() {
		this.hasRight = false;
		this.hasLeft = false;
		this.hasUp = false;
		this.hasDown = false;
		this.hasTreasure = false;
	}

	public boolean hasRight() {
		return hasRight;
	}

	public void setRight(boolean hasRight) {
		this.hasRight = hasRight;
	}

	public boolean hasLeft() {
		return hasLeft;
	}

	public void setLeft(boolean hasLeft) {
		this.hasLeft = hasLeft;
	}

	public boolean hasUp() {
		return hasUp;
	}

	
	public void setTreasure(boolean hasTreasure) {
		this.hasTreasure = hasTreasure;
	}

	public boolean hasTreasure() {
		return hasTreasure;
	}  
	
	public void setUp(boolean hasUp) {
		this.hasUp = hasUp;
	}

	public boolean hasDown() {
		return hasDown;
	}
	
	public void setDown(boolean hasDown) {
		this.hasDown = hasDown;
	}
	
	@Override
	public String toString() {
		
		return "\nLeft: " + this.hasLeft() + "\nRight: " + this.hasRight() + "\nUp: " + this.hasUp() + "\nDown: " + this.hasDown();
	}

	
	
}
