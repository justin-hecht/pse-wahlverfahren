package main;

import java.io.IOException;
import java.util.List;

import cmbcInterface.CallCbmc;
import utils.FileCreator;

public class Main {
	
	private static String fileName = "temp_file_for_checking.c";

	public static void main(String[] args) throws IOException {
		FileCreator fc = new FileCreator();
		
		fc.createFile("testProgram.c", fileName);
		
		List<String> output =  CallCbmc.callCbmc(fileName, "--trace", "--unwind 5");
		
		output.forEach(in -> {
			System.out.println(in);
		});
	}
}
