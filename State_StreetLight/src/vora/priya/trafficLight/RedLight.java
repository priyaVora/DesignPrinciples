package vora.priya.trafficLight;

public class RedLight implements State {

	private TrafficLight trafficLight;

	public RedLight(TrafficLight trafficLight) {
		this.setTrafficLight(trafficLight);
	}

	@Override
	public void TransitionNextLight() {
		this.trafficLight.setState(this.trafficLight.getGreenlightState());
		System.out.println("Tranformed to Green Light");
	}

	public TrafficLight getTrafficLight() {
		return trafficLight;
	}

	public void setTrafficLight(TrafficLight trafficLight) {
		if (trafficLight == null) {
			throw new IllegalArgumentException("Traffic Light cannot be null");
		}
		this.trafficLight = trafficLight;
	}

}
