package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainGUI extends JFrame{

	int height = 700;
	int width = 320;
	//höhe der einzelnen assertions
	int assertionHeight = 50;
	int actualHeight;
	customScrollbar  customScroll;
	
	//wie hoch die Textfelder sein sollen
	int openOffset = 250;
	
	AssertionContainer container;

	
	mainGUI() {
		init();
		actualHeight = (int) this.getContentPane().getSize().getHeight();
		customScroll = new customScrollbar(20, actualHeight);
		container = new AssertionContainer(this, assertionHeight, width - 20, actualHeight, openOffset, customScroll);
		this.add(container);
		container.setLocation(0,0);
		customScroll.setLocation(container.getWidth(), container.getY());
		this.add(customScroll);
		customScroll.addAdjustmentListener(container);
		customScroll.setVisible(true);
		this.repaint();
	}

	public void init() {
		this.setTitle("VotingUI");
		this.setBackground(Color.white);
		this.getContentPane().setBackground(Color.gray);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setSize(width + 16, 600);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new mainGUI();
	}
	
	public void refresh() {
		repaint();
	}
}
