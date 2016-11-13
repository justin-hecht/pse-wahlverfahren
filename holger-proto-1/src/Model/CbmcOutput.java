/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author boss
 */
public class CbmcOutput {
    private List<String> outputAsText;
    private List<String> erroroutputAsText;
    public CbmcOutput(List<String> outputAsText, List<String> errorOutputAsText) {
        this.outputAsText = outputAsText;
        this.erroroutputAsText = errorOutputAsText;
    }
    
    public List<String> getOutputAsText() {
        return outputAsText;
    }
    
    
    public List<String> getErrorOutputAsText() {
        return erroroutputAsText;
    }
}
