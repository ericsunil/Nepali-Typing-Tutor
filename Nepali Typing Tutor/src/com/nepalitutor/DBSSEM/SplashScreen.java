package com.nepalitutor.DBSSEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SplashScreen extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * 
	 */

	static JFrame frame;
	private int x = 0, y = 250;
	private int width = 0, height = 100;
	private int speed = 1;
	private Thread t = null;
	private static final Dimension SCREEN_RESOLUTION = Toolkit
			.getDefaultToolkit().getScreenSize();
	private final Dimension FRAME_SIZE = new Dimension(600, 300);
	private File file;
	private Image image;

	public SplashScreen() {
		setPreferredSize(FRAME_SIZE);
		file = new File("icon/splash.jpg");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t = new Thread(this);
		t.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, null);
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.drawString(Integer.toString((int) (((float) width / 600) * 100))
				+ "%", 10, 10);
		g.setColor(Color.MAGENTA);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString("Welcome to Nepali Typing Tutor", 0, 50);
		width += 1;
	}

	public static void main(String[] args) {
		frame = new JFrame();
		frame.setContentPane(new SplashScreen());
		frame.setUndecorated(true);
		frame.setLocation(SCREEN_RESOLUTION.width / 2 - ((int) (600 / 2)),
				SCREEN_RESOLUTION.height / 2 - ((int) (300) / 2));
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void run() {
		while (width < 600) {
			try {
				Thread.sleep(speed);
				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		frame.setVisible(false);
		new NepaliTypingTutor();
	}
}