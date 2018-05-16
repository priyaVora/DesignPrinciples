
public class RemoteControl {
	public static final int ROWS = 8;
	public static final int COLS = 2;

	private Command[][] buttons = new Command[ROWS][COLS];

	public void program(int r, int c, Command functionality) {
		buttons[r][c] = functionality;
	}

	public void pressButton(int r, int c) {
		Command cmd = buttons[r][c];
		if (cmd != null) {
			cmd.execute();
		}
	}
}
