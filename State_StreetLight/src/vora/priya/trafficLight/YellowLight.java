package vora.priya.trafficLight;

public class YellowLight implements State {
	private TrafficLight trafficLight;

	public YellowLight(TrafficLight trafficLight) {
		this.setTrafficLight(trafficLight);
	}

	@Override
	public void TransitionNextLight() {
		this.trafficLight.setState(this.trafficLight.getRedlightState());
		System.out.println("Tranformed to Red Light");
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
