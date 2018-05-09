package vora.priya.utilities;

import java.io.File;
import java.io.IOException;

public class ShiftCharactersDownDecorator implements FileReader {

	private FileReader reader;

	public ShiftCharactersDownDecorator(FileReader o) {
		this.reader = o;
	}

	public String read() throws IOException {
		System.out.println("\nRead method from Shift Character Down Decorator was called.");
		String capturedData = reader.read();
		String readData = shiftCharactersDown(capturedData);
		System.out.println("\tCaptured Data: " + capturedData);
		System.out.println("\tResult:  " + readData);
		return readData;
	}

	public String shiftCharactersDown(String data) {
		boolean valid = false;
		char[] toEncode = data.toCharArray();
		String newData = "";
		boolean capitalized = false;
		for (int j = 0; j < toEncode.length; j++) {
			char c = toEncode[j];
			if (Character.isLetter(c) == true) {
				if (Character.isUpperCase(c) == true) {
					String d = "" + c;
					// System.out.println("Recieved: " + d);
					char[] charArray = d.toLowerCase().toCharArray();
					c = charArray[0];
					// System.out.println("After received: " + c);
					// System.out.println("\nChanged: " + c);
					capitalized = true;
				}
				c = (char) (((c - 'a' + 25) % 26) + 'a');
			}
			if (capitalized == true) {
				String cap = "" + c;
				char[] cal = cap.toUpperCase().toCharArray();
				c = cal[0];
				newData += c;
				capitalized = false;
			} else {
				newData += c;
			}
		}
		return newData;
	}
}
