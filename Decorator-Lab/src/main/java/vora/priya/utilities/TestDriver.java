package vora.priya.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDriver {
	static FileWriter log;
	static FileReader reader;
	static String path = "C:\\Users\\Priya\\Documents\\Quarter Seven\\mylog.txt";

	public static void main(String[] args) throws IOException {
		// new LogFileWriter("C:\\Users\\Priya\\Documents\\Quarter Seven\\mylog.txt")
		log = new SignatureDecorator(new ShiftsCharactersUpDecorator(new LogFileWriter(path)), "Priya");
		//log = new ShiftsCharactersUpDecorator(new SignatureDecorator(new LogFileWriter(path), "Priya"));
		log.write("New Test");
		reader = new ShiftCharactersDownDecorator(new LogFileReader(path));
		reader.read();
		
		System.out.println("\nUnix Conversion: ");
		reader.read();
		UnixConverter converter = new UnixConverter(reader);
		converter.read();
	}

	/** 
	 * When decorator 1 is inside decorator 2 the result is that: only the passed in data is decorated and then the signature is appended to the data being written. 
	 * When decorator 2 is inside decorator 1 the result is that: the data is appended to signature and then the full data is decorated 
	 */
}
