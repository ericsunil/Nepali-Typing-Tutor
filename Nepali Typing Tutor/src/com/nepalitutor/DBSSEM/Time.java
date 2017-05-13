package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Time extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	int time;
	private int width;
	private int height;
	public Thread t = new Thread(this);

	public Time() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(200, 60));
		x = 0;
		y = 20;
		width = 0;
		height = 20;
	}

	public void startTime()
	{
		t.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.drawString("Time: " + Integer.toString(time) + "  " + "sec", x, y);
		g.setColor(Color.BLACK);
		g.fillRect(x, y + 10, width, height);
		repaint();
	}

	@Override
	public void run() {
		try {
			int i = 0;
			while (width <= 120) {
				Thread.sleep(1000);
				time = i++;
				width++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
