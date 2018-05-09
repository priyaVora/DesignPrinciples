package vora.priya.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LogFileReader implements FileReader {

	private FileInputStream fileIn;
	String path = "";

	public LogFileReader(String path) throws FileNotFoundException {
		this.setFileInputStream(path);
		this.path = path;
	}

	private void setFileInputStream(String path) throws FileNotFoundException {
		if (path == null) {
			throw new IllegalArgumentException("cannot be null");
		}
		fileIn = new FileInputStream(path);
	}

	public String read() throws IOException {
		//System.out.println("Read Method for log files was called.");
		this.setFileInputStream(path);
		byte[] dataArray = new byte[(int) new File(path).length()];
		int readData = this.fileIn.read(dataArray);
		//System.out.println("Read Data: " + readData);
		String fileData = "";
		for (byte b : dataArray) {
			//System.out.print((char) b);
			fileData += ((char) b);
		}
		//System.out.println("\n\nData: " + fileData);
		return fileData;
	}
}
