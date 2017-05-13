package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accuracy extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel accuracy;
	private Data data;

	public Accuracy(Data data) {
		setPreferredSize(new Dimension(200, 40));
		setBackground(Color.white);
		this.data = data;
		data.addObserver(this);
		accuracy = new JLabel("Accuracy");
		accuracy.setFont(new Font("Arial", Font.BOLD, 14));
		add(accuracy);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		accuracy.setFont(new Font("Arial", Font.BOLD, 14));
		accuracy.setText("Accuracy " + (100 - data.Mistakes) + "%");
	}

}
