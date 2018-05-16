package command.solutions;

import command.models.Item;

public class ItemMoveCommandTop implements Command {
	private Item item;

	private String previousSetting;

	public ItemMoveCommandTop(Item item, String currentState) {
		this.setItem(item);
		this.setPreviousSetting(currentState);
	}

	public void execute() {
		this.getItem().top();

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
			throw new IllegalArgumentException("Invalid setting!");
		}

	}

	@Override
	public Command clone() {
		ItemMoveCommandTop copy = new ItemMoveCommandTop(getItem(), this.getPreviousSetting());
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
