package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;	

import javax.swing.JPanel;

public class AssertionStatusField extends JPanel implements WindowListener, ActionListener {

	StartButton start = new StartButton();
	private int id;
	private AssertionContainer parent;
	private boolean expanded = false;
	private InfoTextField textField;

	public AssertionStatusField(AssertionContainer parent, int id, int width, int height, int textHeight) {
		this.parent = parent;
		this.id = id;
		this.setLayout(null);
		this.setSize(width, height);
		this.add(start);
		this.setOpaque(true);
		start.setLocation((getWidth() / 10) * 1, (getHeight() - start.getHeight()) / 2);

		start.addActionListener(this);
		textField = new InfoTextField(width, textHeight);
		textField.setSize(width, textHeight);
		textField.setLocation(0, height);
		this.add(textField);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), 2);
		g.fillRect(0, getHeight() - 2, getWidth(), 2);
	}

	public void succes() {
		this.setBackground(Color.green);
		repaint();
	}

	public void fail() {
		this.setBackground(Color.red);
		super.repaint();
	}

	public void reset() {
		super.paintComponent(getGraphics());
		getGraphics().setColor(Color.green);
		this.setBackground(Color.white);
		super.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (expanded) {
			textField.setVisible(false);
			this.setSize(500, 50);
			parent.collapse(id);
			expanded = false;
		} else {
			textField.setVisible(true);
			this.setSize(500, 50 + 250);
			parent.clicked(id);
			expanded = true;
		}
	}

	public void collapse() {
		if (expanded) {
			textField.setVisible(false);
			this.setSize(500, 50);
			parent.collapse(id);
			expanded = false;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void updateID(int newID) {
		id = newID;
	}

}
