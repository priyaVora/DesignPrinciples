package vora.priya.trafficLight;

public class TrafficLight {
	private RedLight redlightState;
	private GreenLight greenlightState;
	private YellowLight yellowlightState;

	public State state;

	public TrafficLight() {
		this.greenlightState = new GreenLight(this);
		this.redlightState = new RedLight(this);
		this.yellowlightState = new YellowLight(this);
		this.setState(redlightState);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public RedLight getRedlightState() {
		return redlightState;
	}

	public GreenLight getGreenlightState() {
		return greenlightState;
	}

	public YellowLight getYellowlightState() {
		return yellowlightState;
	}

}
