package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x[], y[];
	private int xOrigin, yOrigin;
	private int xScale, yScale;
	private int totalTime;
	private int division;

	public Graph(int x[], int y[]) {

		setSize(600,600);
		setLocation(200,200);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		this.x = x;
		this.y = y;

		xOrigin = 20;
		yOrigin = 480;
		totalTime = 20;
		division = 5;
		xScale = 3;
		yScale = 10;
		Scale(xScale, yScale);
		add(new Grapher());
	}

	public void Scale(int xScale, int yScale) {
		for (int i = 1; i < x.length; i++)
			x[i] *= xScale;
		for (int i = 1; i < y.length; i++)
			y[i] *= -yScale;
	}

	class Grapher extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(xOrigin, yOrigin, xOrigin, 0); // Verticle Line
			g.drawLine(0, yOrigin, 500, yOrigin); // Horizontal Line
			g.drawString("Time Vs Keys per Second",50,50);
			
			for (int i = 0; i <=100; i += 15)
				g.drawString(Integer.toString(i), xOrigin+i*xScale-3, yOrigin+10);	//For Time
			
			for (int i = 0; i <= totalTime; i += division)
				g.drawString(Integer.toString(i), xOrigin-3, yOrigin+10 - i * yScale);	//For wps
			
			for (int i = 0; i < x.length-1; i++) {
				g.setColor(Color.red);
				g.drawLine(x[i] + xOrigin, y[i] + yOrigin, x[i + 1] + xOrigin,
						y[i + 1] + yOrigin);
			}
		}
	}
}
