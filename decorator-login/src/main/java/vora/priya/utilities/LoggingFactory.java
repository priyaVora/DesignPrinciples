package vora.priya.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoggingFactory {
	public static FileWriter getInstance(Configuration cfg) throws IOException {
		//return the parent abstract type
		//made it static because it doesn't use heap memory
		//cost: trade off that you no longer can make constructor or class
		//no garbage collection
		FileWriter log = new LogFileWriter("C:\\Users\\Priya\\Documents\\Quarter Seven\\mylog.txt");
		if(cfg.isTimeStampLogging()) { 
			log = new TimeStampPrependingFileWriter(log);
		}
		if(cfg.isThreadIdLogging()) { 
			log = new ThreadIdPrependingFileWritingDecorator(log);
		}
		
		log.write("This is my test line");
		return log; 		
	}
}
