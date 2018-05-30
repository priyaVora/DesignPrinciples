package vora.priya.state;

public class AtRestWithGumBallsState implements State {

	private GumballMachine machine;

	public AtRestWithGumBallsState(GumballMachine m) {
		this.setMachine(m);
	}

	public GumballMachine getMachine() {
		return machine;
	}

	public void setMachine(GumballMachine machine) {
		if (machine == null) {
			throw new IllegalArgumentException("Machine cannot be null");
		}
		this.machine = machine;
	}

	public void insertCoin() {
		this.machine.setState(this.machine.getPaymentInsertedState());
		System.out.println("To payment inserted state.");
	}

	public void turnCrank() {
		System.err.println("Cannot crank in this state.");

	}

	public void takeGumBall() {
		System.err.println("Cannot take gumball in this state.");
	}

	public void pressCoinReturn() {
		System.err.println("Cannot get coin in this state.");

	}

}
