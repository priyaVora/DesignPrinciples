package vora.priya.utilities;

public class Configuration {
	private boolean timeStampLogging;
	private boolean threadIdLogging;

	public Configuration() {

	}

	public boolean isTimeStampLogging() {
		return timeStampLogging;
	}

	public void setTimeStampLogging(boolean timeStampLogging) {
		this.timeStampLogging = timeStampLogging;
	}

	public boolean isThreadIdLogging() {
		return threadIdLogging;
	}

	public void setThreadIdLogging(boolean threadIdLogging) {
		this.threadIdLogging = threadIdLogging;
	}

}
