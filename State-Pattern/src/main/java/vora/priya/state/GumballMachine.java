package vora.priya.state;

public class GumballMachine {
	private AtRestWithGumBallsState atRestWithGumballsState;
	private PaymentInsertedState paymentInsertedState;
	private DispensingGumballState dispensingGumballState;

	private State state;

	public GumballMachine() {
		this.atRestWithGumballsState = new AtRestWithGumBallsState(this);
		this.paymentInsertedState = new PaymentInsertedState(this);
		this.dispensingGumballState = new DispensingGumballState(this);
		this.setState(atRestWithGumballsState);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public AtRestWithGumBallsState getAtRestWithGumballsState() {
		return atRestWithGumballsState;
	}

	public PaymentInsertedState getPaymentInsertedState() {
		return paymentInsertedState;
	}

	public DispensingGumballState getDispensingGumballState() {
		return dispensingGumballState;
	}

}
