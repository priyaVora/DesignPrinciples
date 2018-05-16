package command.solutions;

import command.models.Item;

public class ItemMoveCommandBottom implements Command {
	private Item item;

	private String previousSetting;

	public ItemMoveCommandBottom(Item item, String currentState) {
		this.setItem(item);
		this.setPreviousSetting(currentState);
	}

	public void execute() {
		this.getItem().bottom();

	}

	public void undo() {
		if (previousSetting == null) {
			return;
		}
		switch (previousSetting) {
		case "Top":
			this.getItem().top();
			break;
		case "Right":
			this.getItem().right();
			break;
		case "Bottom":
			this.getItem().bottom();
			break;
		case "Left":
			this.getItem().left();
			break;

		default:
			throw new IllegalArgumentException("Invalid Setting!");
		}

	}

	@Override
	public Command clone() {
		ItemMoveCommandBottom copy = new ItemMoveCommandBottom(getItem(), this.getPreviousSetting());
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
