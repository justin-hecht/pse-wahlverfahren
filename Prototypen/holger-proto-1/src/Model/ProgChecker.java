/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boss
 */
public class ProgChecker {
    private ProcessStarter pStarter = new ProcessStarter();
    public CbmcOutput checkProgram(String c_code) 
            throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException {
        String relPath = System.getProperty("user.dir");
        String fileName = ".temp_file_for_checking.c";
        String processName = "cbmc";
        System.out.println(relPath + "/" + fileName);
        Utils.writeStringToFile(c_code, relPath, fileName);
        
        
        String[] argsToPass = {fileName};
        pStarter.startProcess(processName, argsToPass);
        
        return new CbmcOutput(pStarter.getCurrentProcessOutput(), 
                pStarter.getCurrentProcessErrorOutput());
    }
}
