package com.nepalitutor.DBSSEM;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TypingPanel extends JPanel implements Observer {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String convertedText = "";
	JTextArea text;

	public TypingPanel(Data data) {
		text = new JTextArea();
		text.setPreferredSize(new Dimension(750, 200));
		text.setText(convertedText);
		text.setEditable(false);
		text.setLineWrap(true);
		add(text);
		data.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		text.setText(convertedText);
	}
}
