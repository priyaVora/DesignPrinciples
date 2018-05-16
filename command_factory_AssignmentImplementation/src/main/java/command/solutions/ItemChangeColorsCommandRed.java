package command.solutions;

import command.models.Item;

public class ItemChangeColorsCommandRed implements Command {

	private Item item;

	private String previousSetting;

	public ItemChangeColorsCommandRed(Item item, String currentState) {
		this.setItem(item);
		this.setPreviousSetting(currentState);
	}

	public void execute() {
		this.getItem().red();
	}

	public void undo() {
		if (previousSetting == null) {
			return;
		}
		switch (previousSetting) {
		case "Red":
			this.getItem().red();
			break;
		case "Black":
			this.getItem().black();
			break;
		default:
			throw new IllegalArgumentException("Invalid Settings!");
		}

	}

	@Override
	public Command clone() {
		ItemChangeColorsCommandRed copy = new ItemChangeColorsCommandRed(getItem(), this.getPreviousSetting());
		return copy;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getPreviousSetting() {
		return previousSetting;
	}

	public void setPreviousSetting(String previousSetting) {
		this.previousSetting = previousSetting;
	}

}
