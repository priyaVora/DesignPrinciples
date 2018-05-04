package vora.priya.csc360.a2.strategy;

public class SteamerDuck extends Duck {

	public SteamerDuck() {
		super(new CannotFlyBehavior(), null);
	}
}
