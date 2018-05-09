package vora.priya.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDriver {

	static FileWriter log;
	static Configuration cfg;

	public static void main(String[] args) throws IOException {
		log = new LoggingFactory().getInstance(cfg);
		log.write("This is my test line");
	}
}
