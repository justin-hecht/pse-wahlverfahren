/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author boss
 */
public class TextPaneWrapper {
    private JTextPane textPane;
    private StyledDocument doc;
    public TextPaneWrapper(JTextPane textPane) {
        this.textPane = textPane;
        doc = textPane.getStyledDocument();
    }
    
    public String getText() throws BadLocationException {
        return doc.getText(0, doc.getLength());
    }
}
