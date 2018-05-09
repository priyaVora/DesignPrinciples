package vora.priya.utilities;

import java.io.File;
import java.io.IOException;

public class ThreadIdPrependingFileWritingDecorator implements FileWriter {

	private FileWriter outWriter;

	public ThreadIdPrependingFileWritingDecorator(FileWriter o) {
		this.outWriter = o;
	}

	public void write(String data) throws IOException {
		System.out.println("Write method from Thread Id was called!");
		data = Thread.currentThread().getId() + " " + data;
		System.out.println("\tThread id: " + Thread.currentThread().getId());
		System.out.println("\t\tCurrent Data: " + data);
		outWriter.write(data);
	}

	public void read(String data) throws IOException {
		System.out.println("Read method for Thread id was called");
		
	}
}
