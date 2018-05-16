package command.solutions;


public interface Command {

	void execute();
	
	void undo();
	
	Command clone(); //makes new instance of object with same data
}
