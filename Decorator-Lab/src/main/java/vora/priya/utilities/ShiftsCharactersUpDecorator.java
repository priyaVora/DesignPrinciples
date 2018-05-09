package vora.priya.utilities;

import java.io.File;
import java.io.IOException;

public class ShiftsCharactersUpDecorator implements FileWriter {

	private FileWriter outWriter;

	public static void main(String[] args) {
		ShiftsCharactersUpDecorator up = new ShiftsCharactersUpDecorator(null);
		String newData = up.shiftCharacters("DaD");
		// Tue May 08 19:47:54 MDT 2018
		System.out.println("New Data: " + newData);
		// got: UvfUNbzUKSULTUORUPOUN_UUMKLS
		// expected: QsjzbUUvfUNbzUKSULTUORUPOUN_UUMKLSUOfxUUftu
	}

	public ShiftsCharactersUpDecorator(FileWriter o) {
		this.outWriter = o;
	}

	public void write(String data) throws IOException {
		System.out.println("Write method from Shift Character Up Decorator was called!");
		System.out.println("\tData Recieved: " + data);
		data = shiftCharacters(data);
		outWriter.write(data);
	}

	public String shiftCharacters(String data) {
		// data = data.toLowerCase();
		char[] toEncode = data.toCharArray();
		String newData = "";
		for (int j = 0; j < toEncode.length; j++) {
			char c = toEncode[j];
			// between lowercase a and z: between uppercase a and uppercase z
			if (Character.isLetter(c) == true) {
				if (Character.isUpperCase(c) == true) {
					String upperCase = c + "";
					String makeLowerCase = upperCase.toLowerCase();
					// System.out.println("Received : " + c);
					// System.out.println("Made Lower Case: " + makeLowerCase);
					c = makeLowerCase.toCharArray()[0];
					c = (char) (((c - 'a' + 1) % 26) + 'a');
					// System.out.println("Before upper case: " + c);
					String makeUpperCase = ("" + c).toUpperCase();
					char[] dataArray = makeUpperCase.toCharArray();
					c = dataArray[0];
					// System.out.println("End: " + c);

				} else {
					c = (char) (((c - 'a' + 1) % 26) + 'a');
				}
			}
			newData += c;
		}
		return newData;
	}
}