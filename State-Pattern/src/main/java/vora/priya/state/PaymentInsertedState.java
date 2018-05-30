package vora.priya.state;

public class PaymentInsertedState implements State {

	private GumballMachine machine;

	public PaymentInsertedState(GumballMachine m) {
		this.machine = m;
	}

	public void insertCoin() {
		System.err.println("no.");

	}

	public void turnCrank() {
		this.machine.setState(this.machine.getDispensingGumballState());
		System.out.println("To dispensing");
	}

	public void takeGumBall() {
		System.err.println("no.");
	}

	public void pressCoinReturn() {
		this.machine.setState(this.machine.getAtRestWithGumballsState());
		System.out.println("Back to rest.");
	}

}
