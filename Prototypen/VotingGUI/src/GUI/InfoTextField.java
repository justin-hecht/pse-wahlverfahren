package GUI;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class InfoTextField extends JScrollPane {
  
  JTextArea textField = new JTextArea();
  
  public InfoTextField(int width, int height) {
    textField.setSize(width, height);
    textField.setLayout(null);
    textField.setLineWrap(true);
    textField.setEditable(false);
    textField.setText("Lorem1 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem2 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem3 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem4 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem5 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem6 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem7 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem8 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem9 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem0 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem1 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem2 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem3 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem4 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem5 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem6 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem7 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem8 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem9 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm "
        + "Lorem0 ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirm ");
    this.setViewportView(textField);
   // this.setVerticalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
  }

}
