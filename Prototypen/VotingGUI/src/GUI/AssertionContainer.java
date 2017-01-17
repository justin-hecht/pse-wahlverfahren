package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AssertionContainer extends JPanel implements AdjustmentListener{
	
	int width;
	int height;
	
	int assertionHeight = 50;
	int openOffset = 250;
	
	int totalHeight = 0;
	
	customScrollbar scrollBar;
	
	int lastPos = 0;
	
	mainGUI parent;
	// the height of each text field that can be opened.
	// should be depend on the absolute size later on
	
	//JPanel panel = new JPanel();
	
	//ArrayList<AssertionStatusField> elements = new ArrayList<AssertionStatusField>();

	public AssertionContainer(mainGUI parent, int assertionHeight, int width, int height, int openOffset, customScrollbar scrollBar) {
		this.parent = parent;
		this.assertionHeight = assertionHeight;
		this.width = width;
		this.openOffset = openOffset;
		this.scrollBar = scrollBar;
        this.setLayout(null);
		this.setSize(width, height);
		this.setLayout(null);
		this.setLocation(0, 0);


		int testAdd = 12;
		for (int i = 0; i < testAdd; i++) {
			AssertionStatusField temp = new AssertionStatusField(this, i, width, assertionHeight, openOffset);
			temp.setLocation(0, 50 * i);
			this.addAssertionElement(temp);
		}
		
		this.setVisible(true);
		
		assertions.get(0).fail();
		assertions.get(1).succes();
		assertions.get(2).succes();
		assertions.get(3).fail();
		assertions.get(4).succes();
		
		redraw();

	}

	ArrayList<AssertionStatusField> assertions = new ArrayList<AssertionStatusField>();

	public void clicked(int id) {
		totalHeight = totalHeight + openOffset;
		checkTotalHeight();
		pushFrom(id);
		redraw();
	}

	public void pushFrom(int id) {
		// don't push away the object that was clicked, but the all the
		// following ones. Therefore the +1
		id = id + 1;
		for (int i = id; i < assertions.size(); i++) {
			AssertionStatusField comp = assertions.get(i);
			assertions.get(i).setLocation(0, (int) (comp.getLocation().getY() + openOffset));
		}
	}

	public void pullFrom(int id) {
		// dont pull away the object that was clicked
		id = id + 1;
		for (int i = id; i < assertions.size(); i++) {
			Component comp = assertions.get(i);
			comp.setLocation(0, (int) (comp.getLocation().getY() - openOffset));
		}
	}

	public void collapse(int id) {
		totalHeight = totalHeight - openOffset;
		checkTotalHeight();
		pullFrom(id);
		redraw();
	}

	public void redraw() {
		for (int i = 0; i < assertions.size(); i++) {
			this.remove(assertions.get(i));
		}
		for (int i = 0; i < assertions.size(); i++) {
			this.add(assertions.get(i));
//			assertions.get(i).setVisible(true);
		}
		this.validate();
		this.repaint();
	//	parent.repaint();
	}
	
	public void addScrollbar(customScrollbar bar) {
		this.scrollBar = bar;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		int pos = scrollBar.getValue();
		//move the selected element to the upper bound
		moveAllElementsBy(-assertions.get(pos).getY());
	}
	
	public void addAssertionElement(AssertionStatusField field) {
		closeAll();
		AssertionStatusField temp = new AssertionStatusField(this, assertions.size(), width, assertionHeight, openOffset);
		temp.setLocation(0, 50 * assertions.size());
		assertions.add(temp);
		totalHeight = totalHeight + assertionHeight * assertions.size();
		scrollBar.setMaximum(assertions.size() - 1);
		redraw();
	}
	
	public void removeAssertionElement(AssertionStatusField field) {
		closeAll();
		int id = assertions.indexOf(field);
		//pull the other ones up
		pullFrom(id);
		updateIDsFrom(id);
		assertions.remove(field);
		totalHeight = totalHeight - assertionHeight * assertions.size();
		scrollBar.setMaximum(assertions.size() - 1);
		redraw();
	}
	
	private void updateIDsFrom(int id) {
		for (int i = id + 1; i < assertions.size(); i++) {
			assertions.get(i).updateID(i - 1);
		}
	}

	//moves all elements either up or down, just like scrolling
	public void moveAllElementsBy(int distance) {
		for (int id = 0; id < assertions.size(); id++) {
			AssertionStatusField temp = assertions.get(id);
			temp.setLocation(0, temp.getY() + distance);
		}
	}
	

	public void closeAll() {
		for (int id = 0; id < assertions.size(); id++) {
			assertions.get(id).collapse();
		}
		//reset the height
		totalHeight = assertionHeight * assertions.size();
		checkTotalHeight();
	}

	private void checkTotalHeight() {
		if(totalHeight > height) {
//			scrollBar.setVisible(true);
			scrollBar.setMaximum(assertions.size() - 1);
		} if(lastPos != 0) {
//			scrollBar.setVisible(false);
			if(assertions.size() > 0) {
				//move it back to the top position
				scrollBar.setMaximum(assertions.size() - 1);
				moveAllElementsBy(-assertions.get(0).getY());
				lastPos = 0;
			}
		} else {
//			scrollBar.setVisible(false);
			if(assertions.size() > 0) {
				scrollBar.setMaximum(assertions.size() - 1);
			}
		}
	}	
}
