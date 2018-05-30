package vora.priya.trafficLight;

public class GreenLight implements State {
	private TrafficLight trafficLight;

	public GreenLight(TrafficLight trafficLight) {
		this.setTrafficLight(trafficLight);
	}

	@Override
	public void TransitionNextLight() {
		this.trafficLight.setState(this.trafficLight.getYellowlightState());
		System.out.println("Tranformed to yellow light.");
	}

	public TrafficLight getTrafficLight() {
		return trafficLight;
	}

	public void setTrafficLight(TrafficLight trafficLight) {
		if(trafficLight == null) { 
			throw new IllegalArgumentException("Traffic Light cannot be null");
		}
		this.trafficLight = trafficLight;
	}

}
