package command.solutions;

import java.util.Stack;

public class ItemControl {

	public static final int ROWS = 50;
	public static final int COLS = 50;
	
	private Command[][] buttons = new Command[ROWS][COLS];
	
	private Stack<Command> commands = new Stack<Command>();
	
	public void program(int r, int c, Command functionality) {
		buttons[r][c] = functionality;
	}
	
	public void pressButton(int r, int c) {
		Command cmd = buttons[r][c];
		if(cmd != null) {
			cmd.execute();
			commands.push(cmd.clone());
		}
	}
	
	public void pressUndoButton() { 
		if(commands.isEmpty()) { 
			return;
		}
		Command cmd = commands.pop();
		cmd.undo();
	}
}
