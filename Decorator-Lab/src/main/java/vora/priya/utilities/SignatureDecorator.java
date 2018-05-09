package vora.priya.utilities;

import java.io.IOException;
import java.util.Calendar;

public class SignatureDecorator implements FileWriter {
	private FileWriter outWriter;
	private String name;

	public SignatureDecorator(FileWriter o, String name) {
		this.outWriter = o;
		this.name = name;
	}

	public void write(String data) throws IOException {
		System.out.println("Write Method from Signature Decorator Was Called!");
		Calendar c = Calendar.getInstance();
		data = name + " " + c.getTime() + "\r\n" + data;
		System.out.println("\t" + c.getTime());
		outWriter.write(data);
	}
}
