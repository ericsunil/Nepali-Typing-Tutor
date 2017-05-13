package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WoPS extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Data data;
	private TypingPanel typingPanel;
	private Time time;
	private JLabel lwps;
	private float wps;
	static int elapsedTime;
	static int division;
	static int x[] = { 0, 30, 60, 90, 120 };
	static int y[] = new int[5];

	public WoPS(Data data, TypingPanel typingPanel, Time time) {
		setPreferredSize(new Dimension(200, 40));
		setBackground(Color.white);
		this.typingPanel = typingPanel;
		this.time = time;
		this.data = data;
		data.addObserver(this);
		lwps = new JLabel("Keys per \nSeconds:");
		lwps.setFont(new Font("Arial", Font.BOLD, 14));
		add(lwps);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		lwps.setFont(new Font("Arial", Font.BOLD, 14));
		if (time.time == 0)
			lwps.setText("Keys per Seconds: 0");
		else {
			wps = (typingPanel.convertedText.length() + data.Mistakes)
					/ time.time;
			lwps.setText("Keys per Seconds: " + wps);
		}
		if (time.time == 0)
			y[0] = (int) wps;
		if (time.time == 5)
			y[1] = (int) wps;
		if (time.time == 10)
			y[2] = (int) wps;
		if (time.time == 15)
			y[3] = (int) wps;
		if (time.time == 20)
			y[4] = (int) wps;
	}

}
