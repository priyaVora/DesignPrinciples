package vora.priya.utilities;

import java.io.IOException;
import java.util.Calendar;

public class TimeStampPrependingFileWriter implements FileWriter {
	private FileWriter outWriter;

	public TimeStampPrependingFileWriter(FileWriter o) {
		this.outWriter = o;
	}

	public void write(String data) throws IOException {
		System.out.println("Write Method from TimeStamp Was Called!");
		Calendar c = Calendar.getInstance();
		data = c.getTime() + " " + data;
		System.out.println("\t" + "Current Time: " + c.getTime());
		System.out.println("\t\tCurrent Data: " + data);
		outWriter.write(data);
	}

	public void read(String data) throws IOException {
		System.out.println("Read method from TimeStap class was called!");
	}

}
