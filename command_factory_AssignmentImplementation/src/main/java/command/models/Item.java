package command.models;

public class Item {
	private String movement;
	private String colorChange;

	public void top() {
		movement = "Top";
		System.out.println(movement);
	}

	public void right() {
		movement = "Right";
		System.out.println(movement);
	}

	public void bottom() {
		movement = "Bottom";
		System.out.println(movement);
	}

	public void left() {
		movement = "Left";
		System.out.println(movement);
	}

	public void red() {
		colorChange = "Red";
		System.out.println("Item is Red!");
	}

	public void black() {
		colorChange = "Black";
		System.out.println("Item is Black!");
	}

	public String getMovement() {
		return movement;
	}

	public String getColorChange() {
		return colorChange;
	}

	public void setColorChange(String colorChange) {
		this.colorChange = colorChange;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}
}
