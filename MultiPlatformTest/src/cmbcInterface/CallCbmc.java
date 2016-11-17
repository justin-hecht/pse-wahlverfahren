package cmbcInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import utils.ThreadedBufferedReader;
import utils.Utils;

public class CallCbmc {

	private static boolean isLinux = false;
	private static boolean isWindows = false;

	public static ArrayList<String> callCbmc(String fileName, String... parameters) throws IOException {
		
		ProcessBuilder prossBuild = null;
		Process cbmcProcess = null;
		
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> errors = new ArrayList<>();
		
		ThreadedBufferedReader outReader;
		ThreadedBufferedReader errReader;
		//get the path where the file that is to be checked is located
		String filePath = Utils.getFileFromRes(fileName);
		
		//get the operation system
		String os = System.getProperty("os.name");
		
		isWindows = (os.toLowerCase().contains("windows"));
		isLinux = (os.toLowerCase().contains("linux"));
		
		
		if(isWindows) {
			String vsCmd = getVScmdPath();
			
			String cbmcEXE = Utils.getFileFromRes("/cbmcWIN/cbmc.exe");
			
			//assemble the call that is to be given to the process
			String cbmcCall = "\"" + vsCmd + "\"" + " & " + cbmcEXE + " " + filePath;
			
			//add all the other missing arguments for that call
			for (int i = 0; i < parameters.length; i++) {
				cbmcCall = cbmcCall + " " + parameters[i]; 
			}
			
			prossBuild = new ProcessBuilder("cmd.exe", "/c", cbmcCall);	
			
		} else if (isLinux) {
			String arguments = "";
			
			//add up the arguments for the call
			for (int i = 0; i < parameters.length; i++) {
				arguments = arguments + " " + parameters[i];
			}
			
			prossBuild = new ProcessBuilder("cbmc", fileName, arguments);
			
		} else {
			System.err.println("You are using an unknown OS. Shutting down.");
		}
		
		
		
		

		try {
			cbmcProcess = prossBuild.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (cbmcProcess != null) {
			
			outReader = new ThreadedBufferedReader(new BufferedReader(new InputStreamReader(cbmcProcess.getInputStream())), result);
			errReader = new ThreadedBufferedReader(new BufferedReader(new InputStreamReader(cbmcProcess.getErrorStream())), errors);
			
			outReader.start();
			errReader.start();

		try {
			cbmcProcess.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			outReader.interrupt();
			errReader.interrupt();
		
			Utils.deleteFile(fileName);
		}
		return result;
	}
	
	public static String getVScmdPath() throws IOException {
		
		Path x86 = new File("C:/Program Files (x86)").toPath();
		Path x64 = new File("C:/Program Files").toPath();
		String searchTerm = "Microsoft Visual Studio";
		String pathToBatch = "/Common7/Tools/VsDevCmd.bat";
		
		ArrayList<String> toSearch = new ArrayList<>();
		Files.list(x86).filter(Files::isReadable).filter(path -> path.toString().contains(searchTerm)).forEach(VSPath -> toSearch.add(VSPath.toString()));
		Files.list(x64).filter(Files::isReadable).filter(path -> path.toString().contains(searchTerm)).forEach(VSPath -> toSearch.add(VSPath.toString()));

		for (Iterator<String> iterator = toSearch.iterator(); iterator.hasNext();) {
			String toCheck = ((String) iterator.next()) + pathToBatch;
			
			if (Files.isReadable(new File(toCheck).toPath())) {
				return toCheck;
			}
		}
		
		String userInput = JOptionPane.showInputDialog("The progam was unable to find a Developer Command Prompt for Visual Studio. \n"
				                                     + " Please search for it on your own and paste the path to the batch-file here!");
		
		//important that the check against null is done first, so invalid inputs are caught without causing an error
		if (userInput != null && Files.isReadable(new File(userInput).toPath()) && userInput.contains("VsDevCmd.bat")) {
			return userInput;
		} else {
			System.err.println("The provided path did not lead to the command prompt. Shutting down now.");
			System.exit(1);
			return null;
		}
	}
}
