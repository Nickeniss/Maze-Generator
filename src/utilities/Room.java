package utilities;

import managers.MapManager;

public class Room {
	
	private boolean hasRight;
	private boolean hasLeft;
	private boolean hasUp;
	private boolean hasDown;
	
	
	public Room(boolean left, boolean right, boolean up, boolean down) {
		this.hasRight = left;
		this.hasLeft = right;
		this.hasUp = up;
		this.hasDown = down;
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
		
		return "\nLeft: " + hasLeft() + "\nRight: " + hasRight() + "\nUp: " + hasUp() + "\nDown: " + hasDown();
	}

	
	
}
