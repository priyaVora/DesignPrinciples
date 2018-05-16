package command.solutions;

import command.models.Item;

public class TestDriver {

	public static void main(String[] args) {
		ItemControl rc = new ItemControl();
		Item item = new Item();

		 rc.program(0, 0, new ItemMoveCommandTop(item, item.getMovement() != null ? item.getMovement(): "Top"));
		 rc.program(1, 1, new ItemMoveCommandBottom(item, item.getMovement() != null ?
		 item.getMovement(): "Bottom"));
		 rc.program(1, 0, new ItemMoveCommandLeft(item, item.getMovement() != null ?
		 item.getMovement(): "Left"));
		 rc.program(3, 1, new ItemMoveCommandRight(item, item.getMovement() != null ?
		 item.getMovement(): "Right"));
		
		 rc.pressButton(0, 0);
		 rc.pressButton(1, 1);
		 rc.pressButton(1, 1);
		 rc.pressButton(1, 0);
		 rc.pressButton(3, 1);
		 System.out.println("\n***Undo Commands");
		 rc.pressUndoButton();
		 rc.pressUndoButton();
		 rc.pressUndoButton();
		 rc.pressUndoButton();
		 rc.pressUndoButton();

		 System.out.println(" ");
		rc.program(3, 1,new ItemChangeColorsCommandRed(item, item.getColorChange() != null ? item.getColorChange() : "Red"));
		rc.program(4, 1, new ItemChangedColorsCommandBlack(item, item.getColorChange() != null ? item.getColorChange() : "Black"));
		
		 rc.pressButton(3,1);
		 rc.pressButton(4,1);
		 System.out.println("\n***Undo Commands");
		 rc.pressUndoButton();
		 rc.pressUndoButton();
	}
}
