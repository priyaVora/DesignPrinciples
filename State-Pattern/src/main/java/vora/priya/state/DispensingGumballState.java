package vora.priya.state;

public class DispensingGumballState implements State {

	private GumballMachine machine;

	public DispensingGumballState(GumballMachine m) {
		this.machine = m;
	}

	public void insertCoin() {
		System.err.println("no.");
	}

	public void turnCrank() {
		System.err.println("no.");

	}

	public void takeGumBall() {
		this.machine.setState(this.machine.getAtRestWithGumballsState());
	}

	public void pressCoinReturn() {
		System.err.println("no.");
	}

}
