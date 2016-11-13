/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CbmcOutput;
import Model.Editor;
import Model.ProgChecker;
import Model.TextPaneWrapper;
import View.CbmcOutputPresenter;
import View.MainFrame;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 *
 * @author boss
 */
public class Communicator {
    private MainFrame mFrame;
    private CbmcOutputPresenter outputPresenter;
    private Editor editor;
    
    private ProgChecker progChecker = new ProgChecker();
    
    public Communicator(MainFrame mFrame) {
        this.mFrame = mFrame;        
        this.editor = new Editor(new TextPaneWrapper(mFrame.getTextPane()));
        this.outputPresenter = new CbmcOutputPresenter(mFrame.getTextArea());
    }
    
    public void handle_CheckCodeButtonPressed(java.awt.event.ActionEvent evt) {
        try {
            CbmcOutput output = progChecker.checkProgram(editor.getCodeAsText());
            outputPresenter.presentOutputToUser(output);
        } catch (BadLocationException ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
