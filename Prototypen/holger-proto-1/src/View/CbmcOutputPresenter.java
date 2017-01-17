/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.CbmcOutput;
import Model.ProgChecker;
import javax.swing.JTextArea;

/**
 *
 * @author boss
 */
public class CbmcOutputPresenter {
    private JTextArea textArea;
    
    public CbmcOutputPresenter(JTextArea textArea) {
        this.textArea = textArea;
    }
    
    public void presentOutputToUser(CbmcOutput output) {
        textArea.setText("");
        textArea.setRows(output.getErrorOutputAsText().size() + 
                output.getOutputAsText().size());
        textArea.append("cbmc output: " + '\n'+ '\n');
        for(String s: output.getOutputAsText()) {
            textArea.append(s + '\n');
        }
        textArea.append('\n'+ "cbmc errors: " + '\n'+ '\n');
        for(String s: output.getErrorOutputAsText()) {
            textArea.append(s + '\n');
        }
    }
}
