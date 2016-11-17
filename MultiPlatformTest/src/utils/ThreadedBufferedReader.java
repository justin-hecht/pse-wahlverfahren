package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ThreadedBufferedReader extends Thread{

	private BufferedReader reader;
	private List<String> readLines;
	private boolean interrupted = false;
	
	public ThreadedBufferedReader(BufferedReader reader, List<String> readLines) {
		this.reader = reader;
		this.readLines = readLines;
	}
	
	@Override
	public void run() {
		String line = null;
		try {
			line = reader.readLine();
			while (line != null && !interrupted) {
				readLines.add(line);
				line = reader.readLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void interrupt() {
		interrupted = true;
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
