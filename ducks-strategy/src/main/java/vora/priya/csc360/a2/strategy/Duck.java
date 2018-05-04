package vora.priya.csc360.a2.strategy;

public class Duck {

	private FlyingBehavior flyingBehavior;

	private SpeakingBehavior speakingBehavior;

	public Duck() {

	}

	public Duck(FlyingBehavior f, SpeakingBehavior s) {
		this.setFlyingBehavior(f);
		this.setSpeakingBehavior(s);
	}

	public FlyingBehavior getFlyingBehavior() {
		return flyingBehavior;
	}

	public void setFlyingBehavior(FlyingBehavior flyingBehavior) {
		this.flyingBehavior = flyingBehavior;
	}

	public SpeakingBehavior getSpeakingBehavior() {
		return speakingBehavior;
	}

	public void setSpeakingBehavior(SpeakingBehavior speakingBehavior) {
		this.speakingBehavior = speakingBehavior;
	}

}
