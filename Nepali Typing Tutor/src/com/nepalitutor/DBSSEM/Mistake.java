package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class Mistake extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int width;
	private Data data;

	public Mistake(Data data) {
		setBackground(Color.white);
		setPreferredSize(new Dimension(200, 60));
		x = 0;
		y = 20;
		this.data = data;
		data.addObserver(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.drawString("Mistake: " + data.Mistakes, x, y);
		g.setColor(Color.BLACK);
		g.fillRect(x, y + 20, width, 20);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setWidth((data.Mistakes * 2));
		repaint();
	}

}
