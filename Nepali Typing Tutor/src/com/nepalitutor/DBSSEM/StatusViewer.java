package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StatusViewer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton start;

	public StatusViewer(Mistake mistake, final Time time, Accuracy accuracy,
			WoPS wopm,final Keyboard keyboard) {
		setPreferredSize(new Dimension(200, 200));
		setBackground(Color.white);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		start = new JButton("Start");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				keyboard.button[0].setFocusable(true);
				keyboard.button[0].requestFocus(true);
				time.startTime();
				start.setEnabled(false);
			}
		});
		
		add(start);
		add(mistake);
		add(time);
		add(accuracy);
		add(wopm);
	}

}
