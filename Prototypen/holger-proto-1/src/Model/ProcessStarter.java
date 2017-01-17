/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Functionality to start a process via the terminal and receiving output. 
 * @author boss
 */
public class ProcessStarter {
    private ArrayList<String> currentProcessOutput = new ArrayList<String>();
      private ArrayList<String> currentProcessErrorOutput = new ArrayList<String>();
    
    public void startProcess(String processName, String arg) 
            throws IOException, InterruptedException {
        String[] arr = {arg};
        startProcess(processName, Utils.stringArrToList(arr));
    }
    
    public void startProcess(String processName, String[] args) 
            throws IOException, InterruptedException {
        startProcess(processName, Utils.stringArrToList(args));
    }
    
    public void startProcess(String processName, List<String> args)
            throws IOException, InterruptedException {
        List<String> argsForProcessBuilder = new ArrayList();
        argsForProcessBuilder.add(processName);
        argsForProcessBuilder.addAll(args);
        ProcessBuilder processBuilder = new ProcessBuilder(argsForProcessBuilder);
        Process process = processBuilder.start();
        process.waitFor();
        HandleProcessOutput(process);
    }
    
    private void HandleProcessOutput(Process process) {
        currentProcessOutput.clear();
        currentProcessErrorOutput.clear();

        BufferedReader input =
            new BufferedReader
              (new InputStreamReader(process.getInputStream()));
        BufferedReader error =
            new BufferedReader
              (new InputStreamReader(process.getErrorStream()));
        String line;
        
        try {         
            while ((line = input.readLine()) != null) {
                currentProcessOutput.add(line);                
            }
            while ((line = error.readLine()) != null) {
                currentProcessErrorOutput.add(line);                
            }         
   
            input.close();   
            error.close();
        } catch (IOException e) {
            System.err.println("error trying to get output of program");
            e.printStackTrace();
        } 
    }
    
    
    public List<String> getCurrentProcessOutput() {
        return currentProcessOutput;
    }
    
     public List<String> getCurrentProcessErrorOutput() {
        return currentProcessErrorOutput;
    }
}
