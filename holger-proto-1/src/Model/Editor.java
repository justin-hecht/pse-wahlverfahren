/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author boss
 */
public class Editor {
    private TextPaneWrapper textPane;
    
    public Editor(TextPaneWrapper textPane) {
        this.textPane = textPane;
    }
    
    public String getCodeAsText() throws BadLocationException {
        return textPane.getText();
    }
    
    public void setEditorWindow(TextPaneWrapper textPane) {
        this.textPane = textPane;
    }
}
