package vora.priya.utilities;

import java.io.IOException;

public class UnixConverter implements FileReader {

	FileReader reader;

	public UnixConverter(FileReader reader) {
		this.reader = reader;
	}

	public String read() throws IOException {
		String readerData = this.reader.read();
		System.out.println("Before Unix Conversion: " + readerData);
		readerData = readerData.replaceAll("\r\n", "\n");
		System.out.println("After Unix Conversion: " +  readerData);
		return readerData;
	}

}
